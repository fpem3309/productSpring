package com.home.prospring.controller;

import com.home.prospring.domain.ESAsiaBoard;
import com.home.prospring.repostory.ESAsiaDJRepository;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ESAsiaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private ESAsiaDJRepository esAsiaDJRepository;

    @Autowired
    public ESAsiaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중앙 아시아
     */
    @GetMapping("/esAsiaGallery")
    public String esAsiaGallery(){
        return "/ESAsia/esAsiaGallery";
    }

    @GetMapping("/esAsiaBoard")
    public String esAsiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<ESAsiaBoard> esAsiaList = esAsiaDJRepository.findByEsasiaCategory(country, pageable);
        int startPage = Math.max(1,esAsiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(esAsiaList.getTotalPages(), esAsiaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("esAsiaList",esAsiaList);
        model.addAttribute("country",country);
        return "ESAsia/esAsiaBoard";
    }

    @GetMapping("/esAsiaBoard/Insert")
    public String esAsiaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "ESAsia/esAsiaBoardForm";
    }

    @PostMapping("/esAsiaBoard/Insert")
    public String esAsiaBoardInsert(BoardForm form){
        ESAsiaBoard esAsiaBoard = new ESAsiaBoard();
        esAsiaBoard.setEsasiaTitle(form.getTitle());
        esAsiaBoard.setEsasiaContent(form.getContent());
        esAsiaBoard.setEsasiaDate(form.getDate());
        esAsiaBoard.setEsasiaCategory(form.getCategory());
        mainBoardService.esAsiaInsert(esAsiaBoard);

        return "redirect:/esAsiaGallery";
    }

    @GetMapping("/esAsiaBoard/Detail{no}")
    public String esAsiaBoardDetail(@PathVariable int no, Model model){
        ESAsiaBoard boardOne = mainBoardService.findEsAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateEsAsiaHit(no);
        return "ESAsia/esAsiaBoardDetail";
    }

    @GetMapping("/esAsiaBoard/Update{no}")
    public String esAsiaBoardUpdate(@PathVariable int no, Model model){
        ESAsiaBoard boardOne = mainBoardService.findEsAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "ESAsia/esAsiaBoardUpdateForm";
    }

    @PostMapping("/esAsiaBoard/Update")
    public String esAsiaBoardUpdates(BoardForm form){
        ESAsiaBoard boardOne = mainBoardService.findEsAsiaOne(form.getId()).get();
        boardOne.setEsasiaTitle(form.getTitle());
        boardOne.setEsasiaContent(form.getContent());
        boardOne.setEsasiaCategory(form.getCategory());
        mainBoardService.esAsiaInsert(boardOne);
        return "redirect:/esAsiaGallery";
    }

    @GetMapping("/esAsiaBoard/Delete{no}")
    public String esAsiaBoardDelete(@PathVariable int no){
        ESAsiaBoard boardOne = mainBoardService.findEsAsiaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getEsasiaId());
        mainBoardService.esAsiaRemove(boardOne);
        return "redirect:/esAsiaGallery";
    }
}
