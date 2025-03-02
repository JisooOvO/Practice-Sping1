package com.example.hello_spring.controller;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


// 스프링 빈을 등록하는 2가지 방법 - (기본) 싱글톤으로 등록 - 변경 가능
//   ㄴ Component(Service, Controller, Repository) Scan
//      ㄴ Autowired는 각 Component 를 연결 - 스프링 빈에 등록되어야 함
//      ㄴ 정형화 된 코드
//
//   ㄴ 자바 코드로 직접 스프링 빈 등록
//      ㄴ Configuration / Bean
//      ㄴ 상황에 따라 클래스를 변경할 필요가 있다면

@Controller
public class MemberController {

    private final MemberService memberService;

    // 필드 주입 - 뭔가 바꿀 수 없음
    // @Autowired private MemberService memberService;

    // 세터 주입 - 중간에 바뀔 일이 있음
    // @Autowired
    // public void setMemberService(MemberService memberService) {
    //     this.memberService = memberService;
    // }

    // 스프링 빈에 등록되어 있는 스프링 컨테이너에서 서비스를 가져온다.
    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    // form method : post
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        System.out.println(form.getName());

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);

        return "members/memberList";
    }
}
