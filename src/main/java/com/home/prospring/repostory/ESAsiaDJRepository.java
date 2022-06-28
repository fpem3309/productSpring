package com.home.prospring.repostory;

import com.home.prospring.domain.ESAsiaBoard;
import com.home.prospring.domain.MEAsiaBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ESAsiaDJRepository extends JpaRepository<ESAsiaBoard, Long> {

    @Modifying
    @Query("update ESAsiaBoard m set m.esasiaHit = m.esasiaHit + 1 where m.esasiaId = :id")
    int updateCount(@Param("id") int id);

    Page<ESAsiaBoard> findByEsasiaCategoryOrderByEsasiaIdDesc(String esasiaCategory, Pageable pageable);
}
