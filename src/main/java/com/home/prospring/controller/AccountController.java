package com.home.prospring.controller;

import com.home.prospring.domain.Member;
import com.home.prospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @GetMapping("/register")
    public String register(){
        return "account/register";
    }

    @ResponseBody
    @GetMapping("/check")
    public String nameCheck(@RequestParam String name, @RequestParam String email, @RequestParam String nickname){
        int nameCnt = userService.idCheck(name);
        int emailCnt = userService.emailCheck(email);
        int nickCnt = userService.nickCheck(nickname);
        String result = nameCnt+"|"+emailCnt+"|"+nickCnt;

        return result;
    }

    @PostMapping("/register")
    public String register(@Valid Member member, Errors errors, Model model){
        if (errors.hasErrors()) {

            /** 회원가입 실패시, 입력 데이터를 유지 */
            model.addAttribute("wrote", member);

            /** 유효성 통과 못한 필드와 메시지를 핸들링 */
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "account/register";
        }
        /** 중복 검사  */
        userService.checkNameDuplication(member);

        userService.save(member);

        return "redirect:/";
    }

}
