package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    // select m from Member m where m.name = ?
    Optional<Member> findByName(String name);
}
