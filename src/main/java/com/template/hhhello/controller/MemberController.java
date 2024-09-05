package com.template.hhhello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.template.hhhello.domain.Member;
import com.template.hhhello.service.MemberService;


import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        System.out.println("home controller");
        return "members/createMemberForm";
    }
    
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        System.out.println(member);
        return "redirect:/"; // home 화면으로 돌아가기 
    }
    
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberListForm";
   }
}
