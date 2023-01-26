package com.gagan.EMUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "EMP")
public class Employee {
   
	@Id
	private Integer empId ;
	@Column(name = "empName")
    private String name ;
	@Column(name = "empAddres")
    private String address ;
    private Integer salary ;
}
