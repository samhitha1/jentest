package com.journaldev.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired(required = true)
    @Qualifier(value = "personService")
    public void setPersonService(PersonService ps) {
        this.personService = ps;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> listPersons() {

        return personService.listPersons();
    }

    // //For add and update person both
    // @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    // public String addPerson(@ModelAttribute("person") Person p){
    //
    // if(p.getId() == 0){
    // //new person, add it
    // this.personService.addPerson(p);
    // }else{
    // //existing person, call update
    // this.personService.updatePerson(p);
    // }
    //
    // return "redirect:/persons";
    //
    // }
    //
    // @RequestMapping("/remove/{id}")
    // public String removePerson(@PathVariable("id") int id){
    //
    // this.personService.removePerson(id);
    // return "redirect:/persons";
    // }
    //
    // @RequestMapping("/edit/{id}")
    // public String editPerson(@PathVariable("id") int id, Model model){
    // model.addAttribute("person", this.personService.getPersonById(id));
    // model.addAttribute("listPersons", this.personService.listPersons());
    // return "person";
    // }

}
