package com.example.hello_spring.controller;

import com.example.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


// 스프링 빈을 등록하는 2가지 방법 - (기본) 싱글톤으로 등록 - 변경 가능
//   ㄴ Component(Service, Controller, Repository) Scan
//      ㄴ Autowired 는 각 Component 를 연결
// 
//   ㄴ 자바 코드로 직접 스프링 빈 등록
//
@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링 빈에 등록되어 있는 스프링 컨테이너에서 서비스를 가져온다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
