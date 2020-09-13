package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.TopService;

@Controller
@RequestMapping("/top")
@SessionAttributes("webSessionDto")
public class TopController {

    @Autowired
    TopService topService;
    @Autowired
    CommonService commonService;

    //セッションのオブジェクト代入格納メソッド
    @ModelAttribute("webSessionDto")
    public WebSessionDto setWebSessionDto(WebSessionDto webSessionDto){
        return webSessionDto;
    }

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, TopForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        form.setTopAndDetailDtoList(topService.getAllBooks());

        /* tagIdを文字列に変換 */
        for (int i = 0; i < form.getTopAndDetailDtoList().size(); i++) {
            String[] tagIds = form.getTopAndDetailDtoList().get(i).getTagIds().split(",");
            convertTag(tagIds);
            form.getTopAndDetailDtoList().get(i).setTagIds(String.join(",", tagIds));
        }

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
