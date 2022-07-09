package com.movie.movie_rating.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.movie_rating.movies.models.MoviesModel;

@Repository
public interface MoviesRepo extends JpaRepository<MoviesModel,Integer>{
    
}
