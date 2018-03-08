package com.handy.controller;

import com.handy.dao.PersonRepository;
import com.handy.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by handy18970 on 2018/3/8.
 */
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String personName){
        Person p=new Person(personName);
        personRepository.save(p);
        List<Person> people=personRepository.findAll(new PageRequest(0,10)).getContent();
        return people;
    }
}
