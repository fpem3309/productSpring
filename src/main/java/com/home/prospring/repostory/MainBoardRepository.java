package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;

import java.util.List;

public interface MainBoardRepository {
    List<MainBoard> findAll();
    MainBoard Insert(MainBoard mainBoard);
}
