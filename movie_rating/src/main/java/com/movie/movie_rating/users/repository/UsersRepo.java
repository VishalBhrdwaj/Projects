package com.movie.movie_rating.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.movie_rating.users.models.UsersModel;

@Repository
public interface UsersRepo extends JpaRepository<UsersModel,Integer> {
    
}
