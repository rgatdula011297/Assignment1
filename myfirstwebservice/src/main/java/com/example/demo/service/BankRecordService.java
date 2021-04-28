package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BankDAOImpl;
import com.example.demo.entity.Bank;

@Service
public class BankRecordService {

	@Autowired
	BankDAOImpl bankDAOImpl;

	public Bank getBankInfo(int id) throws Exception {		
		return bankDAOImpl.getBankInfo(id);
	}

	// Create
	public Bank saveBankInfo(Bank bank) throws Exception {
		// persist means insert record into the table
		return bankDAOImpl.saveBankInfo(bank);
	}

	// Update
	public Bank updateBankInfo(Bank bank) throws Exception {
		return bankDAOImpl.updateBankInfo(bank);
	}

	// Delete
	public String deletePersonInfo(int id) {
		return bankDAOImpl.deleteBankInfo(id);
	}
}