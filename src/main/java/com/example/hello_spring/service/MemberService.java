package com.example.hello_spring.service;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.repository.MemberRepository;
import com.example.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 스프링 빈에 서비스 등록
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // Dependency Injection (DI)
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * @param member 회원
     * @return 회원 ID
     */
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     * @return 전체 회원 List
     */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    /**
     * ID와 일치하는 회원 조회
     * @param memberId 회원 ID
     * @return 회원
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    /**
     * 중복 회원 이름 검증
     * @param member 회원
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
}
