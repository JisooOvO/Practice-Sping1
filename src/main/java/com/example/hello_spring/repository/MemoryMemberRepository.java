package com.example.hello_spring.repository;

import com.example.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository {

    // 실무에서는 동시성 문제 고려
    // ㄴ 공유되는 맵을 쓸 경우 ConcurrentHashMap 사용
    // ㄴ 동시성 문제를 고려한 AtomicLong 사용
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null일 경우 Optional.ofNullable로 Wrap
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
