package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;


import java.util.List;
import java.util.Optional;

public interface MainBoardRepository {
    List<MainBoard> findAll();
    MainBoard Insert(MainBoard mainBoard);
    Optional<MainBoard> findBoard(int mainProductId);
}
