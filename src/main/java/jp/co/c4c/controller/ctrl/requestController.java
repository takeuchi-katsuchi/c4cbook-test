package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.RequestForm;
import jp.co.c4c.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {

	@Autowired
	RequestService RequestService;

	@RequestMapping
	public String init(Model model, RequestForm form) {

	    model.addAttribute("message", "要望ページ");

	 // formに格納する
        form.setMessage("要望ページ");

		return "request";
	}

}
