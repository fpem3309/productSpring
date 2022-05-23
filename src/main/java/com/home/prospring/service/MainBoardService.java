package com.home.prospring.service;

import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import com.home.prospring.repostory.IndiaDJRepository;
import com.home.prospring.repostory.MainBoardRepository;
import com.home.prospring.repostory.SpringDataJpaRepository;
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

    public MainBoardService(MainBoardRepository mainBoardRepository, SpringDataJpaRepository springDataJpaMemberRepository, IndiaDJRepository indiaDJRepository) {
        this.mainBoardRepository = mainBoardRepository;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
        this.indiaDJRepository = indiaDJRepository;
    }

    public int updateHit(int id){
        return springDataJpaMemberRepository.updateCount(id);
    }
    public int updateIndiaHit(int id){
        return indiaDJRepository.updateCount(id);
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

}
