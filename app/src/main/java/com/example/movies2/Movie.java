package com.example.movies2;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String posterId;

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
}
