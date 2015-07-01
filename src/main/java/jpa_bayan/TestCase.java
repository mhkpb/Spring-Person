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
   
   private int id;

   private String name;
  
   
   
   
     @ManyToOne
  //  @JoinColumn(name = "person_id")
    private Person person;
     
     public TestCase(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
     
   
 
    
    
}