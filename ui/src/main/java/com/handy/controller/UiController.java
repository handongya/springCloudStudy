package com.handy.controller;

import com.handy.domain.Person;
import com.handy.servie.PersonHystrixService;
import com.handy.servie.SomeHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by handy18970 on 2018/3/8.
 */
@RestController
public class UiController {
    @Autowired
    private PersonHystrixService personHystrixService;
    @Autowired
    private SomeHystrixService someHystrixService;
    @RequestMapping("/dispatch")
    public List<Person> sendMessage(@RequestBody String personName){
        return personHystrixService.save(personName);
    }
    @RequestMapping(value = "/getsome",produces={MediaType.TEXT_PLAIN_VALUE})
    public String getSome(){
        return someHystrixService.getSome();
    }
}
