package com.home.prospring.repostory;

import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IndiaDJRepository extends JpaRepository<IndiaBoard, Long> {

    @Modifying
    @Query("update MainBoard m set m.mainProductHit = m.mainProductHit + 1 where m.mainProductId = :id")
    int updateCount(@Param("id") int id);

    //Page<MainBoard> findByTitleContainingOrContentContaining(String mainProductTitle, String mainProductContent, Pageable pageable);

}
