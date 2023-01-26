package com.gagan.Dao;

import javax.persistence.EntityManager;

import com.gaga.Exception.InsufficientBalance;
import com.gaga.Exception.InvalidAccount;
import com.gagan.EMUtil.EMUtil;
import com.gagan.EntityClass.Account;

public class AccountDaoImp implements AccountDao{

	@Override
	public void save(Account account) {
		try {
			EntityManager em = EMUtil.provideEntityManager() ;
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			em.close();
			System.out.println("Done");
		} catch (InvalidAccount e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Account findById(int id) throws InvalidAccount {
		Account a = null ;
		EntityManager em = EMUtil.provideEntityManager();
		 
		a = em.find(Account.class, id) ;
		if(a==null) {
			throw new InvalidAccount("Invalid Account") ;
		}
		
		
		return a ;
	}

	@Override
	public void update(Account account) throws InvalidAccount {
		EntityManager em = EMUtil.provideEntityManager();
		int id = account.getId() ;
		Account acc = em.find(Account.class, id) ;
		if(acc==null) {
			throw new InvalidAccount("Invalid account Details") ;
		}
		else {
			System.out.println("Account Updated");
		}
		
	}

	@Override
	public void remove(Account account) throws InvalidAccount {
		try {
		EntityManager em = EMUtil.provideEntityManager() ;
		em.getTransaction().begin();
		em.remove(em);
		em.getTransaction().commit();
		em.close();
		System.out.println("Done");
	} catch(InvalidAccount e) {
		// TODO Auto-generated catch block
//		System.out.println(e.getMessage());
		throw new InvalidAccount("Invalid Account Details") ;
	}
		
	}

	@Override
	public int withdraw(double amount, Account account) throws InsufficientBalance {
		EntityManager em = EMUtil.provideEntityManager() ;
		int id = account.getId();
		Account a1 =em.find(Account.class, id);
		if(a1==null) {
			throw new InvalidAccount("Invalid Account Details") ;
		}
		else {
			
			
			if(a1.getBalance()>= amount) {
				em.getTransaction().begin();
				int amt = (int) (a1.getBalance()-amount) ;
				a1.setBalance(amt);
				em.getTransaction().commit();
				em.close();
			}
			else{
				throw new InsufficientBalance("Insufficient balance") ;  
			}
			
		}
		return a1.getBalance();
		
	}

	@Override
	public String deposit(double amount, Account account) throws InvalidAccount {
		EntityManager em = EMUtil.provideEntityManager() ;
		int id = account.getId();
		String str = "Not done" ;
		Account a1 =em.find(Account.class, id);
		if(a1==null) {
			throw new InvalidAccount("Invalid Account Details") ;
		}
		else {
			
			
			
				em.getTransaction().begin();
				int amt = (int) (a1.getBalance()+amount) ;
				a1.setBalance(amt);
				em.getTransaction().commit();
				em.close();
				str = "done" ;
			
			
		}
		return str;
	}

}
