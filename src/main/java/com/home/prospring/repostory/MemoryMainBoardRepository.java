package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMainBoardRepository implements MainBoardRepository{

    private static Map<Long, MainBoard> store = new HashMap<>();

    @Override
    public List<MainBoard> findAll() {
        return new ArrayList<>(store.values());
    }
}
