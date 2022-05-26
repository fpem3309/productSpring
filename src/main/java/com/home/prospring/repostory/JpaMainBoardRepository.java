package com.home.prospring.repostory;

import com.home.prospring.domain.*;

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
     * 동남아시아
     * @param esAsiaBoard
     */
    @Override
    public ESAsiaBoard esAsiaInsert(ESAsiaBoard esAsiaBoard) {
        em.persist(esAsiaBoard);
        return esAsiaBoard;
    }

    @Override
    public ESAsiaBoard esAsiaDelete(ESAsiaBoard esAsiaBoard) {
        em.remove(esAsiaBoard);
        return esAsiaBoard;
    }

    @Override
    public List<ESAsiaBoard> findEsAsia() {
        return em.createQuery("select m from ESAsiaBoard m order by m.esasiaId desc", ESAsiaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<ESAsiaBoard> findEsAsiaBoard(int esAsiaId) {
        ESAsiaBoard esAsiaBoard = em.find(ESAsiaBoard.class, esAsiaId);
        return Optional.ofNullable(esAsiaBoard);
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

    /**
     * 중동아시아
     * @param meAsiaBoard
     */
    @Override
    public MEAsiaBoard meAsiaInsert(MEAsiaBoard meAsiaBoard) {
        em.persist(meAsiaBoard);
        return meAsiaBoard;
    }

    @Override
    public MEAsiaBoard meAsiaDelete(MEAsiaBoard meAsiaBoard) {
        em.remove(meAsiaBoard);
        return meAsiaBoard;
    }

    @Override
    public List<MEAsiaBoard> findMeAsia() {
        return em.createQuery("select m from MEAsiaBoard m order by m.measiaId desc", MEAsiaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<MEAsiaBoard> findMeAsiaBoard(int meAsiaId) {
        MEAsiaBoard meAsiaBoard = em.find(MEAsiaBoard.class, meAsiaId);
        return Optional.ofNullable(meAsiaBoard);
    }

    /**
     * 유럽
     * @param europeBoard
     */
    @Override
    public EuropeBoard europeInsert(EuropeBoard europeBoard) {
        em.persist(europeBoard);
        return europeBoard;
    }

    @Override
    public EuropeBoard europeDelete(EuropeBoard europeBoard) {
        em.remove(europeBoard);
        return europeBoard;
    }

    @Override
    public List<EuropeBoard> findEurope() {
        return em.createQuery("select m from EuropeBoard m order by m.europeId desc", EuropeBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<EuropeBoard> findEuropeBoard(int europeId) {
        EuropeBoard europeBoard = em.find(EuropeBoard.class, europeId);
        return Optional.ofNullable(europeBoard);
    }

    /**
     * 북중미
     * @param ncAmericaBoard
     */
    @Override
    public NCAmericaBoard ncAmericaInsert(NCAmericaBoard ncAmericaBoard) {
        em.persist(ncAmericaBoard);
        return ncAmericaBoard;
    }

    @Override
    public NCAmericaBoard ncAmericaDelete(NCAmericaBoard ncAmericaBoard) {
        em.remove(ncAmericaBoard);
        return ncAmericaBoard;
    }

    @Override
    public List<NCAmericaBoard> findNcAmerica() {
        return em.createQuery("select m from NCAmericaBoard m order by m.ncamericaId desc", NCAmericaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<NCAmericaBoard> findNcAmericaBoard(int ncAmericaId) {
        NCAmericaBoard ncAmericaBoard = em.find(NCAmericaBoard.class, ncAmericaId);
        return Optional.ofNullable(ncAmericaBoard);
    }

    /**
     * 남미
     * @param sAmericaBoard
     */
    @Override
    public SAmericaBoard sAmericaInsert(SAmericaBoard sAmericaBoard) {
        em.persist(sAmericaBoard);
        return sAmericaBoard;
    }

    @Override
    public SAmericaBoard sAmericaDelete(SAmericaBoard sAmericaBoard) {
        em.remove(sAmericaBoard);
        return sAmericaBoard;
    }

    @Override
    public List<SAmericaBoard> findSAmerica() {
        return em.createQuery("select m from SAmericaBoard m order by m.samericaId desc", SAmericaBoard.class)   //MainBoard Entity에 query 하는것, m = as m
                .setMaxResults(5).getResultList();
    }

    @Override
    public Optional<SAmericaBoard> findSAmericaBoard(int sAmericaId) {
        SAmericaBoard sAmericaBoard = em.find(SAmericaBoard.class, sAmericaId);
        return Optional.ofNullable(sAmericaBoard);
    }
}
