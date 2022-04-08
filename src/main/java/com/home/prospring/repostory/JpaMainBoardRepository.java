package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMainBoardRepository implements MainBoardRepository{

    private final EntityManager em;

    public JpaMainBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<MainBoard> findAll() {
        return em.createQuery("select m from MainBoard m order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .getResultList();
    }

    @Override
    public MainBoard Insert(MainBoard mainBoard) {
        em.persist(mainBoard);
        return mainBoard;
    }

    @Override
    public Optional<MainBoard> findBoard(int mainProductId) {
        MainBoard mainBoard = em.find(MainBoard.class,mainProductId);
        return Optional.ofNullable(mainBoard);
    }


}
