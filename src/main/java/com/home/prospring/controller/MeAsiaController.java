package com.home.prospring.controller;

import com.home.prospring.domain.BoardForm;
import com.home.prospring.domain.MEAsiaBoard;
import com.home.prospring.repostory.MEAsiaDJRepository;
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
public class MeAsiaController {

    private final MainBoardService mainBoardService;

    @Autowired
    private MEAsiaDJRepository meAsiaDJRepository;

    @Autowired
    public MeAsiaController(MainBoardService mainBoardService) {
        this.mainBoardService = mainBoardService;
    }


    /**
     * 중동 아시아
     */
    @GetMapping("/meAsiaGallery")
    public String MeAsiaGallery(){
        return "/MeAsia/meAsiaGallery";
    }

    @GetMapping("/meAsiaBoard")
    public String MeAsiaList(@RequestParam String country, Model model, @PageableDefault(size=5) Pageable pageable){
        Page<MEAsiaBoard> MeAsiaList = meAsiaDJRepository.findByMeasiaCategory(country, pageable);
        int startPage = Math.max(1,MeAsiaList.getPageable().getPageNumber() -4);   // getPageNumber() - 현재 페이지
        int endPage = Math.min(MeAsiaList.getTotalPages(), MeAsiaList.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("MeAsiaList",MeAsiaList);
        model.addAttribute("country",country);
        return "MeAsia/meAsiaBoard";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/meAsiaBoard/Insert")
    public String MeAsiaBoardForm(Model model){
        model.addAttribute("localDate", LocalDate.now());
        return "MeAsia/meAsiaBoardForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/meAsiaBoard/Insert")
    public String MeAsiaBoardInsert(BoardForm form, MultipartFile file) throws Exception {
        MEAsiaBoard MeAsiaBoard = new MEAsiaBoard();
        MeAsiaBoard.setMeasiaTitle(form.getTitle());
        MeAsiaBoard.setMeasiaContent(form.getContent());
        MeAsiaBoard.setMeasiaDate(form.getDate());
        MeAsiaBoard.setMeasiaCategory(form.getCategory());
        MeAsiaBoard.setTubelink(form.getTubelink());
        mainBoardService.meAsiaInsert(MeAsiaBoard, file);

        return "redirect:/meAsiaGallery";
    }

    @GetMapping("/meAsiaBoard/Detail{no}")
    public String MeAsiaBoardDetail(@PathVariable int no, Model model){
        MEAsiaBoard boardOne = mainBoardService.findMeAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        mainBoardService.updateMeAsiaHit(no);
        return "MeAsia/meAsiaBoardDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/meAsiaBoard/Update{no}")
    public String MeAsiaBoardUpdate(@PathVariable int no, Model model){
        MEAsiaBoard boardOne = mainBoardService.findMeAsiaOne(no).get();
        model.addAttribute("boardOne",boardOne);
        model.addAttribute("localDate", LocalDate.now());
        return "MeAsia/meAsiaBoardUpdateForm";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/meAsiaBoard/Update")
    public String MeAsiaBoardUpdates(BoardForm form, MultipartFile file) throws Exception {
        MEAsiaBoard boardOne = mainBoardService.findMeAsiaOne(form.getId()).get();
        boardOne.setMeasiaTitle(form.getTitle());
        boardOne.setMeasiaContent(form.getContent());
        boardOne.setMeasiaCategory(form.getCategory());
        boardOne.setTubelink(form.getTubelink());
        mainBoardService.meAsiaInsert(boardOne, file);
        return "redirect:/meAsiaGallery";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/meAsiaBoard/Delete{no}")
    public String MeAsiaBoardDelete(@PathVariable int no){
        MEAsiaBoard boardOne = mainBoardService.findMeAsiaOne(no).get();
        System.out.println("삭제 no = "+boardOne.getMeasiaId());
        mainBoardService.meAsiaRemove(boardOne);
        return "redirect:/meAsiaGallery";
    }
}
