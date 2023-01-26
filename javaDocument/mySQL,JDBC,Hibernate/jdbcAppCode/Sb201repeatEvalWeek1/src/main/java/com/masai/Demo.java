package com.masai;

public class Demo {

	public static void main(String[] args) {
		AccountDaoImpl accDao = new AccountDaoImpl();
		
//		Account acc = new Account(1 , "gaga@123","nagpur",2300) ;
//		accDao.save(acc) ;
		
//		Account acc = new Account(1 , "pawa@123","nagpur",2300) ;
//		accDao.update(acc);
		
//		accDao.remove(1) ;
		
//		Account acc = accDao.findById(1);
//		System.out.println(acc);
//		String str = accDao.withdraw(2000, 1);
//		System.out.println(str) ;
		
		System.out.println(accDao.deposit(2000, 1)) ;
	}
}
