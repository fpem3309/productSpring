package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.domain.Member;

import java.util.List;

public interface MainBoardRepository {
    List<MainBoard> findAll();
}
