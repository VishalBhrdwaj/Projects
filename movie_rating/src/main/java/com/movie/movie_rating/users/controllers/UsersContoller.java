package com.movie.movie_rating.users.controllers;

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

import com.movie.movie_rating.users.models.UsersModel;
import com.movie.movie_rating.users.services.UsersServices;

@RestController
@RequestMapping("/users")
public class UsersContoller {
    
    @Autowired
    private UsersServices usersServices;
    

    @GetMapping("/")
    public ResponseEntity<?> getUsers()
    {
        return new ResponseEntity<>(usersServices.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") int id)
    {
        return new ResponseEntity<>(usersServices.getUser(id),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UsersModel user)
    {
        
        usersServices.addUser(user);

        return new ResponseEntity<>("User Successfully Created ",HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") int id ,@RequestBody UsersModel user)
    {
        usersServices.updateUser(user);
        return new ResponseEntity<>("User Upadated Successfully",HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id)
    {
        usersServices.deleteUser(id);
        return new ResponseEntity<>("User Deleted SuccessFully",HttpStatus.OK);       
    }

    @GetMapping("/test")
    public ResponseEntity<?> test()
    {
        return new ResponseEntity<>("This is a test", HttpStatus.OK);
    }


}
