package com.example.hello_spring;

import com.example.hello_spring.repository.*;
import com.example.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 직접 등록
@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // JpaRepository를 찾아서 Bean에 등록
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        // 레포지토리를 변경해야 할 경우 이거만 변경
//
//        // Memory
//        // return new MemoryMemberRepository();
//
//        // JDBC
//        // return new JdbcMemberRepository(dataSource);
//
//        // JDBC Template
//        // return  new JdbcTemplateMemberRepository(dataSource);
//
//        // JPA
//        // return new JpaMemberRepository(em);
//
//
//    }
}
