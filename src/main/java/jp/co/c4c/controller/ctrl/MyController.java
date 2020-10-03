package jp.co.c4c.controller.ctrl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.constant.LendStatus;
import jp.co.c4c.controller.form.MyForm;
import jp.co.c4c.db.dto.V_MyPageDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.MyService;

@Controller
@RequestMapping("/mypage")
@SessionAttributes("webSessionDto")
public class MyController {

    @Autowired
    MyService myService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, MyForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        int memId = webSessionDto.getMemId();

        // ログインユーザーの貸出・予約履歴全件取得
        List<V_MyPageDto> myPageDtoList = myService.getBooksByMemId(memId);

        //////////////////////////////////////////////
        // ログインユーザーが予約中の本で絞り込み
        //////////////////////////////////////////////
        List<V_MyPageDto> myResevedBookList = myPageDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.RESERVED.getLendStatus())
                .collect(Collectors.toList());

        //////////////////////////////////////////////
        // ログインユーザーが借りている本で絞り込み
        //////////////////////////////////////////////
        List<V_MyPageDto> myLendingBookList = myPageDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.LENDING.getLendStatus())
                .collect(Collectors.toList());

        //////////////////////////////////////////////
        // ログインユーザーが返却済み（読書済み）の本で絞り込み
        //////////////////////////////////////////////
        List<V_MyPageDto> myAllReturnedBookList = myPageDtoList.stream()
                .filter(obj -> obj.getLendStatus() == LendStatus.RETURNED.getLendStatus())
                .collect(Collectors.toList());

        // 画面に表示させる編集後の返却済み（読書済み）の本
        List<V_MyPageDto> editedMyReturnedBookList = new ArrayList<>();

        // BookIdのリストを取得
        List<Integer> bookIdList = myAllReturnedBookList.stream()
                .map(V_MyPageDto::getBookId)
                .collect(Collectors.toList());
        // 重複しているBookIdを削除
        List<Integer> trimedBookIdList = new ArrayList<>(new LinkedHashSet<>(bookIdList));
        for (int i = 0; i < trimedBookIdList.size(); i ++) {
            int index = i;
            // BookIdに該当する先頭のObjをeditedMyReturnedBookListに追加
            Optional<V_MyPageDto> optional = myAllReturnedBookList.stream()
                .filter(obj -> obj.getBookId() == trimedBookIdList.get(index))
                .findFirst();
            optional.ifPresent(obj -> editedMyReturnedBookList.add(obj));
        }

        // ログインユーザーが読書済みの本の数
        String readBookCount = String.valueOf(trimedBookIdList.size());

        form.setCount(readBookCount);
        form.setMyResevedBookList(myResevedBookList);
        form.setMyLendingBookList(myLendingBookList);
        form.setMyReturnedBookList(editedMyReturnedBookList);

        return "mypage";
    }
}
