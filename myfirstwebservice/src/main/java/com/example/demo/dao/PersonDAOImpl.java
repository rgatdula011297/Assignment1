package com.example.demo.dao;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.model.MessageType;
import com.example.demo.entity.Bank;
import com.example.demo.entity.Person;
import com.example.demo.exception.CustomException;
import com.example.demo.repo.BankRepo;
import com.example.demo.repo.PersonRepo;

/**
 * 
 * This class shows the Data Access Object Implementation for Person
 *
 */
@Repository
@Transactional
public class PersonDAOImpl {

	//Perform SQL operation under this class
	
	@Autowired   //widely used for Dependency Injection
	PersonRepo personRepo;
	BankRepo bankRepo;
	
	//Read
	public Person getPersonInfo(int id) throws Exception {
		Optional<Person> person = personRepo.findById(id);
		
		if(person.isEmpty()) {
			throw new NoSuchElementException("No record");
		}
		
		return person.get();
	}
	
	//Create
	public Person savePersonInfo(Person person)throws Exception {
		Optional<Person> personOPT = personRepo.findById(person.getId());
		if(personOPT.isPresent()) {
			throw new CustomException(MessageType.RECORD_EXIST.getCode());
		}
		//persist means insert record into the table
		return personRepo.save(person);
	}
	
	//Update
	public Person updatePersonInfo(Person person) throws Exception {
		Optional<Person> personOPT = personRepo.findById(person.getId());
		if(personOPT.isEmpty()) {
			throw new CustomException(MessageType.UPDATE_DATA.getCode());
		}
		
		return personRepo.saveAndFlush(person);
	}
	
	//Delete
	public String deletePersonInfo(int id) {
		Person person = null;
		String message = "";
		
		try {
			person = getPersonInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
		}
		
		if(person != null) {
			personRepo.delete(person);
			//flag bank record as INACTIVE
			Set<Bank> banks = person.getBank();
			
			if(!banks.isEmpty()) {
				for(Bank bank : banks) {
					bank.setStatus("INACTIVE");
				}
				bankRepo.saveAll(banks);
			}
			message = "Deleted successfully.";
		}else {
			message = "Unsuccessful deletion.";
		}
		return message;
	}
}
