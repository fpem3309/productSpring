package com.home.prospring.repostory;

import com.home.prospring.domain.NCAmericaBoard;
import com.home.prospring.domain.SAmericaBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SAmericaDJRepository extends JpaRepository<SAmericaBoard, Long> {

    @Modifying
    @Query("update SAmericaBoard m set m.samericaHit = m.samericaHit + 1 where m.samericaId = :id")
    int updateCount(@Param("id") int id);

    //Page<MainBoard> findByTitleContainingOrContentContaining(String mainProductTitle, String mainProductContent, Pageable pageable);
    Page<SAmericaBoard> findBySamericaCategory(String samericaCategory, Pageable pageable);
}
