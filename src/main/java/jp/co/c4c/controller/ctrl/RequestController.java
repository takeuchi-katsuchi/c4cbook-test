package jp.co.c4c.controller.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.c4c.controller.form.RequestForm;
import jp.co.c4c.db.dto.WebSessionDto;
import jp.co.c4c.service.CommonService;
import jp.co.c4c.service.RequestService;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    RequestService requestService;
    @Autowired
    CommonService commonService;

    @RequestMapping
    public String init(@ModelAttribute("webSessionDto") WebSessionDto webSessionDto, Model model, RequestForm form) {
        // ログインチェック
        boolean isLogined = commonService.isLogined(webSessionDto);
        if (!isLogined) return "redirect:login";

        form.setReqInfoList(requestService.getRequestList());

        return "request";
    }

}
