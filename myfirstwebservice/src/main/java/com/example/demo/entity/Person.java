package com.example.demo.entity;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This shows the entity for the table Person
 * 
 *
 **/
@Entity
@Table(name = "Person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany(mappedBy= "person")
    @JsonIgnoreProperties(value = "person")
    private Set<Bank> bank;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String address;

    //getter-setter SHIFT+ALT+S
    /**
     * Getter for Id
     **/
    public int getId() {
        return id;
    }
    /**
     * Setter for Id
     * @param id
     **/
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Getter for Name
     * @return name
     **/
    public String getName() {
        return name;
    }
    /**
     * Setter for Name
     * @param name
     **/
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for Last Name
     * @return last name
    **/
    public String getLastName() {
        return lastName;
    }
    /**
     * Setter for Last Name
     * @param lastName
     **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Getter for Address
     * @return address
     **/
    public String getAddress() {
        return address;
    }
    /**
     * Setter for Address
     * @param address
     **/
    public void setAddress(String address) {
        this.address = address;
    }
	public Set<Bank> getBank() {
		return bank;
	}
	public void setBank(Set<Bank> bank) {
		this.bank = bank;
	}
  


}