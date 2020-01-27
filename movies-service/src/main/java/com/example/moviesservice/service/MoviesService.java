package com.example.moviesservice.service;

import com.example.moviesservice.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MoviesService {

    List<Movie> findAllMovies();
    Movie create(Movie user);
    Optional<Movie> findMovieById(int id);
    void deleteMovieById(int id);
}
