package com.masai.Service;

import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.bean.Account;
import com.masai.bean.AccountDTO;

public interface AccountService {

	public Account Openaccount(Account acc)throws AccountException ;
	
	public Account closeAccount(Integer accno)throws AccountException;
	
	public Account depositAmount(Integer accno, Integer amount)throws AccountException;
	
	public Account withdrawAmmount(int accno, Integer amount)throws AccountException, InsufficientFundException;

	public String transferAmount(AccountDTO dto)throws AccountException,InsufficientFundException;

	


}
