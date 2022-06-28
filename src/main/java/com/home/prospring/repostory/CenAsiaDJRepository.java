package com.home.prospring.repostory;

import com.home.prospring.domain.CenAsiaBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CenAsiaDJRepository extends JpaRepository<CenAsiaBoard, Long> {

    @Modifying
    @Query("update CenAsiaBoard m set m.cenasiaHit = m.cenasiaHit + 1 where m.cenasiaId = :id")
    int updateCount(@Param("id") int id);

    Page<CenAsiaBoard> findByCenasiaCategoryOrderByCenasiaIdDesc(String cenasiaCategory, Pageable pageable);
}
