package com.example.home.dao;

import java.util.Date;

import com.example.home.domains.Home;
import org.apache.ibatis.session.SqlSession;

import com.example.home.service.BaseService;
import com.example.home.service.BaseServiceImpl;

public interface BaseDAO {
	static final BaseDAO instance = new BaseDAOImpl(); 
	public static BaseDAO getInstance() {
		return instance;
	}
	public Date getDate(SqlSession sqlSession);
	public void createTable(SqlSession sqlSession);
	public void addHome(SqlSession sqlSession, Home home);

	public void deleteTable(SqlSession sqlSession, String tableName);
	public void resetTableSequence(SqlSession sqlSession, String tableName);
	public Home getHome(SqlSession sqlSession, String name);
}
