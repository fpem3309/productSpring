package com.home.prospring.service;

import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import com.home.prospring.repostory.MainBoardRepository;
import com.home.prospring.repostory.SpringDataJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainBoardService {

    private final MainBoardRepository mainBoardRepository;
    private final SpringDataJpaRepository springDataJpaMemberRepository;

    public MainBoardService(MainBoardRepository mainBoardRepository, SpringDataJpaRepository springDataJpaMemberRepository) {
        this.mainBoardRepository = mainBoardRepository;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }

    public int updateHit(int id){
        return springDataJpaMemberRepository.updateCount(id);
    }

    /**
     * 게시글 등록
     */
    public int Insert(MainBoard mainBoard){
        mainBoardRepository.Insert(mainBoard);
        return mainBoard.getMainProductId();
    }

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
