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

import jpa_bayan.Test;
 
@Repository
public class TestDAO {
 
   
    
    // private static final Logger logger = LoggerFactory.getLogger(TestDAOImpl.class);
  
     private SessionFactory sessionFactory;
      
     public void setSessionFactory(SessionFactory sf){
         this.sessionFactory = sf;
     }
  
    
     
     
     @Transactional
     public void addTest(Test t) {
         Session session = this.sessionFactory.getCurrentSession();
         session.persist(t);
        // logger.info("Test saved successfully, Test Details="+p);
     }
  
     
     @Transactional
     public void updateTest(Test t) {
         Session session = this.sessionFactory.getCurrentSession();
         session.update(t);
        // logger.info("Test updated successfully, Test Details="+p);
     }
  
     @SuppressWarnings("unchecked")
     @Transactional
     public List<Test> listTests() {
         Session session = this.sessionFactory.getCurrentSession();
         List<Test> testsList = session.createQuery("from Test").list();
         for(Test p : testsList){
           //  logger.TestTest List::"+p);
         }
         return testsList;
     }
  
     @Transactional
     public Test getTestById(int id) {
         Session session = this.sessionFactory.getCurrentSession();      
         Test t = (Test) session.get(Test.class, new Integer(id));
       //  logger.info("Test loaded successfully, Test details="+p);
         return t;
     }
  
     @Transactional
     public void removeTest(int id) {
         Session session = this.sessionFactory.getCurrentSession();
         Test t= (Test) session.load(Test.class, new Integer(id));
         if(null != t){
             session.delete(t);
         }
        // logger.info("Test deleted successfully, person details="+p);
     }
    
    
    
    
    
}