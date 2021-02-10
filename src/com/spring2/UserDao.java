package com.spring2;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void selectUser(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from users");
        for(Map<String,Object> map : list){
            System.out.println(map);
        }
    }
}
