package com.movie.movie_rating.users.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsersModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UsersModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "UsersModel [id=" + id + ", name=" + name + "]";
    }
    public UsersModel() {
    }
}
