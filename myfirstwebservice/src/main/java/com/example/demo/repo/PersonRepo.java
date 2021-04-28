package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Person;
/**
 * 
 * Class for Person Repository
 *
 */
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
