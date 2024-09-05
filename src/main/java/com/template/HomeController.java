package com.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getMethodName() {
        System.out.println("home controller");
        return "index";
    }
}
