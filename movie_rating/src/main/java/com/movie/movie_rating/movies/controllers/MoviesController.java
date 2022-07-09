package com.movie.movie_rating.movies.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie_rating.movies.models.MoviesModel;
import com.movie.movie_rating.movies.services.MoviesServices;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesServices moviesServices;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable("id") int id)
    {

        MoviesModel moviesModel= moviesServices.getMovie(id);
        if(moviesModel!=null)
            return new ResponseEntity<>(moviesModel,HttpStatus.OK);
        return new ResponseEntity<>("Movie not found with this id",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<?> getMovies()
    {
        List<MoviesModel> moviesModels= moviesServices.getMovies();
        
        if(moviesModels!=null)
            return new ResponseEntity<>(moviesModels,HttpStatus.OK);
        
            return new ResponseEntity<>("No movies Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id)
    {
        moviesServices.deleteMovie(id);
        return new ResponseEntity<>("Movie Deleted Successfully",HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMovie(@RequestBody MoviesModel moviesModel)
    {

        MoviesModel moviesModel2=moviesServices.addMovie(moviesModel);
        if(moviesModel2!=null)
            return new ResponseEntity<>(moviesModel2,HttpStatus.OK);

        return new ResponseEntity<>("Movie Not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateMovie(@RequestBody MoviesModel moviesModel){
        MoviesModel moviesModel1=moviesServices.updateMovie(moviesModel);
        if(moviesModel1!=null)
            return new ResponseEntity<>(moviesModel1,HttpStatus.OK);
        return new ResponseEntity<>("Movie Not Updated",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/test")
    public String test()
    {
        return "Jeool";
        // return new ResponseEntity<>("This is a test", HttpStatus.OK);
    }
    
}
