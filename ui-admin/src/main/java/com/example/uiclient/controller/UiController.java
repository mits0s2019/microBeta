package com.example.uiclient.controller;


import com.example.uiclient.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;


@Controller
public class UiController  {

    @Autowired
    RestTemplate restTemplate;


@GetMapping("/user")
@ResponseBody
public String getPrinicap(Principal principal){
    return principal.getName();
}

    @RequestMapping(value = "/admin")
    public String loadUIadmin(){
        System.out.println(AccessToken.getAccessToken());

        return "administrator";
    }
    @RequestMapping(value = "/")
    public String loadUI(){
        return "index";
    }

//    @RequestMapping(value = "/users",produces ={MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity getAllUsers(Model m) {
//
//        User[] users = restTemplate.getForObject("http://localhost:8080/user/users", User[].class);
//    m.addAttribute("users",users);
//        return new ResponseEntity(users,HttpStatus.OK);
//    }
    }
