package com.example.movies2;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class JSONUtility {

    public static ArrayList<Movie> parse(String filePath){

            //source: https://abhiandroid.com/programming/json#gsc.tab=0
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(filePath);
            while(){
                // get the corresponding data
                String[] headers = {"title", "year", "genre", "poster"};
                String title = "", year = "", genre = "", posterId = "";
                String[] variables = {title, year, genre, posterId};

                for(int i = 0; i < headers.length; i++){
                    try{
                        variables[i] = obj.getString(headers[i]);
                    }catch(Exception e){
                        e.printStackTrace();
                        variables[i] = null;
                    }
                }

                //add movie to static movies arraylist
                Movie.addMovie(new Movie(title, Integer.parseInt(year), genre, posterId));
            }
            return Movie.getMovies();


        }catch(JSONException e){
            e.printStackTrace();
            return null;
        }

    }


}
