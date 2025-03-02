package com.example.hello_spring;

import com.example.hello_spring.repository.JdbcMemberRepository;
import com.example.hello_spring.repository.JdbcTemplateMemberRepository;
import com.example.hello_spring.repository.MemberRepository;
import com.example.hello_spring.repository.MemoryMemberRepository;
import com.example.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 직접 등록
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // 레포지토리를 변경해야 할 경우 이거만 변경

        // Memory
        // return new MemoryMemberRepository();

        // JDBC
        // return new JdbcMemberRepository(dataSource);

        // JDBC Template
        return  new JdbcTemplateMemberRepository(dataSource);
    }
}
