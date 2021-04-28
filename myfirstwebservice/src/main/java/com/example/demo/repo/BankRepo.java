package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Bank;

/**
 * 
 * Class for Bank Repository
 *
 */
public interface BankRepo extends JpaRepository<Bank, Integer>{

}
