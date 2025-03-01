package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    // 테스트를 먼저 만들고 클래스를 만드면 TDD
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝나면 실행되는 메서드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    // 모든 테스트는 메서드 순서와 상관 없이 동작
    // 테스트가 끝나면 메모리를 초기화해야 함
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // System.out.println("(result == Member) = " + (result == member));

        // Assertion - jupiter
        // Assertions.assertEquals(member, result);

        // Assertion - core api
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
