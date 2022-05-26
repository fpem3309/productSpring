package com.home.prospring.service;

import com.home.prospring.domain.*;
import com.home.prospring.repostory.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainBoardService {

    private final MainBoardRepository mainBoardRepository;
    private final SpringDataJpaRepository springDataJpaMemberRepository;
    private final IndiaDJRepository indiaDJRepository;
    private final CenAsiaDJRepository cenAsiaDJRepository;
    private final MEAsiaDJRepository meAsiaDJRepository;
    private final EuropeDJRepository europeDJRepository;
    private final NCAmericaDJRepository ncAmericaDJRepository;
    private final SAmericaDJRepository sAmericaDJRepository;

    public MainBoardService(MainBoardRepository mainBoardRepository, SpringDataJpaRepository springDataJpaMemberRepository, IndiaDJRepository indiaDJRepository, CenAsiaDJRepository cenAsiaDJRepository, MEAsiaDJRepository meAsiaDJRepository, EuropeDJRepository europeDJRepository, NCAmericaDJRepository ncAmericaDJRepository, SAmericaDJRepository sAmericaDJRepository) {
        this.mainBoardRepository = mainBoardRepository;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
        this.indiaDJRepository = indiaDJRepository;
        this.cenAsiaDJRepository = cenAsiaDJRepository;
        this.meAsiaDJRepository = meAsiaDJRepository;
        this.europeDJRepository = europeDJRepository;
        this.ncAmericaDJRepository = ncAmericaDJRepository;
        this.sAmericaDJRepository = sAmericaDJRepository;
    }

    public int updateHit(int id){
        return springDataJpaMemberRepository.updateCount(id);
    }
    public int updateIndiaHit(int id){
        return indiaDJRepository.updateCount(id);
    }
    public int updateCenAsiaHit(int id){
        return cenAsiaDJRepository.updateCount(id);
    }
    public int updateSAsiaHit(int id){
        return sAmericaDJRepository.updateCount(id);
    }

    /**
     * 게시글 등록
     */
    public int Insert(MainBoard mainBoard){
        mainBoardRepository.Insert(mainBoard);
        return mainBoard.getMainProductId();
    }

    /**
     * 인도
     */
    public int indiaInsert(IndiaBoard indiaBoard){
        mainBoardRepository.indiaInsert(indiaBoard);
        return indiaBoard.getIndiaId();
    }
    public int indiaRemove(IndiaBoard indiaBoard){
        mainBoardRepository.indiaDelete(indiaBoard);
        return indiaBoard.getIndiaId();
    }
    public Optional<IndiaBoard> findIndiaOne(int indiaId){
        return mainBoardRepository.findIndiaBoard(indiaId);
    }

    /**
     * 중앙아시아
     */
    public int cenAsiaInsert(CenAsiaBoard cenAsiaBoard){
        mainBoardRepository.cenAsiaInsert(cenAsiaBoard);
        return cenAsiaBoard.getCenasiaId();
    }
    public int cenAsiaRemove(CenAsiaBoard cenAsiaBoard){
        mainBoardRepository.cenAsiaDelete(cenAsiaBoard);
        return cenAsiaBoard.getCenasiaId();
    }
    public Optional<CenAsiaBoard> findCenAsiaOne(int cenAsiaId){
        return mainBoardRepository.findCenAsiaBoard(cenAsiaId);
    }

    /**
     * 중동아시아
     * @param meAsiaBoard
     */
    public int meAsiaInsert(MEAsiaBoard meAsiaBoard){
        mainBoardRepository.meAsiaInsert(meAsiaBoard);
        return meAsiaBoard.getMeasiaId();
    }
    public int meAsiaRemove(MEAsiaBoard meAsiaBoard){
        mainBoardRepository.meAsiaDelete(meAsiaBoard);
        return meAsiaBoard.getMeasiaId();
    }
    public Optional<MEAsiaBoard> findMeAsiaOne(int meAsiaId){
        return mainBoardRepository.findMeAsiaBoard(meAsiaId);
    }
    public int updateMeAsiaHit(int id){
        return meAsiaDJRepository.updateCount(id);
    }

    /**
     * 유럽
     * @param europeBoard
     */
    public int europeInsert(EuropeBoard europeBoard){
        mainBoardRepository.europeInsert(europeBoard);
        return europeBoard.getEuropeId();
    }
    public int europeRemove(EuropeBoard europeBoard){
        mainBoardRepository.europeDelete(europeBoard);
        return europeBoard.getEuropeId();
    }
    public Optional<EuropeBoard> findEuropeOne(int europeId){
        return mainBoardRepository.findEuropeBoard(europeId);
    }
    public int updateEuropeHit(int id){
        return europeDJRepository.updateCount(id);
    }

    /**
     * 북중미
     * @param ncAmericaBoard
     */
    public int ncAmericaInsert(NCAmericaBoard ncAmericaBoard){
        mainBoardRepository.ncAmericaInsert(ncAmericaBoard);
        return ncAmericaBoard.getNcamericaId();
    }
    public int ncAmericaRemove(NCAmericaBoard ncAmericaBoard){
        mainBoardRepository.ncAmericaDelete(ncAmericaBoard);
        return ncAmericaBoard.getNcamericaId();
    }
    public Optional<NCAmericaBoard> findNcAmericaOne(int ncAmericaId){
        return mainBoardRepository.findNcAmericaBoard(ncAmericaId);
    }
    public int updateNcAmericaHit(int id){
        return ncAmericaDJRepository.updateCount(id);
    }


    /**
     * 남미
     * @param sAmericaBoard
     */
    public int sAmericaInsert(SAmericaBoard sAmericaBoard){
        mainBoardRepository.sAmericaInsert(sAmericaBoard);
        return sAmericaBoard.getSamericaId();
    }
    public int sAmericaRemove(SAmericaBoard sAmericaBoard){
        mainBoardRepository.sAmericaDelete(sAmericaBoard);
        return sAmericaBoard.getSamericaId();
    }
    public Optional<SAmericaBoard> findSAmericaOne(int sAmericaId){
        return mainBoardRepository.findSAmericaBoard(sAmericaId);
    }
    public int updateSAmericaHit(int id){
        return sAmericaDJRepository.updateCount(id);
    }


    /**
     *
     * @return
     */

    //전체 글
    public List<MainBoard> mainBoard(){
        return mainBoardRepository.findAll();
    }

    //메인화면 글
    public Optional<MainBoard> findOne(int mainProductId){
        return mainBoardRepository.findBoard(mainProductId);
    }

    public int removeOne(MainBoard mainBoard){
        mainBoardRepository.delBoard(mainBoard);
        return mainBoard.getMainProductId();
    }


    public List<MainBoard> findCategory(String mainProductCategory){
        return mainBoardRepository.findCategory(mainProductCategory);
    }




    /**
     * 메인 카테고리별
     */
    public List<MainBoard> javaBoard(){return mainBoardRepository.findJava();}
    public List<MainBoard> springBoard(){return mainBoardRepository.findSpring();}
    public List<MainBoard> androidBoard(){return mainBoardRepository.findAndroid();}
    public List<MainBoard> jsBoard(){return mainBoardRepository.findJS();}
    public List<MainBoard> jpaBoard(){return mainBoardRepository.findJPA();}

    public List<MainBoard> asiaBoard(){return mainBoardRepository.findAsia();}
    public List<IndiaBoard> indiaBoard(){return mainBoardRepository.findIndia();}
    public List<CenAsiaBoard> cenAsiaBoard(){return mainBoardRepository.findCenAsia();}
    public List<MEAsiaBoard> meAsiaBoard(){return mainBoardRepository.findMeAsia();}
    public List<EuropeBoard> europeBoard(){return mainBoardRepository.findEurope();}
    public List<NCAmericaBoard> ncAmericaBoard(){return mainBoardRepository.findNcAmerica();}
    public List<SAmericaBoard> sAmericaBoard(){return mainBoardRepository.findSAmerica();}

}
