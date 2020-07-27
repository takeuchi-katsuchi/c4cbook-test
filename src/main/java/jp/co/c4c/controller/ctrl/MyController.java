package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.MyForm;
import jp.co.c4c.service.MyService;

@Controller
@RequestMapping("/mypage")
public class MyController {

    @Autowired
    MyService myService;

    @RequestMapping
    public String init(Model model, MyForm form) {

        model.addAttribute("count", "8");

//      // 現在の時間を格納
//      model.addAttribute("now", LocalDateTime.now());

        // formに格納する
        form.setCount("15");

        return "mypage";
    }
}
