package com.example.home.service;

import java.util.Date;

import com.example.home.domains.Home;
import org.apache.ibatis.session.SqlSession;

import com.example.home.configuration.DataSourceConfiguration;
import com.example.home.dao.BaseDAO;
import com.example.home.dao.BaseDAOImpl;

public class BaseServiceImpl implements BaseService{

	BaseDAO baseDao = BaseDAO.getInstance();
	
	@Override
	public Date getDate() throws Exception {
		SqlSession session = DataSourceConfiguration.getSqlSession();
		Date date = null;
		try {
			
			date = baseDao.getDate(session); 	
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session != null) {
				try {
					session.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return date;
	}

	@Override
	public void createTable() throws Exception {
		SqlSession sqlSession = DataSourceConfiguration.getSqlSession();
		try{
			baseDao.createTable(sqlSession);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				try {
					sqlSession.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void addHome(Home home) throws Exception{
		SqlSession sqlSession = DataSourceConfiguration.getSqlSession();
		try{
			baseDao.addHome(sqlSession, home);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				try {
					sqlSession.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void deleteTable(String tableName) throws Exception {
		SqlSession sqlSession = DataSourceConfiguration.getSqlSession();
		try{
			baseDao.deleteTable(sqlSession, tableName);
			baseDao.resetTableSequence(sqlSession, tableName);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				try {
					sqlSession.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Home getHome(String name) throws Exception {
		SqlSession sqlSession = DataSourceConfiguration.getSqlSession();
		Home home = null;
		try{
			home = baseDao.getHome(sqlSession, name);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				try {
					sqlSession.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return home;
	}


}
