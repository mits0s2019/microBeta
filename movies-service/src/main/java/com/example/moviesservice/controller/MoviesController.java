package com.example.moviesservice.controller;


import com.example.moviesservice.dto.StringResponse;
import com.example.moviesservice.model.Movie;
import com.example.moviesservice.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @PostMapping(value = "add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@Valid @RequestBody Movie movie){
        Movie searchedMovie=moviesService.findMovieByMovieId(movie.getMovieId());
        if(searchedMovie!=null){
            moviesService.deleteMovieById(searchedMovie.getId());
            return  ResponseEntity.ok(new StringResponse("Movie deleted "));
        }
        Movie createdMovie=moviesService.create(movie);

        return ResponseEntity.ok().body(new StringResponse("Movie Created"));
    }

    @GetMapping("get")
    public ResponseEntity getAllMovies(){
        return ResponseEntity.ok(moviesService.findAllMovies());
    }
}
