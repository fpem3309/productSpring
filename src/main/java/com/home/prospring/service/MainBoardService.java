package com.home.prospring.service;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.domain.Member;
import com.home.prospring.repostory.MainBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainBoardService {

    private final MainBoardRepository mainBoardRepository;

    public MainBoardService(MainBoardRepository mainBoardRepository) {
        this.mainBoardRepository = mainBoardRepository;
    }

    public List<MainBoard> mainBoard(){
        return mainBoardRepository.findAll();
    }
}
