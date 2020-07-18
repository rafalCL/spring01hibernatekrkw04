package pl.coderslab.spring01hibernatekrkw04.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrkw04.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw04.dao.BookDao;
import pl.coderslab.spring01hibernatekrkw04.dao.PersonDao;
import pl.coderslab.spring01hibernatekrkw04.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw04.entity.Author;
import pl.coderslab.spring01hibernatekrkw04.entity.Person;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/form")
    public String form(){
        return "person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public Person formPost(@RequestParam String login,
                           @RequestParam String email,
                           @RequestParam String password){

        Person person = new Person()
                                .setLogin(login)
                                .setEmail(email)
                                .setPassword(password);

        personDao.create(person);

        return person;
    }

    @GetMapping("/formBind")
    public String formBind(Model m){
        m.addAttribute(new Person().setLogin("example"));

        return "person/formBind";
    }

    @PostMapping("/formBind")
    public String formBindPost(@ModelAttribute("person") @Validated Person person,
                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "person/formBind";
        }
        personDao.create(person);

        return "person/details";
    }
}
