package com.home.prospring.repostory;

import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IndiaDJRepository extends JpaRepository<IndiaBoard, Long> {

    @Modifying
    @Query("update IndiaBoard m set m.indiaHit = m.indiaHit + 1 where m.indiaId = :id")
    int updateCount(@Param("id") int id);

    Page<IndiaBoard> findByIndiaCategoryOrderByIndiaIdDesc(String indiaCategory, Pageable pageable);
}
