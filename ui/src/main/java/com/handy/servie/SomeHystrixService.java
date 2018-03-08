package com.handy.servie;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by handy18970 on 2018/3/8.
 */
@Service
public class SomeHystrixService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod="fallbackSome")
    public String getSome(){
        return restTemplate.getForObject("http://some/getsome",String.class);
    }
    public String fallbackSome(){
        return "some service 模块故障";
    }
}
