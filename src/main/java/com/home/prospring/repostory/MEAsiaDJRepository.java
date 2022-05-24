package com.home.prospring.repostory;

import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.MEAsiaBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MEAsiaDJRepository extends JpaRepository<MEAsiaBoard, Long> {

    @Modifying
    @Query("update MEAsiaBoard m set m.measiaHit = m.measiaHit + 1 where m.measiaId = :id")
    int updateCount(@Param("id") int id);

    //Page<MainBoard> findByTitleContainingOrContentContaining(String mainProductTitle, String mainProductContent, Pageable pageable);
    Page<MEAsiaBoard> findByMeasiaCategory(String measiaCategory, Pageable pageable);
}
