package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.c4c.controller.form.DetailForm;
import jp.co.c4c.service.DetailService;

@Controller
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    DetailService detailService;

    @RequestMapping
    public String init(@RequestParam("bookId") int bookId, Model model, DetailForm form) {
        DetailForm detailForm = detailService.getBookById(bookId);
        model.addAttribute("detailForm", detailForm);
        return "detail";

    }
}
