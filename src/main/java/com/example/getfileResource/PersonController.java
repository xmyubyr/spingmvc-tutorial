package com.example.getfileResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class PersonController {
    @Autowired
    private Person person;
    @RequestMapping("")
    public void helloPerson(){
        System.out.println(person);
    }

}
