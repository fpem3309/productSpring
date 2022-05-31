package com.home.prospring.controller;

import com.home.prospring.domain.Member;
import com.home.prospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //Spring 컨테이너에서 memberService를 가져옴, MemberService에서 @Service 어노테이션을 해야함 ( DI )
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> memberList = memberService.findMembers();
        model.addAttribute("members",memberList);
        return "members/memberList";
    }
}
