package com.home.prospring.repostory;

//import com.home.prospring.domain.CenAsiaBoard;
import com.home.prospring.domain.*;
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


    /**
     * 중앙아시아
     * @param cenAsiaBoard
     */
    CenAsiaBoard cenAsiaInsert(CenAsiaBoard cenAsiaBoard);
    CenAsiaBoard cenAsiaDelete(CenAsiaBoard cenAsiaBoard);
    List<CenAsiaBoard> findCenAsia();
    Optional<CenAsiaBoard> findCenAsiaBoard(int cenAsiaId);

    /**
     * 중동아시아
     * @param meAsiaBoard
     */
    MEAsiaBoard meAsiaInsert(MEAsiaBoard meAsiaBoard);
    MEAsiaBoard meAsiaDelete(MEAsiaBoard meAsiaBoard);
    List<MEAsiaBoard> findMeAsia();
    Optional<MEAsiaBoard> findMeAsiaBoard(int meAsiaId);

    /**
     * 유럽
     * @param europeBoard
     */
    EuropeBoard europeInsert(EuropeBoard europeBoard);
    EuropeBoard europeDelete(EuropeBoard europeBoard);
    List<EuropeBoard> findEurope();
    Optional<EuropeBoard> findEuropeBoard(int europeId);

    /**
     * 북중미
     * @param ncAmericaBoard
     */
    NCAmericaBoard ncAmericaInsert(NCAmericaBoard ncAmericaBoard);
    NCAmericaBoard ncAmericaDelete(NCAmericaBoard ncAmericaBoard);
    List<NCAmericaBoard> findNcAmerica();
    Optional<NCAmericaBoard> findNcAmericaBoard(int ncAmericaId);
}
