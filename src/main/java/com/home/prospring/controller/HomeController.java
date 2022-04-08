package com.home.prospring.controller;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final MainBoardService mainBoardService;

    @Autowired
    public HomeController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("mainProductBoard")
    public String list(Model model){
        List<MainBoard> mainBoardList = mainBoardService.mainBoard();
        model.addAttribute("mainproducts",mainBoardList);
        return "board";
    }


}
