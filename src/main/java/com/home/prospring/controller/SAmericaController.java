package com.home.prospring.controller;

import com.home.prospring.domain.SAmericaBoard;
import com.home.prospring.repostory.SAmericaDJRepository;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class SAmericaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private SAmericaDJRepository sAmericaDJRepository;

    @Autowired
    public SAmericaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중앙 아시아
     */
    @GetMapping("/sAmericaGallery")
    public String sAmericaGallery(){
        return "/SAmerica/sAmericaGallery";
    }

    @GetMapping("/sAmericaBoard")
    public String sAmericaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<SAmericaBoard> sAmericaList = sAmericaDJRepository.findBySamericaCategory(country, pageable);
        int startPage = Math.max(1,sAmericaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(sAmericaList.getTotalPages(), sAmericaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("sAmericaList",sAmericaList);
        model.addAttribute("country",country);
        return "SAmerica/sAmericaBoard";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/sAmericaBoard/Insert")
    public String sAmericaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "SAmerica/sAmericaBoardForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/sAmericaBoard/Insert")
    public String sAmericaBoardInsert(BoardForm form){
        SAmericaBoard sAmericaBoard = new SAmericaBoard();
        sAmericaBoard.setSamericaTitle(form.getTitle());
        sAmericaBoard.setSamericaContent(form.getContent());
        sAmericaBoard.setSamericaDate(form.getDate());
        sAmericaBoard.setSamericaCategory(form.getCategory());
        mainBoardService.sAmericaInsert(sAmericaBoard);

        return "redirect:/sAmericaGallery";
    }

    @GetMapping("/sAmericaBoard/Detail{no}")
    public String sAmericaBoardDetail(@PathVariable int no, Model model){
        SAmericaBoard boardOne = mainBoardService.findSAmericaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateSAmericaHit(no);
        return "SAmerica/sAmericaBoardDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/sAmericaBoard/Update{no}")
    public String sAmericaBoardUpdate(@PathVariable int no, Model model){
        SAmericaBoard boardOne = mainBoardService.findSAmericaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "SAmerica/sAmericaBoardUpdateForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/sAmericaBoard/Update")
    public String sAmericaBoardUpdates(BoardForm form){
        SAmericaBoard boardOne = mainBoardService.findSAmericaOne(form.getId()).get();
        boardOne.setSamericaTitle(form.getTitle());
        boardOne.setSamericaContent(form.getContent());
        boardOne.setSamericaCategory(form.getCategory());
        mainBoardService.sAmericaInsert(boardOne);
        return "redirect:/sAmericaGallery";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/sAmericaBoard/Delete{no}")
    public String sAmericaBoardDelete(@PathVariable int no){
        SAmericaBoard boardOne = mainBoardService.findSAmericaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getSamericaId());
        mainBoardService.sAmericaRemove(boardOne);
        return "redirect:/sAmericaGallery";
    }
}
