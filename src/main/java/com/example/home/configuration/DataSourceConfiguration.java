package com.example.home.configuration;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.home.App;
public class DataSourceConfiguration {
	private static SqlSessionFactory sqlSessionFactory;	
	public static void ready() throws Exception{
		try {
			InputStream is = DataSourceConfiguration.class.getClassLoader().getResourceAsStream("context-datasource.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			System.out.println("success mapper");
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	

}
