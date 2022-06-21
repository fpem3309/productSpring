package com.home.prospring.controller;

import com.home.prospring.domain.BoardForm;
import com.home.prospring.domain.EuropeBoard;
import com.home.prospring.repostory.EuropeDJRepository;
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
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Controller
public class EuropeController {

    private final MainBoardService mainBoardService;

    @Autowired
    private EuropeDJRepository europeDJRepository;

    @Autowired
    public EuropeController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중앙 아시아
     */
    @GetMapping("/europeGallery")
    public String europeGallery(){
        return "/Europe/europeGallery";
    }

    @GetMapping("/europeBoard")
    public String europeList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<EuropeBoard> europeList = europeDJRepository.findByEuropeCategory(country, pageable);
        int startPage = Math.max(1,europeList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(europeList.getTotalPages(), europeList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("europeList",europeList);
        model.addAttribute("country",country);
        return "Europe/europeBoard";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/europeBoard/Insert")
    public String europeBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "Europe/europeBoardForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/europeBoard/Insert")
    public String europeBoardInsert(BoardForm form, MultipartFile file) throws Exception {
        EuropeBoard europeBoard = new EuropeBoard();
        europeBoard.setEuropeTitle(form.getTitle());
        europeBoard.setEuropeContent(form.getContent());
        europeBoard.setEuropeDate(form.getDate());
        europeBoard.setEuropeCategory(form.getCategory());
        europeBoard.setTubelink(form.getTubelink());
        mainBoardService.europeInsert(europeBoard, file);

        return "redirect:/europeGallery";
    }

    @GetMapping("/europeBoard/Detail{no}")
    public String europeBoardDetail(@PathVariable int no, Model model){
        EuropeBoard boardOne = mainBoardService.findEuropeOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateEuropeHit(no);
        return "Europe/europeBoardDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/europeBoard/Update{no}")
    public String europeBoardUpdate(@PathVariable int no, Model model){
        EuropeBoard boardOne = mainBoardService.findEuropeOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "Europe/europeBoardUpdateForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/europeBoard/Update")
    public String europeBoardUpdates(BoardForm form, MultipartFile file) throws Exception {
        EuropeBoard boardOne = mainBoardService.findEuropeOne(form.getId()).get();
        boardOne.setEuropeTitle(form.getTitle());
        boardOne.setEuropeContent(form.getContent());
        boardOne.setEuropeCategory(form.getCategory());
        boardOne.setTubelink(form.getTubelink());
        mainBoardService.europeInsert(boardOne, file);
        return "redirect:/europeGallery";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/europeBoard/Delete{no}")
    public String europeBoardDelete(@PathVariable int no){
        EuropeBoard boardOne = mainBoardService.findEuropeOne(no).get();
        System.out.println("삭제 no = "+boardOne.getEuropeId());
        mainBoardService.europeRemove(boardOne);
        return "redirect:/europeGallery";
    }
}
