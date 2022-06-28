package com.home.prospring.controller;

import com.home.prospring.domain.BoardForm;
import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.repostory.IndiaDJRepository;
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
public class IndiaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private IndiaDJRepository indiaDJRepository;

    @Autowired
    public IndiaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    /**
     * 인도
     */
    @GetMapping("/indiaGallery")
    public String indiaGallery(){
        return "/India/indiaGallery";
    }

    @GetMapping("/indiaBoard")
    public String indiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<IndiaBoard> indiaList = indiaDJRepository.findByIndiaCategoryOrderByIndiaIdDesc(country, pageable);
        int startPage = Math.max(1,indiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(indiaList.getTotalPages(), indiaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("indiaList",indiaList);
        model.addAttribute("country",country);
        return "India/indiaBoard";
    }

    @GetMapping("/indiaBoard/Insert")
    public String esAsiaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "India/indiaBoardForm";
    }

    @PostMapping("/indiaBoard/Insert")
    public String esAsiaBoardInsert(BoardForm form, MultipartFile file) throws Exception {
        IndiaBoard indiaBoard = new IndiaBoard();
        indiaBoard.setIndiaTitle(form.getTitle());
        indiaBoard.setIndiaContent(form.getContent());
        indiaBoard.setIndiaDate(form.getDate());
        indiaBoard.setIndiaCategory(form.getCategory());
        indiaBoard.setTubelink(form.getTubelink());
        mainBoardService.indiaInsert(indiaBoard, file);

        return "redirect:/indiaGallery";
    }

    @GetMapping("/indiaBoard/Detail{no}")
    public String indiaBoardDetail(@PathVariable int no, Model model){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateIndiaHit(no);
        return "India/indiaBoardDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/indiaBoard/Update{no}")
    public String indiaBoardUpdate(@PathVariable int no, Model model){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "India/indiaBoardUpdateForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/indiaBoard/Update")
    public String indiaBoardUpdates(BoardForm form, MultipartFile file) throws Exception {
        IndiaBoard boardOne = mainBoardService.findIndiaOne(form.getId()).get();
        boardOne.setIndiaTitle(form.getTitle());
        boardOne.setIndiaContent(form.getContent());
        boardOne.setIndiaCategory(form.getCategory());
        boardOne.setTubelink(form.getTubelink());
        mainBoardService.indiaInsert(boardOne, file);
        return "redirect:/indiaGallery";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/indiaBoard/Delete{no}")
    public String indiaBoardDelete(@PathVariable int no){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getIndiaId());
        mainBoardService.indiaRemove(boardOne);
        return "redirect:/indiaBoard?country=india";
    }
}
