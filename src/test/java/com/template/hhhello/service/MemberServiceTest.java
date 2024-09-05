package com.template.hhhello.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.template.hhhello.domain.Member;
import com.template.hhhello.repository.MemoryMemberRepository;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    // 각 테스트 메서드는 독립적으로 실행되므로, 
    // 각 테스트가 끝난 후 저장소를 비워서 상태를 초기화해야 함.

    @Test
    void testJoin() {
        // given 
        Member member = new Member();
        member.setName("java");

        // when
        Long saveId = memberService.join(member);

        // then 
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getNmae()).isEqualTo(findMember.getNmae());
    }

    @Test
    public void testJoinException() {
        // given 
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        // 1번 
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // 2번 
        // try {
        //     memberService.join(member2);
        //     fail();
        // } catch(IllegalStateException e) {
        //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }

        // then 
    }

    @Test
    void testFindAll() {
        // given 

        // when

        // then 
    }

    @Test
    void testFindOne() {
        // given 

        // when

        // then 
    }
}
