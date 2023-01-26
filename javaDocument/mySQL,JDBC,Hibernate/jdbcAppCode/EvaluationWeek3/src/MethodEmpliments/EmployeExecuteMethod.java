package MethodEmpliments;

import Beanclass.Employee;
import methods.EmployeMethoImp;
import methods.EmpoyeMethodIntr;

public class EmployeExecuteMethod {

	public static void main(String[] args) {
		Employee em = new Employee(1,"saga","bhandara",2000) ;
		
		EmpoyeMethodIntr emp = new EmployeMethoImp();
		String Detail = emp.saveEmployeeDetails(em) ;
		System.out.println(Detail);
	}
}
