package com.home.prospring.repostory;

import com.home.prospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDJRepository extends JpaRepository<Member, Long> {
    boolean existsByName(String name);
}
