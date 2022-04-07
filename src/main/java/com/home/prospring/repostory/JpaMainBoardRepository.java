package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaMainBoardRepository implements MainBoardRepository{

    private final EntityManager em;

    public JpaMainBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<MainBoard> findAll() {
        return em.createQuery("select m from MainBoard m", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .getResultList();
    }
}
