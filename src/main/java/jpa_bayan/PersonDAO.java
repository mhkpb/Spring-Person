/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bayan;

/**
 *
 * @author hasan
 */

 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jpa_bayan.Person;
 
@Repository
public class PersonDAO {
 
   
    
    // private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
  
     private SessionFactory sessionFactory;
      
     public void setSessionFactory(SessionFactory sf){
         this.sessionFactory = sf;
     }
  
    
     
     
     @Transactional
     public void addPerson(Person p) {
         Session session = this.sessionFactory.getCurrentSession();
         session.persist(p);
        // logger.info("Person saved successfully, Person Details="+p);
     }
  
     
     @Transactional
     public void updatePerson(Person p) {
         Session session = this.sessionFactory.getCurrentSession();
         session.update(p);
        // logger.info("Person updated successfully, Person Details="+p);
     }
  
     @SuppressWarnings("unchecked")
     @Transactional
     public List<Person> listPersons() {
         Session session = this.sessionFactory.getCurrentSession();
         List<Person> personsList = session.createQuery("from Person").list();
         for(Person p : personsList){
           //  logger.info("Person List::"+p);
         }
         return personsList;
     }
     
     @SuppressWarnings("unchecked")
     @Transactional
     public List<TestCase> listTestCases() {
         Session session = this.sessionFactory.getCurrentSession();
         List<TestCase> TestCasesList = session.createQuery("from TestCase").list();
         for(TestCase tc : TestCasesList){
           //  logger.info("TestCase List::"+tc);
         }
         return TestCasesList;
     }
     
     
     
  
     @Transactional
     public Person getPersonById(int id) {
         Session session = this.sessionFactory.getCurrentSession();      
         Person p = (Person) session.get(Person.class, new Integer(id));
       //  logger.info("Person loaded successfully, Person details="+p);
         return p;
     }
  
     @Transactional
     public void removePerson(int id) {
         Session session = this.sessionFactory.getCurrentSession();
         Person p = (Person) session.load(Person.class, new Integer(id));
         if(null != p){
             session.delete(p);
         }
        // logger.info("Person deleted successfully, person details="+p);
     }




	public Person getPerson(int id) {
		
		  Session session = this.sessionFactory.getCurrentSession();      
	      Person p = (Person) session.get(Person.class, new Integer(id));
	
	         return p;
	}
    
    
    
    
    
}