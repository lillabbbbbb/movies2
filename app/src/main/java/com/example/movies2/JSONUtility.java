package com.example.movies2;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;

public class JSONUtility {
    public static String readJSONFromAssets(Context context, String fileName){
        //JSON file must be located in assets folder.


        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];

            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer, StandardCharsets.UTF_8);
        }catch(FileNotFoundException e){
            //error message logged to the LogCat
            Log.e("TAG",  fileName + " not found in the assets folder.");
        } catch (IOException e) {
            //error message logged to the LogCat
            Log.e("TAG", "IOException");
        }

        return json;
    }

    public static ArrayList<Movie> parseOnlyAllDetails(String json){
        /*
         * parses only those JSON objects that have title, year and genre given.
         * if the poster is missing, a default picture is shown on the app.
         * */

        try {
            // get JSONObject from JSON file
            JSONArray array = new JSONArray(json);

            for(int i = 0; i < array.length(); i++){

                boolean missing = false;

                String[] headers = {"title", "year", "genre", "poster"};
                String title = "", year = "", genre = "", posterId = "";
                String[] variables = {title, year, genre, posterId};

                if(array.getJSONObject(i) == null)  {
                    missing = true;
                    continue;
                }

                for(int j = 0; j < headers.length; j++){
                    try{
                        headers[i] = array.getJSONObject(i).getString(headers[i]);

                    }catch(JSONException e){
                        Log.e("TAG", "Error: " + e);
                    }

                    Log.i("TAG", "parseOnlyAllDetails:" + headers[j] + " : " + array.getJSONObject(i).getString(headers[j]));
                }

                //add movie to static movies arraylist
                Movie.addMovie(new Movie(title, year, genre, posterId));

            }

        }catch(JSONException e){
            //error message logged to the LogCat
            Log.e("TAG",  "JSONException");
        }
        return Movie.getMovies();
    }
    public static ArrayList<Movie> parseWithMissingDetails(String json){
    /*
    * parses JSON objects even if some information is missing.
    * missing information is displayed on the app as an empty string
    * */

        try {

            // get JSONObject from JSON file
            JSONArray array = new JSONArray(json);


            for(int i = 0; i < array.length(); i++){

                boolean empty = true;
                boolean noTitle = false;

                String title = "", year = "", genre = "", posterId = "";


                //parse title
                try{
                    title = array.getJSONObject(i).getString("title");
                    if(title == "null" || title == null){
                        noTitle = true;
                    }else{
                        empty = false;
                    }
                }catch(JSONException e){
                    empty = true;
                    //error message logged to the LogCat
                    Log.e("TAG",  "title not found");
                    continue;

                }

                //parse year
                try{

                    //check if year value is a number
                    int y;
                    y = Integer.valueOf(array.getJSONObject(i).getString("year"));

                    //check if year value is a valid number
                    if(y > 1900 && y <= 2025){
                        year = String.valueOf(array.getJSONObject(i).getString("year"));
                        empty = false;
                    }
                }catch(JSONException e){
                    year = "";

                    //error message logged to the LogCat
                    Log.e("TAG",  "year not found");

                }
                catch(NumberFormatException e){
                    //error message logged to the LogCat
                    Log.e("TAG",  "invalid date");
                    year = "";
                }


                //parse genre
                try{
                    genre = array.getJSONObject(i).getString("genre");
                    empty = false;
                }catch(JSONException e){
                    //error message logged to the LogCat
                    Log.e("TAG",  "genre not found");

                    genre = "";
                }

                //parse poster
                try{
                    posterId = array.getJSONObject(i).getString("poster");
                    empty = false;
                }catch(JSONException e){
                    posterId = "";

                    //error message logged to the LogCat
                    Log.e("TAG",  "poster not found");
                }

                if(!empty && !noTitle){
                    //add movie to static movies arraylist
                    Movie.addMovie(new Movie(title, year, genre, posterId));
                }

                //unit test
                Log.i("TAG", "parseWithMissingDetails:" + "title" + " : " + title);
                Log.i("TAG", "parseWithMissingDetails:" + "year" + " : " + year);
                Log.i("TAG", "parseWithMissingDetails:" + "genre" + " : " + genre);
                Log.i("TAG", "parseWithMissingDetails:" + "poster" + " : " + posterId);


            }

        }catch(JSONException e){
            //error message logged to the LogCat
            Log.e("TAG",  e.getLocalizedMessage());
        }
        return Movie.getMovies();
    }


}
