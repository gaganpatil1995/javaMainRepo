package com.masai;

import javax.persistence.EntityManager;

public class AccountDaoImpl implements AccountDao {
 
	
	@Override
	public Account findById(int id) {
		EntityManager em = EMUtil.provideEntityManager() ;
		Account acc = em.find(Account.class, id) ;
		
		em.close();
		return acc;
	}

	@Override
	public String save(Account account) {
		EntityManager em = EMUtil.provideEntityManager() ;
		
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		
		em.close();
		return "Account Save Successfully " ;
	}

	@Override
	public String update(Account account) {
		EntityManager em = EMUtil.provideEntityManager() ;
		
		em.getTransaction().begin(); 
		em.merge(account) ;
		em.getTransaction().commit();
		em.close();
		return "Account Updated";
	}

	@Override
	public String remove(int id) {
EntityManager em = EMUtil.provideEntityManager() ;
		Account acc = em.find(Account.class, id);
		if(acc==null) {
			return "Account not found" ;
		}
		
		em.getTransaction().begin(); 
		em.remove(acc);
		em.getTransaction().commit();
		em.close();
		return "Account removed";
	}

	@Override
	public String withdraw(double amount, int accountId) {
		EntityManager em  = EMUtil.provideEntityManager() ;
		Account acc = em.find(Account.class, accountId) ;
		if(acc==null) {
			return "Account not found " ;
		}
		if(acc.getBalance()< amount) {
			return "Insufficient Balace " ;
		}
		em.getTransaction().begin();
		acc.setBalance(acc.getBalance() - amount );
		
        em.getTransaction().commit();		
		
        return "Amount Deducted from given Account ";
	}

	@Override
	public String deposit(double amount, int accountId) {
		EntityManager em  = EMUtil.provideEntityManager() ;
		Account acc = em.find(Account.class, accountId) ;
		if(acc==null) {
			return "Account not found " ;
		}
		
		em.getTransaction().begin();
		acc.setBalance(acc.getBalance() + amount );
		
        em.getTransaction().commit();		
		
        return "Amount credited to given Account ";
	}

}
