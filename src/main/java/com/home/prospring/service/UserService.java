package com.home.prospring.service;

import com.home.prospring.domain.Member;
import com.home.prospring.domain.Role;
import com.home.prospring.repostory.UserDJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service    //비즈니스 로직 작성, 테스트
public class UserService {

    @Autowired
    private UserDJRepository userDJRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member save(Member member){
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);    // 암호화
        member.setEnabled(true);

        Role role = new Role();
        role.setId(1l);
        member.getRoles().add(role);
        return userDJRepository.save(member);
    }

}
