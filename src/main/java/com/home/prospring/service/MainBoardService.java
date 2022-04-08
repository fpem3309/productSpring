package com.home.prospring.service;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.repostory.MainBoardRepository;
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
}
