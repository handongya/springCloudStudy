package com.handy.servie;

import com.handy.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handy18970 on 2018/3/8.
 */
@Service
public class PersonHystrixService {
    @Autowired
    PersonService personService;
    //使用@HystrixCommand的fallbackMethod 参数指定，当本方法调用失败时，调用后备的方法fallbackSave.
    @HystrixCommand(fallbackMethod = "fallbackSave")
    public List<Person> save(String name){
        return  personService.save(name);
    }
    public List<Person> fallbackSave(){
        List<Person> list=new ArrayList<>();
        Person p=new Person("Person Service 故障");
        list.add(p);
        return list;
    }
}
