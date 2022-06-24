package com.home.prospring;

import com.home.prospring.domain.Member;
import com.home.prospring.repostory.UserDJRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CheckUsernameValidator extends AbstractValidator<Member> {

    private final UserDJRepository userDJRepository;

    public CheckUsernameValidator(UserDJRepository userDJRepository) {
        this.userDJRepository = userDJRepository;
    }

    @Override
    protected void doValidate(Member member, Errors errors) {
        if (userDJRepository.existsByName(member.getName())) {
            errors.rejectValue("name", "아이디 중복 오류", "이미 사용중인 아이디 입니다.");
        }
    }
}
