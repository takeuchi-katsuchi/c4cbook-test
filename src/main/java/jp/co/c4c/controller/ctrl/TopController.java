package jp.co.c4c.controller.ctrl;

import java.util.List;

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
        List<TopForm> topForms = topService.getAllBooks();
        model.addAttribute("topForms", topForms);
        return "top";
    }
}
