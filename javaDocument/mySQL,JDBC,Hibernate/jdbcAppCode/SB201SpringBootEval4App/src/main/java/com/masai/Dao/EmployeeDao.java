package com.masai.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.bean.Employee;
import com.masai.bean.EmployeeDTO;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public List<Employee> findByAddress(String address) ;
	
//	@Query("select e.name , e.address from Employee e where empId =:empId")
//	public String findingAddress&NameByempployeeId(Integer empId) ;
	public String findNameAndAddresByempId(Integer empId);
	
	@Query("select new EmployeeDTO(e.name ,e.address ,e.salary) from Employee e")
	public List<EmployeeDTO> getAllEmployeeDTO();
}
