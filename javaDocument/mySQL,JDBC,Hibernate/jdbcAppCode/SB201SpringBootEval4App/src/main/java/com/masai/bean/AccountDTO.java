package com.masai.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {

	private Integer srcAccno ;
	private Integer desAccno ;
	private Integer amount ;
}
