    package com.gagan.EMUtil;

public class Demo {
	static EmployeeDaoImpl empDao  = new EmployeeDaoImpl() ;

	public static void main(String[] args ) {
		
		Employee emp = new Employee(1 ,"gagan","nagpur",250000);
		empDao.save(emp);
//		String address = empDao.getAddressOfEmployee(1) ;
	
//		System.out.println(empDao.giveBonusToEmployee(1, 50000) ) ;
		
//		System.out.println(empDao.deleteEmployee(1));
		
		
	}
}
