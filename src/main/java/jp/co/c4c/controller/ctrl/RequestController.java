package jp.co.c4c.controller.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.RequestForm;
import jp.co.c4c.db.dto.V_MyFavoriteBookDto;
import jp.co.c4c.db.dto.V_MyCheerBookDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.RequestService;

@Controller
@RequestMapping("/request")
@SessionAttributes("webSessionDto")
public class RequestController {

    @Autowired
    RequestService requestService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto) {
        return webSessionDto;
    }


    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, RequestForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        int memId = webSessionDto.getMemId();

        // ログインユーザーがお気に入りしている本のリストformにセット
        List<V_MyCheerBookDto> bk_T_CheerDtoList = requestService.getCheerBooks(memId);
        List<Integer> myCheerBookIdList = bk_T_CheerDtoList.stream()
                .map(V_MyCheerBookDto::getRequestId)
                .collect(Collectors.toList());
        form.setMyCheerBookIdList(myCheerBookIdList);

        form.setReqInfoList(requestService.getRequestList());

        return "request";
    }

}
