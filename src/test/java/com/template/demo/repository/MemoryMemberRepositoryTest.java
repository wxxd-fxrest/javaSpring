package com.template.demo.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.template.demo.domain.Member;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    // 각 테스트 메서드는 독립적으로 실행되므로, 
    // 각 테스트가 끝난 후 저장소를 비워서 상태를 초기화해야 함.

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        // 저장된 멤버와 결과 멤버가 동일한지 확인
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        // 저장된 이름으로 검색한 결과가 member1과 동일한지 확인
        Assertions.assertThat(result).isEqualTo(member1);
    } 

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        // 저장된 멤버의 수가 2인지 확인
        Assertions.assertThat(result.size()).isEqualTo(2);
    } 
}