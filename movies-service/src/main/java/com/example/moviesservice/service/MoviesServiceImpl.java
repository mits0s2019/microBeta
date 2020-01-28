package com.example.moviesservice.service;

import com.example.moviesservice.model.Movie;
import com.example.moviesservice.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    MoviesRepository moviesRepository;



    @Override
    public List<Movie> findAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public Movie create(Movie movie) {
        return  moviesRepository.save(movie);
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        return moviesRepository.findById(id);
    }

    @Override
    public void deleteMovieById(int id) {
        moviesRepository.deleteById(id);
    }

    @Override
    public Movie findMovieByMovieId(String movieId) {
        return moviesRepository.findMovieByMovieId(movieId);
    }
}
