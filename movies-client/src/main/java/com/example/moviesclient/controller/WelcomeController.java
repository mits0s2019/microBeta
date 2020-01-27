package com.example.moviesclient.controller;

import com.example.moviesclient.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;


@Controller
public class WelcomeController {


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String loadUI(Model m, Principal principal){
        if(principal!=null){ m.addAttribute("token",AccessToken.getAccessToken());}
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/profile")
    public String profile(){
        return "profile";
    }

}
