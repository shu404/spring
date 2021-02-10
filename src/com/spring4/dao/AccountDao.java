package com.spring4.dao;

public interface AccountDao {
    int out(Integer card,Float money);
    int in(Integer card,Float money);
}
