package com.home.prospring.service;

import com.home.prospring.domain.*;
import com.home.prospring.repostory.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class MainBoardService {

    private final MainBoardRepository mainBoardRepository;
    private final SpringDataJpaRepository springDataJpaMemberRepository;
    private final IndiaDJRepository indiaDJRepository;
    private final CenAsiaDJRepository cenAsiaDJRepository;
    private final MEAsiaDJRepository meAsiaDJRepository;
    private final EuropeDJRepository europeDJRepository;
    private final NCAmericaDJRepository ncAmericaDJRepository;
    private final SAmericaDJRepository sAmericaDJRepository;
    private final ESAsiaDJRepository esAsiaDJRepository;

    public MainBoardService(MainBoardRepository mainBoardRepository, SpringDataJpaRepository springDataJpaMemberRepository, IndiaDJRepository indiaDJRepository, CenAsiaDJRepository cenAsiaDJRepository, MEAsiaDJRepository meAsiaDJRepository, EuropeDJRepository europeDJRepository, NCAmericaDJRepository ncAmericaDJRepository, SAmericaDJRepository sAmericaDJRepository, ESAsiaDJRepository esAsiaDJRepository) {
        this.mainBoardRepository = mainBoardRepository;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
        this.indiaDJRepository = indiaDJRepository;
        this.cenAsiaDJRepository = cenAsiaDJRepository;
        this.meAsiaDJRepository = meAsiaDJRepository;
        this.europeDJRepository = europeDJRepository;
        this.ncAmericaDJRepository = ncAmericaDJRepository;
        this.sAmericaDJRepository = sAmericaDJRepository;
        this.esAsiaDJRepository = esAsiaDJRepository;
    }

    public int updateHit(int id){
        return springDataJpaMemberRepository.updateCount(id);
    }


    /**
     * 게시글 등록
     */
    public int Insert(MainBoard mainBoard){
        mainBoardRepository.Insert(mainBoard);
        return mainBoard.getMainProductId();
    }


    /**
     * 동남아시아
     * @param esAsiaBoard
     */
    public int esAsiaInsert(ESAsiaBoard esAsiaBoard, MultipartFile file) throws Exception {

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        esAsiaBoard.setFilename(fileName);
        esAsiaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.esAsiaInsert(esAsiaBoard);
        return esAsiaBoard.getEsasiaId();
    }
    public int esAsiaRemove(ESAsiaBoard esAsiaBoard){
        mainBoardRepository.esAsiaDelete(esAsiaBoard);
        return esAsiaBoard.getEsasiaId();
    }
    public Optional<ESAsiaBoard> findEsAsiaOne(int esAsiaId){
        return mainBoardRepository.findEsAsiaBoard(esAsiaId);
    }
    public int updateEsAsiaHit(int id){
        return esAsiaDJRepository.updateCount(id);
    }

    /**
     * 인도
     */
    public int indiaInsert(IndiaBoard indiaBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        indiaBoard.setFilename(fileName);
        indiaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.indiaInsert(indiaBoard);
        return indiaBoard.getIndiaId();
    }
    public int indiaRemove(IndiaBoard indiaBoard){
        mainBoardRepository.indiaDelete(indiaBoard);
        return indiaBoard.getIndiaId();
    }
    public Optional<IndiaBoard> findIndiaOne(int indiaId){
        return mainBoardRepository.findIndiaBoard(indiaId);
    }
    public int updateIndiaHit(int id){
        return indiaDJRepository.updateCount(id);
    }

    /**
     * 중앙아시아
     */
    public int cenAsiaInsert(CenAsiaBoard cenAsiaBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        cenAsiaBoard.setFilename(fileName);
        cenAsiaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.cenAsiaInsert(cenAsiaBoard);
        return cenAsiaBoard.getCenasiaId();
    }
    public int cenAsiaRemove(CenAsiaBoard cenAsiaBoard){
        mainBoardRepository.cenAsiaDelete(cenAsiaBoard);
        return cenAsiaBoard.getCenasiaId();
    }
    public Optional<CenAsiaBoard> findCenAsiaOne(int cenAsiaId){
        return mainBoardRepository.findCenAsiaBoard(cenAsiaId);
    }
    public int updateCenAsiaHit(int id){
        return cenAsiaDJRepository.updateCount(id);
    }

    /**
     * 중동아시아
     * @param meAsiaBoard
     */
    public int meAsiaInsert(MEAsiaBoard meAsiaBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        meAsiaBoard.setFilename(fileName);
        meAsiaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.meAsiaInsert(meAsiaBoard);
        return meAsiaBoard.getMeasiaId();
    }
    public int meAsiaRemove(MEAsiaBoard meAsiaBoard){
        mainBoardRepository.meAsiaDelete(meAsiaBoard);
        return meAsiaBoard.getMeasiaId();
    }
    public Optional<MEAsiaBoard> findMeAsiaOne(int meAsiaId){
        return mainBoardRepository.findMeAsiaBoard(meAsiaId);
    }
    public int updateMeAsiaHit(int id){
        return meAsiaDJRepository.updateCount(id);
    }

    /**
     * 유럽
     * @param europeBoard
     */
    public int europeInsert(EuropeBoard europeBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        europeBoard.setFilename(fileName);
        europeBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.europeInsert(europeBoard);
        return europeBoard.getEuropeId();
    }
    public int europeRemove(EuropeBoard europeBoard){
        mainBoardRepository.europeDelete(europeBoard);
        return europeBoard.getEuropeId();
    }
    public Optional<EuropeBoard> findEuropeOne(int europeId){
        return mainBoardRepository.findEuropeBoard(europeId);
    }
    public int updateEuropeHit(int id){
        return europeDJRepository.updateCount(id);
    }

    /**
     * 북중미
     * @param ncAmericaBoard
     */
    public int ncAmericaInsert(NCAmericaBoard ncAmericaBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        ncAmericaBoard.setFilename(fileName);
        ncAmericaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.ncAmericaInsert(ncAmericaBoard);
        return ncAmericaBoard.getNcamericaId();
    }
    public int ncAmericaRemove(NCAmericaBoard ncAmericaBoard){
        mainBoardRepository.ncAmericaDelete(ncAmericaBoard);
        return ncAmericaBoard.getNcamericaId();
    }
    public Optional<NCAmericaBoard> findNcAmericaOne(int ncAmericaId){
        return mainBoardRepository.findNcAmericaBoard(ncAmericaId);
    }
    public int updateNcAmericaHit(int id){
        return ncAmericaDJRepository.updateCount(id);
    }


    /**
     * 남미
     * @param sAmericaBoard
     */
    public int sAmericaInsert(SAmericaBoard sAmericaBoard, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath,fileName);

        file.transferTo(saveFile);

        sAmericaBoard.setFilename(fileName);
        sAmericaBoard.setFilepath("/files/"+fileName);

        mainBoardRepository.sAmericaInsert(sAmericaBoard);
        return sAmericaBoard.getSamericaId();
    }
    public int sAmericaRemove(SAmericaBoard sAmericaBoard){
        mainBoardRepository.sAmericaDelete(sAmericaBoard);
        return sAmericaBoard.getSamericaId();
    }
    public Optional<SAmericaBoard> findSAmericaOne(int sAmericaId){
        return mainBoardRepository.findSAmericaBoard(sAmericaId);
    }
    public int updateSAmericaHit(int id){
        return sAmericaDJRepository.updateCount(id);
    }


    /**
     *
     * @return
     */

    //전체 글
    public List<MainBoard> mainBoard(){
        return mainBoardRepository.findAll();
    }

    //메인화면 글
    public Optional<MainBoard> findOne(int mainProductId){
        return mainBoardRepository.findBoard(mainProductId);
    }

    public int removeOne(MainBoard mainBoard){
        mainBoardRepository.delBoard(mainBoard);
        return mainBoard.getMainProductId();
    }


    public List<MainBoard> findCategory(String mainProductCategory){
        return mainBoardRepository.findCategory(mainProductCategory);
    }




    /**
     * 메인 카테고리별
     */


    public List<MainBoard> asiaBoard(){return mainBoardRepository.findAsia();}

    public List<IndiaBoard> indiaBoard(){return mainBoardRepository.findIndia();}
    public List<CenAsiaBoard> cenAsiaBoard(){return mainBoardRepository.findCenAsia();}
    public List<MEAsiaBoard> meAsiaBoard(){return mainBoardRepository.findMeAsia();}
    public List<EuropeBoard> europeBoard(){return mainBoardRepository.findEurope();}
    public List<NCAmericaBoard> ncAmericaBoard(){return mainBoardRepository.findNcAmerica();}
    public List<SAmericaBoard> sAmericaBoard(){return mainBoardRepository.findSAmerica();}
    public List<ESAsiaBoard> esAsiaBoard(){return mainBoardRepository.findEsAsia();}

}
