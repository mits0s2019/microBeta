package com.example.moviesservice.repository;

import com.example.moviesservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movie,Integer> {


    Movie findMovieByMovieId(String movieId);
}
