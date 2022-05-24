package com.home.prospring.repostory;

import com.home.prospring.domain.MEAsiaBoard;
import com.home.prospring.domain.NCAmericaBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NCAmericaDJRepository extends JpaRepository<NCAmericaBoard, Long> {

    @Modifying
    @Query("update NCAmericaBoard m set m.ncamericaHit = m.ncamericaHit + 1 where m.ncamericaId = :id")
    int updateCount(@Param("id") int id);

    //Page<MainBoard> findByTitleContainingOrContentContaining(String mainProductTitle, String mainProductContent, Pageable pageable);
    Page<NCAmericaBoard> findByNcamericaCategory(String ncamericaCategory, Pageable pageable);
}
