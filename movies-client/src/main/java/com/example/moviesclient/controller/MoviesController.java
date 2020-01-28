package com.example.moviesclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoviesController {


    @GetMapping("/discover")
    public String discoverMovies(@RequestParam(required = false,name="page") String page, Model m){
        if(page==null){m.addAttribute("page","1");
        }else{
        m.addAttribute("page",page);}
        return "discoverMovies";
    }
}
