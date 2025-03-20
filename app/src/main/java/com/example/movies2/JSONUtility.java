package com.example.movies2;

import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;

public class JSONUtility {

    public static void parse(String filePath){

            //https://www.geeksforgeeks.org/parse-json-java/
        try {
            //load and read JSON file
            Object obj = new JSONParser().parse(new FileReader(filePath));
        }catch(IOException e){

        }

    }


}
