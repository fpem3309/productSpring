package com.home.prospring.controller;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class ReactContoller {

    private final MainBoardService mainBoardService;

    @Autowired
    public ReactContoller(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/home")
    public List<String> goHome(){
        return Arrays.asList("안녕하세요", "Hello");
    }

//    @GetMapping("/mainBoard")
//    public List<MainBoard> listReact(){
//        return mainBoardService.mainBoard();
//    }


}
