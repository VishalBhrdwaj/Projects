package com.movie.movie_rating.movies.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MoviesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String description;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "MoviesModel [description=" + description + ", id=" + id + ", name=" + name + "]";
    }
    public MoviesModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public MoviesModel() {
    }
    
    
}
