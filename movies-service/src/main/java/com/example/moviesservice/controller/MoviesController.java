package com.example.moviesservice.controller;


import com.example.moviesservice.model.Movie;
import com.example.moviesservice.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("add")
    public ResponseEntity save(@Valid @RequestBody Movie movie){
        Movie createdMovie=moviesService.create(movie);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{movieId}").buildAndExpand(createdMovie.getMovieId()).toUri();
        return ResponseEntity.created(uri).body(createdMovie);
    }

    @GetMapping("get")
    public ResponseEntity getAllMovies(){
        return ResponseEntity.ok(moviesService.findAllMovies());
    }
}
