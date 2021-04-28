package com.example.demo.dao;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.model.MessageType;
import com.example.demo.entity.Bank;

import com.example.demo.exception.CustomException;
import com.example.demo.repo.BankRepo;

/**
 * 
 * This class shows the Data Access Object Implementation for Bank
 *
 */
@Repository
@Transactional
public class BankDAOImpl {

	//Perform SQL operation under this class
	
	@Autowired   //widely used for Dependency Injection
	BankRepo bankRepo;
	
	//Read
	public Bank getBankInfo(int id) throws Exception {
		Optional<Bank> bank = bankRepo.findById(id);
		
		if(bank.isEmpty()) {
			throw new NoSuchElementException("No record");
		}
		
		return bank.get();
	}
	
	//Create
	public Bank saveBankInfo(Bank bank) throws Exception {
		Optional<Bank> bankOPT = bankRepo.findById(bank.getId());
		if(bankOPT.isPresent()) {
			throw new CustomException(MessageType.RECORD_EXIST.getCode());
		//persist means insert record into the table			
		}
			return bankRepo.save(bank);
	}
	
	//Update
	public Bank updateBankInfo(Bank bank) throws Exception {
		Optional<Bank> bankOPT = bankRepo.findById(bank.getId());
		if(bankOPT.isEmpty()) {
			throw new CustomException(MessageType.UPDATE_DATA.getCode());
		}
		return bankRepo.saveAndFlush(bank);
	}
	
	//Delete
	public String deleteBankInfo(int id) {
		Bank bank = null;
		String message = "";
		
		try {
			bank = getBankInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		if(bank != null) {
			bankRepo.delete(bank);
			message = "Deleted successfully.";
		}else {
			message = "Unsuccessful deletion.";
		}
		return message;
	}
}
