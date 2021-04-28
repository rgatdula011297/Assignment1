package com.example.demo.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This shows the entity for table Bank
 * 
 *
 */
@Entity
@Table(name = "Bank")
public class Bank implements Serializable {
	private static final long serialVersionUID = 1L;
	 /**
	 * DTO 
	 * 
	 */
	@Autowired
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column
	private String accountName;
	
	@Column
	private String bankAddress;
	
	@ManyToOne
	@JoinColumn(name= "personId")
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	//getter-setter SHIFT+ALT+S
	/**
	 * Getter for Id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter for Id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter for Account Name
	 * @return account name
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * Setter for Account Name
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * Getter for Bank Address
	 * @return bank address
	 */
	public String getBankAddress() {
		return bankAddress;
	}
	/**
	 * Setter for Bank Address
	 * @param bankAddress
	 */
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	
}