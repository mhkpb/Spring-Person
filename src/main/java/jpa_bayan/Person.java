/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bayan;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author hasan
 */
@Entity
@Table
public class Person {
    
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 	
 
   private int person_id;

   private String firstName;

   private String lastName;

   private String email;

   private String password;

   private String user_name;
  
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "person")
    private List<TestCase>  testcases;
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "person")
    private List<Test>   Tests;

    public Person() {
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public int getPerson_id() {
        return person_id;
    }

    public List<TestCase> getTestcases() {
        return testcases;
    }

    public void setTestcases(List<TestCase> testcases) {
        this.testcases = testcases;
    }

    public void setTests(List<Test> Tests) {
		this.Tests = Tests;
	}
    public List<Test> getTests() {
		return Tests;
	}
   
    
    
    

    public String getUser_name() {
        return user_name;
    }

   

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    @Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return firstName; 
    	}
    
    
   }