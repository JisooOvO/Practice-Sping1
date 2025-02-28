package com.example.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";

    }

    @GetMapping("hello-string")
    @ResponseBody // response - body 로 리턴 값을 넣어주겠다. -> HTML이 아닌 값 그대로 반환
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // Http body
    /*
    *
    *  // 클라이언트의 Http Accept 헤더와 반환 타입을 조합해서 컨버터 타입 결정
    *  @ResponseBody를 만나면
    *       ㄴ HttpMessageConverter 가 동작
    *           ㄴ 객체면    MappingJackson2HttpMessageConverter
    *           ㄴ 문자열이면 StringHttpConverter
    *           ㄴ ... 등등 등록되어 있음
    *
    *  class to json library
    *       ㄴ jackson2 -> spring 채택
    *       ㄴ gson
    *
    **/
    // 클래스 반환 시 JSON 객체로 전송 (default)
    private Hello HelloAPi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

