package com.example.movies2;

import java.util.ArrayList;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String posterId;
    private static ArrayList<Movie> movies = new ArrayList<>();

    //constructor
    public Movie(String title, String year, String genre, String posterId){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterId = posterId;
    }


    public static void addMovie(Movie movie){
        movies.add(movie);
    }


    //getters
    public String getTitle(){
        return title;
    }
    public String getYear(){
        return year;
    }
    public String getGenre(){
        return genre;
    }
    public String getPosterId(){
        return posterId;
    }
    public static ArrayList<Movie> getMovies(){
        return movies;
    }
}
