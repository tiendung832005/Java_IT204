package com.data.session07.controller.Bai5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping("/contact")
    public String showContact() {
        return "contact";
    }
}
