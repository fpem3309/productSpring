package com.home.prospring.repostory;

//import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.IndiaBoard;
import com.home.prospring.domain.MainBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import java.util.List;
import java.util.Optional;

public interface MainBoardRepository {
    List<MainBoard> findAll();

    MainBoard Insert(MainBoard mainBoard);
    Optional<MainBoard> findBoard(int mainProductId);
    MainBoard delBoard(MainBoard mainBoard);

    List<MainBoard> findCategory(String mainProductCategory);

    List<MainBoard> findJava();
    List<MainBoard> findSpring();
    List<MainBoard> findAndroid();
    List<MainBoard> findJS();
    List<MainBoard> findJPA();

    List<MainBoard> findAsia();


    /**
     * 인도
     * @param indiaBoard
     */
    IndiaBoard indiaInsert(IndiaBoard indiaBoard);
    IndiaBoard indiaDelete(IndiaBoard indiaBoard);
    List<IndiaBoard> findIndia();
    Optional<IndiaBoard> findIndiaBoard(int indiaId);


    CenAsiaBoard cenAsiaInsert(CenAsiaBoard cenAsiaBoard);
    CenAsiaBoard cenAsiaDelete(CenAsiaBoard cenAsiaBoard);
    List<CenAsiaBoard> findCenAsia();
    Optional<CenAsiaBoard> findCenAsiaBoard(int cenAsiaId);
}
