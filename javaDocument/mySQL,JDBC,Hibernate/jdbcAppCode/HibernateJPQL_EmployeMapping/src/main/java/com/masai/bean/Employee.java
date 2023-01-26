package com.masai.bean;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId ;
	private String name ;
	private Integer salary ;
	
	@ElementCollection
	@Embedded
	private Set<Address> address = new HashSet<>() ;
	
	public Employee() {
		
	}

	public Employee(Integer empId, String name, Integer salary, Set<Address> address) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, empId, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(empId, other.empId)
				&& Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}
	
	
	
	
	
}
