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
 
import jpa_bayan.Test;
import jpa_bayan.TestDAO;
 
@Controller
@RequestMapping(value = "/t")
public class TestController {
     
    private TestDAO testDao;
     
    @Autowired(required=true)
    //@Qualifier(value="testDao")
    public void setTestService(TestDAO  td){
        this.testDao = td;
    }
     
    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public String listTests(Model model) {
        model.addAttribute("test", new Test());
        model.addAttribute("listTests", this.testDao.listTests());
        return "test";
    }
     
    //For add and update test both
    @RequestMapping(value= "/test/add", method = RequestMethod.POST)
    public String addTest(@ModelAttribute("test") Test t){
         
        if(t.getId() == 0){
            //new test, add it
            this.testDao.addTest(t);
        }else{
            //existing test, call update
            this.testDao.updateTest(t);
        }
         
        return "redirect:/t/tests";
         
    }
    
    @RequestMapping("/remove/{id}")
    public String removeTest(@PathVariable("id") int id){
         
        this.testDao.removeTest(id);
        return "redirect:/t/tests";
    }
    
 
    @RequestMapping("/edit/{id}")
    public String editTest(@PathVariable("id") int id, Model model){
        model.addAttribute("test", this.testDao.getTestById(id));
        model.addAttribute("listTests", this.testDao.listTests());
        return "test";
    }
    
}