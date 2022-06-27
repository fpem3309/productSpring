package com.home.prospring.controller;

import com.home.prospring.CheckUsernameValidator;
import com.home.prospring.domain.Member;
import com.home.prospring.repostory.MemberRepository;
import com.home.prospring.service.MemberService;
import com.home.prospring.service.UserService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    //private CheckUsernameValidator checkUsernameValidator;

    /** 커스텀 유효성 검증*/
//    @InitBinder //특정 컨트롤러에서 바인딩 또는 검증 설정을 변경하고 싶을 때 사용한다.
//    public void validatorBinder(WebDataBinder binder) { //HTTP 요청 정보를 컨트롤러 메소드의 파라미터나 모델에 바인딩할 때 사용되는 바인딩 객체
//        binder.addValidators(checkUsernameValidator);
//    }

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
    public int idCheck(@RequestParam String name){
        int cnt = userService.idCheck(name);
        System.out.println(cnt);
        return cnt;
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

        System.out.println(member);

        userService.save(member);
        return "redirect:/";
    }

}
