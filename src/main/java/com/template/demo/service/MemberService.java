package com.template.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.template.demo.domain.Member;
import com.template.demo.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) { 
        validateDuplicateMember(member); // 중복된 이름 X

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 1번 
        // Optional<Member> result = memberRepository.findByName(member.getNmae());
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재하는 회원입니다.");
        // }); 

        // 2번(1번 코드 최적화)
        memberRepository.findByName(member.getNmae()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회 
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
