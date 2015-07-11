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

import jpa_bayan.TestCase;;
 
@Repository
public class TestCaseDAO {
 
   
    
    // private static final Logger logger = LoggerFactory.getLogger(TestCaseDAOImpl.class);
  
     private SessionFactory sessionFactory;
      
     public void setSessionFactory(SessionFactory sf){
         this.sessionFactory = sf;
     }
  
    
     
     
     @Transactional
     public void addTestCase(TestCase tc) {
         Session session = this.sessionFactory.getCurrentSession();
         session.persist(tc);
        // logger.info("TestCase saved successfully, TestCase Details="+p);
     }
  
     
     @Transactional
     public void updateTestCase(TestCase tc) {
         Session session = this.sessionFactory.getCurrentSession();
         session.update(tc);
        // logger.info("TestCase updated successfully, TestCase Details="+tc);
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
     public TestCase getTestCaseById(int id) {
         Session session = this.sessionFactory.getCurrentSession();      
         TestCase tc = (TestCase) session.get(TestCase.class, new Integer(id));
       //  logger.info("TestCase loaded successfully, TestCase details="+tc);
         return tc;
     }
     
    /* @Transactional
     public Person getPersonById(int id) {
         Session session = this.sessionFactory.getCurrentSession();      
         Person p = (Person) session.get(Person.class, new Integer(id));
       //  logger.info("Person loaded successfully, Person details="+p);
         return p;
     }*/
  
  
     @Transactional
     public void removeTestCase(int id) {
         Session session = this.sessionFactory.getCurrentSession();
         TestCase tc = (TestCase) session.load(TestCase.class, new Integer(id));
         if(null != tc){
             session.delete(tc);
         }
        // logger.info("TestCase deleted successfully, TestCase details="+tc);
     }
    
    
    
    
    


}
