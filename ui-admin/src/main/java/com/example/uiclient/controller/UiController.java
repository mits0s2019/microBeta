package com.example.uiclient.controller;


import com.example.uiclient.config.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


        return "administrator";
    }
    @RequestMapping(value = "/")
    public String loadUI(){

        return "index";
    }

//    @RequestMapping(value = "/accessToken")
//    public ResponseEntity<String> accessToken(){
//        try{
//            String AccessToken= com.example.uiclient.config.AccessToken.getAccessToken();
//           if (AccessToken!=null){
//               return new ResponseEntity<String>(AccessToken, HttpStatus.OK);
//           }
//           else{
//               return new ResponseEntity<String>("NO Access Token", HttpStatus.BAD_REQUEST);
//           }
//        }catch (Exception e){
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }


    }
