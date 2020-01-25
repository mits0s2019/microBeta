package com.example.moviesclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



@Controller
public class WelcomeController {


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String loadUI(){
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
}
