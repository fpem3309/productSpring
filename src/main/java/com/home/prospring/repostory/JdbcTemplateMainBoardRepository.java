package com.home.prospring.repostory;

import com.home.prospring.domain.MainBoard;
import com.home.prospring.domain.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateMainBoardRepository implements MainBoardRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMainBoardRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MainBoard> findAll() {
        return jdbcTemplate.query("select * from mainproduct order by mainProductId desc", mainBoardRowMapper());
    }

    private RowMapper<MainBoard> mainBoardRowMapper(){
        return (rs, rowNum) -> {
            MainBoard mainBoard = new MainBoard();
            mainBoard.setMainProductId(rs.getInt("mainProductId"));
            mainBoard.setMainProductTitle(rs.getString("mainProductTitle"));
            mainBoard.setMainProductContent(rs.getString("mainProductContent"));
            mainBoard.setMainProductDate(rs.getString("mainProductDate"));

            return mainBoard;
        };
    }
}
