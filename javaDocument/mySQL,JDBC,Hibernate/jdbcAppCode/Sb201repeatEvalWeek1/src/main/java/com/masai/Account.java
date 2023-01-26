package com.masai;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
     
	@Id
	private Integer id ;
	private String email ;
	private String address ;
	private double balance ;
	public Account(Integer id, String email, String address, double balance) {
		super();
		this.id = id;
		this.email = email;
		this.address = address;
		this.balance = balance;
	}
	
	public Account() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", address=" + address + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, balance, email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(address, other.address)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}
	
}
