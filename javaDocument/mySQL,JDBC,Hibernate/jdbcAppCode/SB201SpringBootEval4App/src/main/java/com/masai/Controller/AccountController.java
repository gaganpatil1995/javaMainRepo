package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AccountException;
import com.masai.Exception.InsufficientFundException;
import com.masai.Service.AccountService;
import com.masai.bean.Account;
import com.masai.bean.AccountDTO;

@RestController
public class AccountController {

	@Autowired
	AccountService accSer ; 
	
	@PostMapping("/Account")
	public ResponseEntity<Account> saveaccount(@RequestBody Account acc) throws AccountException{
		
		Account emp1 =  accSer.Openaccount(acc);
		 return new ResponseEntity<>(acc,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/Account/{accno}")
	public ResponseEntity<Account> deleteaccount( @PathVariable("accno") Integer accno) throws AccountException{
		
		Account emp1 =  accSer.closeAccount(accno) ;
		 return new ResponseEntity<>(emp1,HttpStatus.OK);
	}
	@PutMapping("/accountTranfer")
	public ResponseEntity<String> transfer(@RequestBody AccountDTO accsto)throws AccountException,InsufficientFundException{
		
		String str =  accSer.transferAmount(accsto) ;
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/accountdeposit/{amount}/{accno}")
	public ResponseEntity<Account> deposit(@PathVariable("amount") Integer accsto, @PathVariable("accno") Integer accno )throws AccountException{
		
		Account acc = accSer.depositAmount(accno, accsto);
		return new ResponseEntity<Account>(acc, HttpStatus.ACCEPTED);
	}
   

	
	
}
