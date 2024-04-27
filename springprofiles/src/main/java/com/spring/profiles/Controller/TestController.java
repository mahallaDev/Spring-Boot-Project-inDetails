package com.spring.profiles.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.spring.profiles.service.DatabaseService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class TestController {

    // @Autowired
    // DatabaseService databaseService;


    @GetMapping(path = "/profilesdatabase")
    public String pofileActive()
    {
        
        return "active profiles";
    }
    
}
