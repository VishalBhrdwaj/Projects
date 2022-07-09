package com.movie.movie_rating.movies.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.movie.movie_rating.movies.models.MoviesModel;
import com.movie.movie_rating.movies.repository.MoviesRepo;

@Service
public class MoviesServices {
    
    @Autowired
    private MoviesRepo moviesRepo;

    public List<MoviesModel> getMovies()
    {
       return moviesRepo.findAll();
    }

    public MoviesModel getMovie(int id)
    {
        Optional<MoviesModel> mOptional=moviesRepo.findById(id); 
        return mOptional.get();
    }

    public MoviesModel addMovie(@RequestBody MoviesModel moviesModel)
    {
        return moviesRepo.save(moviesModel);
    } 

    public MoviesModel updateMovie(MoviesModel moviesModel)
    {
      MoviesModel moviesModel1= moviesRepo.findById(moviesModel.getId()).get();
      
      moviesModel1.setName(moviesModel.getName());
      moviesModel1.setDescription(moviesModel.getDescription());
      return moviesRepo.save(moviesModel1);
    }

    public  void deleteMovie(int id)
    {
        moviesRepo.deleteById(id);
    }


}
