package com.example.moviesclient.controller;


import com.example.moviesclient.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class WelcomeController {

//    @Autowired
//    PrincipalExtractor principalExtractor;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String loadUI(){

        System.out.println(AccessToken.getAccessToken());


        return "index";
    }
}
