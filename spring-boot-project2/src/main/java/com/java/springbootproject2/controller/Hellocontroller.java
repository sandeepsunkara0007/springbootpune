package com.java.springbootproject2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller{
    @Value("${welcome.message}")
    private String welcomemessage;

    @RequestMapping("/welcome1")
    public String helloworld(){

        return welcomemessage;
    }

}

