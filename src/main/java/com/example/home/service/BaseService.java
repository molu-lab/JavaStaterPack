package com.example.home.service;

import java.util.Date;

import com.example.home.domains.Home;
import lombok.Data;


public interface BaseService {

	static final BaseService instance = new BaseServiceImpl(); 
	public static BaseService getInstance() {
		return instance;
	}
	public Date getDate() throws Exception;
	public void createTable() throws Exception;

	public void addHome(Home home) throws Exception;
	public void deleteTable(String tableName) throws Exception;

	public Home getHome(String name) throws Exception;


}
