package com.home.prospring.controller;

//import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.*;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final MainBoardService mainBoardService;

    @Autowired
    public MainController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/")
    public String list(Model model){
//        List<MainBoard> javaBoardList = mainBoardService.javaBoard();
//        List<MainBoard> springBoardList = mainBoardService.springBoard();
//        List<MainBoard> androidBoardList = mainBoardService.androidBoard();
//        List<MainBoard> jsBoardList = mainBoardService.jsBoard();
//        List<MainBoard> jpaBoardList = mainBoardService.jpaBoard();
//
//        model.addAttribute("javaBoards",javaBoardList);
//        model.addAttribute("springBoards",springBoardList);
//        model.addAttribute("androidBoards",androidBoardList);
//        model.addAttribute("jsBoards",jsBoardList);
//        model.addAttribute("jpaBoards",jpaBoardList);
//
//
//        List<MainBoard> asiaBoardList = mainBoardService.asiaBoard();
//        model.addAttribute("asia",asiaBoardList);

        List<ESAsiaBoard> esAsiaBoardList = mainBoardService.esAsiaBoard();
        List<IndiaBoard> indiaBoardList = mainBoardService.indiaBoard();
        List<CenAsiaBoard> cenAsiaBoardList = mainBoardService.cenAsiaBoard();
        List<MEAsiaBoard> meAsiaBoardList = mainBoardService.meAsiaBoard();
        List<EuropeBoard> europeBoardList = mainBoardService.europeBoard();
        List<NCAmericaBoard> ncAmericaBoardList = mainBoardService.ncAmericaBoard();
        List<SAmericaBoard> sAmericaBoardList = mainBoardService.sAmericaBoard();


        model.addAttribute("esAsia",esAsiaBoardList);
        model.addAttribute("india",indiaBoardList);
        model.addAttribute("cenasia",cenAsiaBoardList);
        model.addAttribute("measia",meAsiaBoardList);
        model.addAttribute("europe",europeBoardList);
        model.addAttribute("ncAmerica",ncAmericaBoardList);
        model.addAttribute("sAmerica",sAmericaBoardList);
        return "main";
    }
}
