package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.TopForm;
import jp.co.c4c.service.TopService;

@Controller
@RequestMapping("/top")
public class TopController {

    @Autowired
    TopService topService;

    @RequestMapping
    public String init(Model model, TopForm form) {
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
