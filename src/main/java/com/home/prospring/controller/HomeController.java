package com.home.prospring.controller;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final MainBoardService mainBoardService;

    @Autowired
    public HomeController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/mainProductBoard")
    public String list(Model model){
        List<MainBoard> mainBoardList = mainBoardService.mainBoard();
        model.addAttribute("mainproducts",mainBoardList);
        return "boards/board";
    }

    @GetMapping("/mainProductBoard/Insert")
    public String boardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "boards/boardForm";
    }

    @PostMapping("/mainProductBoard/Insert")
    public String boardInsert(BoardForm form){
        MainBoard mainBoard = new MainBoard();
        mainBoard.setMainProductTitle(form.getTitle());
        mainBoard.setMainProductContent(form.getContent());
        mainBoard.setMainProductDate(form.getDate());
        mainBoardService.Insert(mainBoard);

        return "redirect:/mainProductBoard";
    }

    @GetMapping("/mainProductBoard/Detail{no}")
    public String boardDetail(@PathVariable int no, Model model){
        MainBoard boardOne = mainBoardService.findOne(no).get();
        model.addAttribute("boardOne",boardOne);
        return "boards/boardDetail";
    }

    @GetMapping("/mainProductBoard/Delete{no}")
    public String boardDelete(@PathVariable int no){
        MainBoard boardOne = mainBoardService.findOne(no).get();
        System.out.println("삭제 no = "+boardOne.getMainProductId());
        mainBoardService.removeOne(boardOne);
        return "redirect:/mainProductBoard";
    }

}
