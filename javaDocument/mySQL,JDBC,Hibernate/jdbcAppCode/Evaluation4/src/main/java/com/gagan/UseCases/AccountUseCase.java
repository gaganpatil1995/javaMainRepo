package com.gagan.UseCases;

import com.gagan.Dao.AccountDaoImp;
import com.gagan.EntityClass.Account;

public class AccountUseCase {

	public static void main(String[] args) {
		
		AccountDaoImp dao = new AccountDaoImp();
		
		Account a1 = new Account(2, "kiran", "chind", 5000) ;
		
		dao.save(a1);
		
	}
}
