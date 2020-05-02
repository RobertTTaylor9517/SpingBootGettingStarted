package com.javapractice.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.javapractice.demo.dao.PersonDAO;
import com.javapractice.demo.entities.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("people")
@RestController
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping
    public List<Person> people(){
        return personDAO.findAll();
    }

    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        Optional<Person> person = personDAO.findById(id);

        if(person.isPresent()){
            return person.get();
        }else{
            return null;
        }
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        Person newPerson = personDAO.save(person);
        
        return newPerson;
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person newPerson){
        Person person = personDAO.getOne(newPerson.getId());

        person = newPerson;

        return personDAO.save(person);

    }


    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personDAO.deleteById(id);
    }
}