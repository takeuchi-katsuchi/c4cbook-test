package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.requestForm;
import jp.co.c4c.service.SampleService;

@Controller
@RequestMapping("/")
public class requestController {

	@Autowired
    SampleService requestService;

	@RequestMapping
	public String init(Model model, requestForm form) {

		return "request";
	}

}
