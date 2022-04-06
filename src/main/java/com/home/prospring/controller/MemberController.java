package com.home.prospring.controller;

import com.home.prospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //Spring 컨테이너에서 memberService를 가져옴, MemberService에서 @Service 어노테이션을 해야함 ( DI )
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
