package com.template.hhhello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.template.hhhello.repository.MemberRepository;
import com.template.hhhello.repository.MemoryMemberRepository;
import com.template.hhhello.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean 
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
