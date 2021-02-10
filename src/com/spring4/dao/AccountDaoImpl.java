package com.spring4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Autowired
    @Qualifier("dataSource")
    public void setSuperDataSource(DataSource dataSource){
        super.setDataSource(dataSource);
    }
    @Override
    public int out(Integer card, Float money) {
        return getJdbcTemplate().update("UPDATE account SET money = money - ? WHERE card = ?"
        ,money,card);
    }
    @Override
    public int in(Integer card, Float money) {
        return getJdbcTemplate().update("UPDATE account SET money = money + ? WHERE card = ?"
                ,money,card);
    }
}
