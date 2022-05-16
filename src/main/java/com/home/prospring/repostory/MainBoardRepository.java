package com.home.prospring.repostory;

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



    IndiaBoard indiaInsert(IndiaBoard indiaBoard);
    List<IndiaBoard> findIndia();
    Optional<IndiaBoard> findIndiaBoard(int indiaId);
}
