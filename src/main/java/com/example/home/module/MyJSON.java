package com.example.home.module;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.Reader;

public class MyJSON {
    public static JSONArray getJSON(String path){
        JSONArray array = null;
        Reader reader = null;
        JSONParser parser = new JSONParser();
        try{
            reader = new FileReader(path);
            array = (JSONArray)parser.parse(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
        return array;
    }
}
