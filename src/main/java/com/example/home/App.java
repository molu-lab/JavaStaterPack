package com.example.home;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import com.example.home.domains.Home;
import com.example.home.module.MyJSON;
import org.apache.ibatis.io.Resources;

import com.example.home.configuration.DataSourceConfiguration;
import com.example.home.service.BaseService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Hello world!
 *
 */
public class App 
{
	static BaseService baseService = BaseService.getInstance();

    public static void main( String[] args )
    {
    	try {

    		DataSourceConfiguration.ready();
        	File file = new File(App.class.getClassLoader().getResource("context-datasource.xml").getFile());
			baseService.createTable();
        	System.out.println(baseService.getDate());
			baseService.deleteTable("HOME");
        	System.out.println(file.exists());
            System.out.println( "Hello World!" );    		
    	}catch(Exception e) {
    		
    	}

    }
}
