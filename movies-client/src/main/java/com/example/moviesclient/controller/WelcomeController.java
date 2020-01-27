package com.example.moviesclient.controller;

import com.example.moviesclient.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;


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
    @RequestMapping(value = "/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping(value = "/accessToken")
    public ResponseEntity<String> accessToken(){
        try{
            String AccessToken= com.example.moviesclient.config.AccessToken.getAccessToken();
            if (AccessToken!=null){
                return new ResponseEntity<String>(AccessToken, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<String>("NO Access Token", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("NO Access Token", HttpStatus.BAD_REQUEST);
        }
    }
}
