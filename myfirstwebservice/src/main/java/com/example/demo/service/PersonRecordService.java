package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.PersonDAOImpl;
import com.example.demo.entity.Person;


@Service
public class PersonRecordService {

	@Autowired
	PersonDAOImpl personDAOImpl;

	public Person getPersonInfo(int id) throws Exception {		
		return personDAOImpl.getPersonInfo(id);
	}

	// Create
	public Person savePersonInfo(Person person) throws Exception {
				
		return personDAOImpl.savePersonInfo(person);
	}

	// Update
	public Person updatePersonInfo(Person person) throws Exception {		
		return personDAOImpl.updatePersonInfo(person);
	}

	// Delete
	public String deletePersonInfo(int id) {
		return personDAOImpl.deletePersonInfo(id);
	}
}