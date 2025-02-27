package com.example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// controller
@Controller
public class HelloController {
    // http get request
    @GetMapping("hello")
    public String hello(Model model) {
        // key : data
        // value : hello!!
        model.addAttribute("data", "ㅇㅅㅇ");
        // 컨트롤러에서 문자열이 return되면 viewResolver 가 화면을 찾아서 처리
        // resources/templates + hello + .html rendering
        return "hello";
    }
}

