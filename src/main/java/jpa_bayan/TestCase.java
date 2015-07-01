/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bayan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hasan
 */

@Entity
@Table
public class TestCase {
     
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   
   private int testcase_id;

   private String testcase_name;
  
   
   
   
     @ManyToOne
  //  @JoinColumn(name = "person_id")
    private Person person;
     
     public TestCase(){}

    public void setTestcase_id(int testcase_id) {
        this.testcase_id = testcase_id;
    }

    public int getTestcase_id() {
        return testcase_id;
    }

    public void setTestcase_name(String testcase_name) {
        this.testcase_name = testcase_name;
    }

    public String getTestcase_name() {
        return testcase_name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
     
   
 
    
    
}