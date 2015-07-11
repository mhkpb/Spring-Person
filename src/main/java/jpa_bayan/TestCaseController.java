/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package jpa_bayan;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jpa_bayan.TestCase;
import jpa_bayan.TestCaseDAO;
 
@Controller
@RequestMapping(value= "/tc") 
public class TestCaseController {
	
	  private PersonDAO personDao;
	   
	     
	    @Autowired(required=true)
	    //@Qualifier(value="personDao")
	    public void setPersonService(PersonDAO  pd){
	        this.personDao = pd;
	    }
	 
	    @InitBinder
	    public void initBinder(WebDataBinder binder)    {
	    binder.registerCustomEditor(Person.class, new P_PropertyEditor(personDao));
	    }
	    
	 
    private TestCaseDAO testCaseDao;
     
    @Autowired(required=true)
   // @Qualifier(value="testCaseDao")
    public void setTestCaseService(TestCaseDAO  tcd){
        this.testCaseDao = tcd;
    }
     
    @RequestMapping(value = "/testcases", method = RequestMethod.GET)
    public String listTestCases(Model model) {
        model.addAttribute("testcase", new TestCase());
        model.addAttribute("listTestCases", this.testCaseDao.listTestCases());
        model.addAttribute("listPersons", this.personDao.listPersons());
        return "testcase";
    }
    
/*
@RequestMapping(value = "/", method = RequestMethod.GET)
public String showForm(Model model) {
            Person p = new Person();// declareing

            model.addAttribute("person",p); // adding in model
   return "person";
}
*/

     
    //For add and update person both
    @RequestMapping(value= "/testcase/add", method = RequestMethod.POST)
    public String addTestCase(@ModelAttribute("testcase") TestCase tc ){
    	
   
    	
        if(tc.getId() == 0){
            //new person, add it
            this.testCaseDao.addTestCase(tc);
           
        }else{
            //existing tcerson, call utcdate
            this.testCaseDao.updateTestCase(tc);
        }
         
        return "redirect:/tc/testcases";
         
    }
  /*  @RequestMapping(value= "/testcase/add1", method = RequestMethod.POST)
    public void setPerson( @ModelAttribute("testcase") TestCase tc , @PathVariable(" ${person.person_id}") int id ){
    		tc.setPerson(this.testCaseDao.getPersonById(id));
    }*/
     
    @RequestMapping("/remove/{id}")
    public String removeTestCase(@PathVariable("id") int id){
         
        this.testCaseDao.removeTestCase(id);
        return "redirect:/tc/testcases";
    }
  
    @RequestMapping("/edit/{id}")
    public String editTestCase(@PathVariable("id") int id, Model model){
        model.addAttribute("testcase", this.testCaseDao.getTestCaseById(id));
        model.addAttribute("listTestCases", this.testCaseDao.listTestCases());
        return "testcase";
    }
     
}
