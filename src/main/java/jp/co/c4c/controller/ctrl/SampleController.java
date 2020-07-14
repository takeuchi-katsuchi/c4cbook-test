package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.SampleForm;
import jp.co.c4c.service.SampleService;

@Controller
@RequestMapping("/")
public class SampleController {

	@Autowired
    SampleService sampleService;

	@RequestMapping
	public String init(Model model, SampleForm form) {

	    model.addAttribute("message", "Model から Hello World");

//	    // 現在の時間を格納
//	    model.addAttribute("now", LocalDateTime.now());

	    // formに格納する
	    form.setMessage("Form から Hello World");

		return "sample";
	}

    @RequestMapping(value="sendMessage1")
    public String sendMessage1(Model model, SampleForm form) {
        System.out.println(form.getMessage());

        return "sample";
    }

    @RequestMapping(value="sendMessage2")
    public String sendMessage2(Model model, SampleForm form) {
        System.out.println(form.getMessage());

        return "sample";
    }
}
