package com.gagan.EMUtil;

public interface EmployeeDao {

	public void save(Employee emp) ;
	public String getAddressOfEmployee(Integer empId) ;
	public String giveBonusToEmployee(Integer empId ,Integer bonus );
	public boolean deleteEmployee(Integer empId) ;
}
