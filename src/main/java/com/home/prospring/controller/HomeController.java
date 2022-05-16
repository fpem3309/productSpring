package com.home.prospring.controller;

import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import com.home.prospring.repostory.IndiaDJRepository;
import com.home.prospring.repostory.SpringDataJpaRepository;
import com.home.prospring.service.MainBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    private final MainBoardService mainBoardService;

    @Autowired
    private SpringDataJpaRepository springDataJpaRepository;

    @Autowired
    private IndiaDJRepository indiaDJRepository;

    @Autowired
    public HomeController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }

    @GetMapping("/mainProductBoard")
    public String list(Model model, @PageableDefault(size=5) Pageable pageable, String searchText){
        Page<MainBoard> mainBoardList = springDataJpaRepository.findAll(pageable);
        int startPage = Math.max(1,mainBoardList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(mainBoardList.getTotalPages(), mainBoardList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("mainproducts",mainBoardList);
        return "boards/board";
    }

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
        //mainBoardService.updateHit(no);
        return "boards/indiaBoardDetail";
    }

    @GetMapping("/categoryBoard")
    public String cate_list(Model model, @RequestParam String category){
        List<MainBoard> boardList = mainBoardService.findCategory(category);
        model.addAttribute("categories",boardList);
        return "boards/category_board";
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
        mainBoard.setMainProductCategory(form.getCategory());
        mainBoardService.Insert(mainBoard);

        return "redirect:/mainProductBoard";
    }

    @GetMapping("/mainProductBoard/Detail{no}")
    public String boardDetail(@PathVariable int no, Model model){
        MainBoard boardOne = mainBoardService.findOne(no).get();

        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateHit(no);
        return "boards/boardDetail";
    }

    @GetMapping("/mainProductBoard/Update{no}")
    public String boardUpdate(@PathVariable int no, Model model){
        MainBoard boardOne = mainBoardService.findOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "boards/boardUpdateForm";
    }

    @PostMapping("/mainProductBoard/Update")
    public String boardUpdates(BoardForm form){
        MainBoard boardOne = mainBoardService.findOne(form.getId()).get();
        boardOne.setMainProductTitle(form.getTitle());
        boardOne.setMainProductContent(form.getContent());
        boardOne.setMainProductCategory(form.getCategory());
        mainBoardService.Insert(boardOne);
        System.out.println(boardOne.getMainProductId()+boardOne.getMainProductTitle());
        return "redirect:/mainProductBoard";
    }

    @GetMapping("/mainProductBoard/Delete{no}")
    public String boardDelete(@PathVariable int no){
        MainBoard boardOne = mainBoardService.findOne(no).get();
        System.out.println("삭제 no = "+boardOne.getMainProductId());
        mainBoardService.removeOne(boardOne);
        return "redirect:/mainProductBoard";
    }

}
