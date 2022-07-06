package com.home.prospring.repostory;

import com.home.prospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDJRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);

    long countByName(String name);

    long countByEmail(String email);

    long countByNickname(String nickname);
}
