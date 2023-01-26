package DaoMethods;

import java.util.List;

import BeanClasses.Employee3;


public interface EmployeIntrDao {
	public String saveEmployeeDetails(Employee3 employee);
	public int getSalaryByid(int emid) ;
	public List<Employee3> getAllEmploye();
}
