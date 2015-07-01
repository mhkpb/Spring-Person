/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_bayan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import jpa_bayan.Person;
import jpa_bayan.PersonDAO;
 
@Controller
@RequestMapping(value = "/p")
public class PersonController {
     
    private PersonDAO personDao;
     
    @Autowired(required=true)
    //@Qualifier(value="personDao")
    public void setPersonService(PersonDAO  pd){
        this.personDao = pd;
    }
     
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personDao.listPersons());
        return "person";
    }
     
    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
         
        if(p.getPerson_id() == 0){
            //new person, add it
            this.personDao.addPerson(p);
        }else{
            //existing person, call update
            this.personDao.updatePerson(p);
        }
         
        return "redirect:/p/persons";
         
    }
    
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
        this.personDao.removePerson(id);
        return "redirect:/p/persons";
    }
    
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personDao.getPersonById(id));
        model.addAttribute("listPersons", this.personDao.listPersons());
        return "person";
    }
    
}