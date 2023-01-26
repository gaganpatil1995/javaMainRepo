package com.gagan.Dao;

import com.gaga.Exception.InsufficientBalance;
import com.gaga.Exception.InvalidAccount;
import com.gagan.EntityClass.Account;

public interface AccountDao {

	void save(Account account);
	Account findById(int id) throws InvalidAccount;
	void update(Account account) throws InvalidAccount;
	void remove(Account account) throws InvalidAccount;
	int withdraw(double amount, Account account) throws InsufficientBalance;
	String deposit(double amount, Account account) throws InvalidAccount;
}
