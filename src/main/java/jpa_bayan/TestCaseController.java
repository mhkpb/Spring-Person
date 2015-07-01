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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import jpa_bayan.TestCase;
import jpa_bayan.TestCaseDAO;
 
@Controller
@RequestMapping(value= "/tc") 
public class TestCaseController {
	 
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
        return "testcase";
    }
     
    //For add and update person both
    @RequestMapping(value= "/testcase/add", method = RequestMethod.POST)
    public String addTestCase(@ModelAttribute("testcase") TestCase tc){
         
        if(tc.getId() == 0){
            //new person, add it
            this.testCaseDao.addTestCase(tc);
        }else{
            //existing tcerson, call utcdate
            this.testCaseDao.updateTestCase(tc);
        }
         
        return "redirect:/tc/testcases";
         
    }
     
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
