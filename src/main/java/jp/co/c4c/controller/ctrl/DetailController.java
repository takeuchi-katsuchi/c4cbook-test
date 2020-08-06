package jp.co.c4c.controller.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.DetailForm;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @RequestMapping
    public String init(Model model, DetailForm form) {

        return "detail";
    }
}
