package com.home.prospring.controller;

//import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
//import com.home.prospring.repostory.CenAsiaDJRepository;
import com.home.prospring.repostory.IndiaDJRepository;
import com.home.prospring.repostory.SpringDataJpaRepository;
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
import java.util.List;

@Controller
public class IndiaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private IndiaDJRepository indiaDJRepository;

//    @Autowired
//    private CenAsiaDJRepository cenAsiaDJRepository;

    @Autowired
    public IndiaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    /**
     * 인도
     */
    @GetMapping("/indiaGallery")
    public String indiaGallery(){
        return "/gallery/indiaGallery";
    }

    @GetMapping("/indiaBoard")
    public String indiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<IndiaBoard> indiaList = indiaDJRepository.findByIndiaCategory(country, pageable);
        int startPage = Math.max(1,indiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(indiaList.getTotalPages(), indiaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("indiaList",indiaList);
        model.addAttribute("country",country);
        return "boards/indiaBoard";
    }

    @GetMapping("/indiaBoard/Detail{no}")
    public String indiaBoardDetail(@PathVariable int no, Model model){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateIndiaHit(no);
        return "boards/indiaBoardDetail";
    }

    @GetMapping("/indiaBoard/Update{no}")
    public String indiaBoardUpdate(@PathVariable int no, Model model){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "boards/indiaBoardUpdateForm";
    }

    @PostMapping("/indiaBoard/Update")
    public String indiaBoardUpdates(BoardForm form){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(form.getId()).get();
        boardOne.setIndiaTitle(form.getTitle());
        boardOne.setIndiaContent(form.getContent());
        boardOne.setIndiaCategory(form.getCategory());
        mainBoardService.indiaInsert(boardOne);
        return "redirect:/indiaBoard?country=india";
    }

    @GetMapping("/indiaBoard/Delete{no}")
    public String indiaBoardDelete(@PathVariable int no){
        IndiaBoard boardOne = mainBoardService.findIndiaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getIndiaId());
        mainBoardService.indiaRemove(boardOne);
        return "redirect:/indiaBoard?country=india";
    }

    /**
     * 중앙 아시아
     */
//    @GetMapping("/cenAsiaGallery")
//    public String cenAsiaGallery(){
//        return "/CenAsia/cenAsiaGallery";
//    }
//
//    @GetMapping("/cenAsiaBoard")
//    public String cenAsiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
//        Page<CenAsiaBoard> cenAsiaList = cenAsiaDJRepository.findByCenAsiaCategory(country, pageable);
//        int startPage = Math.max(1,cenAsiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
//        int endPage = Math.min(cenAsiaList.getTotalPages(), cenAsiaList.getPageable().getPageNumber() + 4);
//        model.addAttribute("startPage",startPage);
//        model.addAttribute("endPage",endPage);
//        model.addAttribute("cenAsiaList",cenAsiaList);
//        model.addAttribute("country",country);
//        return "CenAsia/cenAsiaBoard";
//    }
//
//    @GetMapping("/cenAsiaBoard/Detail{no}")
//    public String cenAsiaBoardDetail(@PathVariable int no, Model model){
//        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
//        model.addAttribute("boardOne",boardOne);
//        mainBoardService.updateIndiaHit(no);
//        return "boards/cenAsiaBoardDetail";
//    }
//
//    @GetMapping("/cenAsiaBoard/Update{no}")
//    public String cenAsiaBoardUpdate(@PathVariable int no, Model model){
//        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
//        model.addAttribute("boardOne",boardOne);
//        model.addAttribute("localDate", LocalDate.now());
//        return "boards/indiaBoardUpdateForm";
//    }
//
//    @PostMapping("/cenAsiaBoard/Update")
//    public String cenAsiaBoardUpdates(BoardForm form){
//        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(form.getId()).get();
//        boardOne.setCenasiaTitle(form.getTitle());
//        boardOne.setCenasiaContent(form.getContent());
//        boardOne.setCenasiaCategory(form.getCategory());
//        mainBoardService.cenAsiaInsert(boardOne);
//        return "redirect:/indiaBoard?country=india";
//    }
//
//    @GetMapping("/cenAsiaBoard/Delete{no}")
//    public String cenAsiaBoardDelete(@PathVariable int no){
//        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
//        System.out.println("삭제 no = "+boardOne.getCenasiaId());
//        mainBoardService.cenAsiaRemove(boardOne);
//        return "redirect:/cenAsiaBoard?country=cenAsia";
//    }
}
