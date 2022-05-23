package com.home.prospring.repostory;

import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMainBoardRepository implements MainBoardRepository {

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

    //Optional 반환형 사용 (Null값 처리에 용이)
    @Override
    public Optional<MainBoard> findBoard(int mainProductId) {
        MainBoard mainBoard = em.find(MainBoard.class, mainProductId);
        return Optional.ofNullable(mainBoard);
    }

    @Override
    public MainBoard delBoard(MainBoard mainBoard) {
        em.remove(mainBoard);
        return mainBoard;
    }

    /**
     * 카테고리 선택했을때     * @param mainProductCategory
     * @return
     */
    @Override
    public List<MainBoard> findCategory(String mainProductCategory) {
        return em.createQuery("select m from MainBoard m WHERE m.mainProductCategory = :mainProductCategory", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setParameter("mainProductCategory", mainProductCategory).getResultList();
    }


    /**
     * 메인 카테고리별
     */
    @Override
    public List<MainBoard> findJava() {

        return em.createQuery("select m from MainBoard m where m.mainProductCategory = 'Java' order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public List<MainBoard> findSpring() {
        return em.createQuery("select m from MainBoard m where m.mainProductCategory = 'Spring' order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public List<MainBoard> findAndroid() {
        return em.createQuery("select m from MainBoard m where m.mainProductCategory = 'Android' order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public List<MainBoard> findJS() {
        return em.createQuery("select m from MainBoard m where m.mainProductCategory = 'Javascript' order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public List<MainBoard> findJPA() {
        return em.createQuery("select m from MainBoard m where m.mainProductCategory = 'JPA' order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public List<MainBoard> findAsia() {
        return em.createQuery("select m from MainBoard m order by m.mainProductId desc", MainBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }


/**
 * 인도
 */
    @Override
    public IndiaBoard indiaInsert(IndiaBoard indiaBoard) {
        em.persist(indiaBoard);
        return indiaBoard;
    }

    @Override
    public IndiaBoard indiaDelete(IndiaBoard indiaBoard) {
        em.remove(indiaBoard);
        return indiaBoard;
    }

    @Override
    public List<IndiaBoard> findIndia() {
        return em.createQuery("select m from IndiaBoard m order by m.indiaId desc", IndiaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<IndiaBoard> findIndiaBoard(int indiaId) {
        IndiaBoard indiaBoard = em.find(IndiaBoard.class, indiaId);
        return Optional.ofNullable(indiaBoard);
    }

    /**
     * 중앙아시아
     */
    @Override
    public CenAsiaBoard cenAsiaInsert(CenAsiaBoard cenAsiaBoard) {
        em.persist(cenAsiaBoard);
        return cenAsiaBoard;
    }

    @Override
    public CenAsiaBoard cenAsiaDelete(CenAsiaBoard cenAsiaBoard) {
        em.remove(cenAsiaBoard);
        return cenAsiaBoard;
    }

    @Override
    public List<CenAsiaBoard> findCenAsia() {
        return em.createQuery("select m from CenAsiaBoard m order by m.cenasiaId desc", CenAsiaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<CenAsiaBoard> findCenAsiaBoard(int cenAsiaId) {
        CenAsiaBoard cenAsiaBoard = em.find(CenAsiaBoard.class, cenAsiaId);
        return Optional.ofNullable(cenAsiaBoard);
    }

}
