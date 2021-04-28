package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bank;

import com.example.demo.service.BankRecordService;


@RestController
@RequestMapping("/record")
public class BankRestAPI {
	
	@Autowired
	BankRecordService service;
	
	///http://localhost:8080/record/bank/id
	@GetMapping("/bank/{id}")
	public Bank getBankInfo(@PathVariable("id") int id) throws Exception {
		Bank bank = service.getBankInfo(id);
		return bank;		
	}
	
	//insert record into the table
	/**
	 * This api can be used to insert a record in the bank table
	 * @param bank
	 * 
	 * @throws Exception
	 */
	@PostMapping("/bank")	
	public Bank saveBankInfo(@RequestBody Bank bank) throws Exception {
		return service.saveBankInfo(bank);
	} 
	/**
	 * This api can be used to update a record in the bank table
	 * @param bank
	 * 
	 */
	@PutMapping("/bank")	
	public Bank updateBankInfo(@RequestBody Bank bank) throws Exception {
		return service.updateBankInfo(bank);
	} 
	
	//http://localhost:8080/record/bank?id={bank.id}
	/**
	 * This api can be used to delete a record in the bank table
	 * @param id
	 * 
	 */
	@DeleteMapping("/bank")	
	public String deleteBankInfo(@RequestParam int id){
		return service.deletePersonInfo(id);
	} 
}

