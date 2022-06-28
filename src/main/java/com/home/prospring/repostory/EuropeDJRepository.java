package com.home.prospring.repostory;

import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.EuropeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EuropeDJRepository extends JpaRepository<EuropeBoard, Long> {

    @Modifying
    @Query("update EuropeBoard m set m.europeHit = m.europeHit + 1 where m.europeId = :id")
    int updateCount(@Param("id") int id);

    //Page<MainBoard> findByTitleContainingOrContentContaining(String mainProductTitle, String mainProductContent, Pageable pageable);
    Page<EuropeBoard> findByEuropeCategoryOrderByEuropeIdDesc(String europeCategory, Pageable pageable);
}
