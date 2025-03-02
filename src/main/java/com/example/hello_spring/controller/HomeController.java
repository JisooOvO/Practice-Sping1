package com.example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 우선순위 controller > static
    @GetMapping("/")
    public String Home(){
        return "home";
    }
}
