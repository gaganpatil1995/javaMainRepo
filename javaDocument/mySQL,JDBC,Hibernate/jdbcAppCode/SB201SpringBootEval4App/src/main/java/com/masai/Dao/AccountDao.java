package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.bean.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
