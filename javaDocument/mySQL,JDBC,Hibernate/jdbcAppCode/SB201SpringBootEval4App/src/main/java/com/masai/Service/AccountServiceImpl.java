package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Dao.AccountDao;
import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.bean.Account;
import com.masai.bean.AccountDTO;
import java.util.* ;

public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accDao ;
	
	
	@Override
	public Account Openaccount(Account acc) throws AccountException {
		if(acc.getAccountNo()!=null) {
			throw new AccountException("Account Details with Account no is not valid");
		}
		
		return accDao.save(acc);
	}

	@Override
	public Account closeAccount(Integer accno) throws AccountException {
		
		Optional<Account> op = accDao.findById(accno);
		if(op.isEmpty()) {
			throw new AccountException("Account is not Exist with id :" + accno);
		}
		Account acc = op.get() ;
		accDao.delete(acc);
		return acc;
	}

	@Override
	public Account depositAmount(Integer accno, Integer amount) throws AccountException {
		Optional<Account> op = accDao.findById(amount) ;
		if(op.isEmpty())
			throw new AccountException("Account is not Exist") ;
		Account acc = op.get() ;
		int amt = acc.getBalance() + amount ;
		acc.setBalance(amt);
		
		return accDao.save(acc);
	}

	@Override
	public Account withdrawAmmount(int accno, Integer amount) throws AccountException, InsufficientFundException {
		Optional<Account> op = accDao.findById(amount) ;
		if(op.isEmpty())
			throw new AccountException("Account is not Exist") ;
		Account acc = op.get() ;
		int amt = acc.getBalance();
		if(amt<amount) {
			throw new InsufficientFundException("InsufficientFundException") ;
		}
				
		acc.setBalance(amt - amount); 
		
		
		return accDao.save(acc);
	}

	@Override
	public String transferAmount(AccountDTO dto) throws AccountException, InsufficientFundException {
		Optional<Account> op1 = accDao.findById(dto.getSrcAccno());
		Optional<Account> op2 = accDao.findById(dto.getDesAccno());
		
		if(op1.isEmpty()) {
			throw new AccountException("Source Account is not Found");
		}
		if(op2.isEmpty()) {
			throw new AccountException("Destination Account is not Found");
		}
		Account srcAcc = op1.get() ;
		Account desAcc = op2.get();
		
		if(dto.getAmount()> srcAcc.getBalance()) {
			throw new InsufficientFundException("Insufficient Fund in source Account");
		}
		
		srcAcc.setBalance(srcAcc.getBalance() - dto.getAmount());
		accDao.save(srcAcc) ;
		desAcc.setBalance(desAcc.getBalance() + dto.getAmount() );
		accDao.save(desAcc) ;
		
		return "Ammount is Successfully Transfer";
	}

}
