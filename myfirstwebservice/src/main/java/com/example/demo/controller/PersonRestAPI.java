package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/record")
@Api(value = "Person Rest Controller")
public class PersonRestAPI {
	
	@Autowired
	PersonRecordService service;
	
	/**
	 * This api can be used to view a record in the person table accepting PathVariable id
	 * @param id
	 *
	 * @throws Exception
	 */
	///http://localhost:8080/record/person/id
	@GetMapping("/person/{id}")
	@ApiOperation(value = "Get Person Information", response = Person.class, notes = "Returns a single record of Person table.")
	public ResponseEntity<Person> getPersonInfo(@PathVariable("id") int id) throws Exception {
		Person person = service.getPersonInfo(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(person);		
	}
	
	//insert record into the table
	/**
	 * This api can be used to insert a record in the person table accepting RequestBody person
	 * @param person
	 * 
	 * @throws Exception
	 */
	@PostMapping("/person")
	@ApiOperation(value = "Insert Person Information", response = Person.class, notes = "Inserts a single record of Person table.")
	public Person savePersonInfo(@RequestBody Person person) throws Exception {
		return service.savePersonInfo(person);
	} 
	/**
	 * This api can be used to update a record in the person table accepting RequestBody person
	 * @param person
	 * 
	 * @throws Exception
	 */
	@PutMapping("/person")
	@ApiOperation(value = "Update Person Information", response = Person.class, notes = "Updates a single record of Person table.")
	public Person updatePersonInfo(@RequestBody Person person) throws Exception {
		return service.updatePersonInfo(person);
	} 
	
	//http://localhost:8080/record/person?id={person.id}
	/**
	 * This api can be used to delete a record in the person table accepting RequestParam id
	 * @param id
	 * 
	 * @throws Exception
	 */
	@DeleteMapping("/person")
	@ApiOperation(value = "Delete Person Information", response = Person.class, notes = "Deletes a single record of Person table.")
	public String deletePersonInfo(@RequestParam int id) throws Exception{
		return service.deletePersonInfo(id);
	} 
}
