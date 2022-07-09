package com.movie.movie_rating.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.movie_rating.users.models.UsersModel;
import com.movie.movie_rating.users.repository.UsersRepo;


@Service
public class UsersServices {
    @Autowired
    private UsersRepo usersRepo;

     public List<UsersModel> getAllUsers()
    {
        return usersRepo.findAll();
    }


    public UsersModel getUser(int id)
    {
        Optional<UsersModel> optional=usersRepo.findById(id);
        return optional.get();
    }


    public UsersModel addUser(UsersModel user)
    {
        UsersModel user1= usersRepo.save(user);
        if(user1==null)
            System.out.println("Checked");
        System.out.println(user1.toString()); 
        return user1;
    }

    public UsersModel updateUser(UsersModel user)
    {

        usersRepo.save(user);
        return user;
    }

    public void deleteUser(int id)
    {
        usersRepo.deleteById(id);
    }


    
}
