package com.example.movies2;

import java.util.ArrayList;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String posterId;
    private static ArrayList<Movie> movies = new ArrayList<>();

    public Movie(String title, int year, String genre, String posterId){
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterId = posterId;
    }

    public String getTitle(){
        return title;
    }
    public int getYear(){
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
    public static void addMovie(Movie movie){
        movies.add(movie);
    }
}
