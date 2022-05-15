package com.home.prospring.controller;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountryController {

    private final MainBoardService mainBoardService;

    @Autowired
    public CountryController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/categoryCountry")
    public String cate_list(Model model, @RequestParam String category){
        List<MainBoard> boardList = mainBoardService.findCategory(category);
        model.addAttribute("categories",boardList);
        return "boards/category_board";
    }
}
