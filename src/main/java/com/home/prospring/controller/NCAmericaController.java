package com.home.prospring.controller;

import com.home.prospring.domain.NCAmericaBoard;
import com.home.prospring.repostory.NCAmericaDJRepository;
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
public class NCAmericaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private NCAmericaDJRepository ncAmericaDJRepository;

    @Autowired
    public NCAmericaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중앙 아시아
     */
    @GetMapping("/ncAmericaGallery")
    public String ncAmericaGallery(){
        return "/NcAmerica/ncAmericaGallery";
    }

    @GetMapping("/ncAmericaBoard")
    public String ncAmericaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<NCAmericaBoard> ncAmericaList = ncAmericaDJRepository.findByNcamericaCategory(country, pageable);
        int startPage = Math.max(1,ncAmericaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(ncAmericaList.getTotalPages(), ncAmericaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("ncAmericaList",ncAmericaList);
        model.addAttribute("country",country);
        return "NcAmerica/ncAmericaBoard";
    }

    @GetMapping("/ncAmericaBoard/Insert")
    public String ncAmericaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "NcAmerica/ncAmericaBoardForm";
    }

    @PostMapping("/ncAmericaBoard/Insert")
    public String ncAmericaBoardInsert(BoardForm form){
        NCAmericaBoard ncAmericaBoard = new NCAmericaBoard();
        ncAmericaBoard.setNcamericaTitle(form.getTitle());
        ncAmericaBoard.setNcamericaContent(form.getContent());
        ncAmericaBoard.setNcamericaDate(form.getDate());
        ncAmericaBoard.setNcamericaCategory(form.getCategory());
        mainBoardService.ncAmericaInsert(ncAmericaBoard);

        return "redirect:/ncAmericaGallery";
    }

    @GetMapping("/ncAmericaBoard/Detail{no}")
    public String ncAmericaBoardDetail(@PathVariable int no, Model model){
        NCAmericaBoard boardOne = mainBoardService.findNcAmericaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateNcAmericaHit(no);
        return "NcAmerica/ncAmericaBoardDetail";
    }

    @GetMapping("/ncAmericaBoard/Update{no}")
    public String ncAmericaBoardUpdate(@PathVariable int no, Model model){
        NCAmericaBoard boardOne = mainBoardService.findNcAmericaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "NcAmerica/ncAmericaBoardUpdateForm";
    }

    @PostMapping("/ncAmericaBoard/Update")
    public String ncAmericaBoardUpdates(BoardForm form){
        NCAmericaBoard boardOne = mainBoardService.findNcAmericaOne(form.getId()).get();
        boardOne.setNcamericaTitle(form.getTitle());
        boardOne.setNcamericaContent(form.getContent());
        boardOne.setNcamericaCategory(form.getCategory());
        mainBoardService.ncAmericaInsert(boardOne);
        return "redirect:/ncAmericaGallery";
    }

    @GetMapping("/ncAmericaBoard/Delete{no}")
    public String ncAmericaBoardDelete(@PathVariable int no){
        NCAmericaBoard boardOne = mainBoardService.findNcAmericaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getNcamericaId());
        mainBoardService.ncAmericaRemove(boardOne);
        return "redirect:/ncAmericaGallery";
    }
}
