package com.home.prospring.controller;

import com.home.prospring.domain.BoardForm;
import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.repostory.CenAsiaDJRepository;
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
public class CenAsiaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private CenAsiaDJRepository cenAsiaDJRepository;

    @Autowired
    public CenAsiaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중앙 아시아
     */
    @GetMapping("/cenAsiaGallery")
    public String cenAsiaGallery(){
        return "/CenAsia/cenAsiaGallery";
    }

    @GetMapping("/cenAsiaBoard")
    public String cenAsiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<CenAsiaBoard> cenAsiaList = cenAsiaDJRepository.findByCenasiaCategory(country, pageable);
        int startPage = Math.max(1,cenAsiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(cenAsiaList.getTotalPages(), cenAsiaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("cenAsiaList",cenAsiaList);
        model.addAttribute("country",country);
        return "CenAsia/cenAsiaBoard";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/cenAsiaBoard/Insert")
    public String cenAsiaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "CenAsia/cenAsiaBoardForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/cenAsiaBoard/Insert")
    public String cenAsiaBoardInsert(BoardForm form, MultipartFile file) throws Exception {
        CenAsiaBoard cenAsiaBoard = new CenAsiaBoard();
        cenAsiaBoard.setCenasiaTitle(form.getTitle());
        cenAsiaBoard.setCenasiaContent(form.getContent());
        cenAsiaBoard.setCenasiaDate(form.getDate());
        cenAsiaBoard.setCenasiaCategory(form.getCategory());
        cenAsiaBoard.setTubelink(form.getTubelink());
        mainBoardService.cenAsiaInsert(cenAsiaBoard, file);

        return "redirect:/cenAsiaGallery";
    }


    @GetMapping("/cenAsiaBoard/Detail{no}")
    public String cenAsiaBoardDetail(@PathVariable int no, Model model){
        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateCenAsiaHit(no);
        return "CenAsia/cenAsiaBoardDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/cenAsiaBoard/Update{no}")
    public String cenAsiaBoardUpdate(@PathVariable int no, Model model){
        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "CenAsia/cenAsiaBoardUpdateForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/cenAsiaBoard/Update")
    public String cenAsiaBoardUpdates(BoardForm form, MultipartFile file) throws Exception {
        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(form.getId()).get();
        boardOne.setCenasiaTitle(form.getTitle());
        boardOne.setCenasiaContent(form.getContent());
        boardOne.setCenasiaCategory(form.getCategory());
        boardOne.setTubelink(form.getTubelink());
        mainBoardService.cenAsiaInsert(boardOne, file);
        return "redirect:/cenAsiaGallery";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/cenAsiaBoard/Delete{no}")
    public String cenAsiaBoardDelete(@PathVariable int no){
        CenAsiaBoard boardOne = mainBoardService.findCenAsiaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getCenasiaId());
        mainBoardService.cenAsiaRemove(boardOne);
        return "redirect:/cenAsiaGallery";
    }
}
