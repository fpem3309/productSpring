package com.home.prospring.service;

import com.home.prospring.domain.Member;
import com.home.prospring.domain.Role;
import com.home.prospring.repostory.MemberRepository;
import com.home.prospring.repostory.UserDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service    //비즈니스 로직 작성, 테스트
public class UserService {
    private final MemberRepository memberRepository;

    @Autowired
    private UserDJRepository userDJRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Member save(Member member){
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);    // 암호화
        member.setEnabled(true);

        Role role = new Role();
        role.setId(1l);
        member.getRoles().add(role);
        return userDJRepository.save(member);
    }

    /** 회원가입 시, 유효성 체크 */
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    /** 아이디, 닉네임, 이메일 중복 여부 확인 */
    public void checkNameDuplication(Member member) {
        boolean nameDuplicate = userDJRepository.existsByName(member.getName());
        if (nameDuplicate) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    public int idCheck(String name){
        int cnt = (int)userDJRepository.countByName(name);
        return cnt;
    }

    public int emailCheck(String name){
        int cnt = (int)userDJRepository.countByEmail(name);
        return cnt;
    }

    public int nickCheck(String name){
        int cnt = (int)userDJRepository.countByNickname(name);
        return cnt;
    }

}
