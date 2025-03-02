package com.example.hello_spring.controller;

// modelAttribute로 동작
// http 파라미터를 가져와서 필드와 매칭
public class MemberForm {
    // 프로퍼티 이름은 같을 필요 없으나
    private  String name;

    public String getName() {
        return name;
    }

    // 자바 빈 규약의 세터와 파라미터 이름이 일치할 경우 자동으로 매칭
    // 일치하는 세터가 없으면 null 반환
    public void setName(String name) {
        this.name = name;
    }
}
