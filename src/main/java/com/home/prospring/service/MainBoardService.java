package com.home.prospring.service;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.repostory.MainBoardRepository;
import org.jboss.jandex.Main;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MainBoardService {

    private final MainBoardRepository mainBoardRepository;

    public MainBoardService(MainBoardRepository mainBoardRepository) {
        this.mainBoardRepository = mainBoardRepository;
    }

    /**
     * 게시글 등록
     */
    public int Insert(MainBoard mainBoard){
        mainBoardRepository.Insert(mainBoard);
        return mainBoard.getMainProductId();
    }

    public List<MainBoard> mainBoard(){
        return mainBoardRepository.findAll();
    }

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

}
