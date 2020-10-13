package jp.co.c4c.controller.ctrl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dto.BK_T_FavoriteDto;
import jp.co.c4c.db.dto.BK_T_LendDto;
import jp.co.c4c.db.dto.V_LendHistoryDto;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.MyService;
import jp.co.c4c.service.TopService;

@Controller
@RequestMapping("/top")
@SessionAttributes("webSessionDto")
public class TopController {

    @Autowired
    TopService topService;
    @Autowired
    CommonService commonService;
    @Autowired
    MyService myService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto){
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, TopForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        // 全ての本のリストをfromにセット
        form.setTopAndDetailDtoList(topService.getAllBooks());

        int memId = webSessionDto.getMemId();

        // ログインユーザーがお気に入りしている本のリストformにセット
        List<BK_T_FavoriteDto> bk_T_FavoriteDtoList = topService.getFavoriteBooks(memId);
        List<Integer> myFavoriteBookIdList = bk_T_FavoriteDtoList.stream()
                .map(BK_T_FavoriteDto::getBookId)
                .collect(Collectors.toList());
        form.setMyFavoriteBookIdList(myFavoriteBookIdList);

        // ログインユーザーが読書済みの本のリストを取得
        List<V_LendHistoryDto> bk_T_LendDtoList = topService.getlendedBooks(memId);
        List<Integer> myLendedBookIdList = bk_T_LendDtoList.stream()
                .map(V_LendHistoryDto::getBookId)
                .collect(Collectors.toList());
        form.setMyLendedBookIdList(myLendedBookIdList);

        /* tagIdを文字列に変換 */
        for (int i = 0; i < form.getTopAndDetailDtoList().size(); i++) {
            String[] tagIds = form.getTopAndDetailDtoList().get(i).getTagIds().split(",");
            convertTag(tagIds);
            form.getTopAndDetailDtoList().get(i).setTagIds(String.join(",", tagIds));
        }

        // お知らせメッセージ_貸出期限通知用の情報を取得
        List<BK_T_LendDto> lendNewsList = topService.getLendNewsByMemId(memId);
        form.setLendNewsList(lendNewsList);

        int LendingCnt = form.getCountMyLendingBookList();
        model.addAttribute("LendingCnt", LendingCnt);

         // お知らせ既読状態取得
//        form.setReadStatusNews(topService.getNewOfferBooks(memId));

        // お知らせメッセージ_本入荷通知の情報を取得
//        List<BK_M_BookDto> offerBookNewsList = topService.getofferBookNewsList();
//        form.setLendNewsList(lendNewsList);

        // お知らせ既読状態更新
       //  form.setBK_T_NewsReadDto(topService.getNews(memId));

        return "top";
    }

    /**
     * tagIdを文字列に変換するメソッド（作成中）
     * @param strings
     * @return
     */
    public String[] convertTag (String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "1":
                    strings[i] = "Java"; // 定数に入れ替える
                    break;
                case "2":
                    strings[i] = "PHP";
                    break;
                default:
                    break;
            }
        }
        return strings;
    }

}
