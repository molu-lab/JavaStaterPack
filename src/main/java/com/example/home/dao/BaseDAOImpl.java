package com.example.home.dao;

import java.util.Date;

import com.example.home.domains.Home;
import org.apache.ibatis.session.SqlSession;

import com.example.home.configuration.DataSourceConfiguration;

public class BaseDAOImpl implements BaseDAO{
	
	private static final String mapperNamespace = "com.example.home.BaseMapper";
	private static BaseDAO instance;
	public static BaseDAO getInstance() {
		if (instance == null)
        {
            synchronized(BaseDAOImpl.class)
            {
            	instance = new BaseDAOImpl();
            }
        }
		return instance;
	}

	@Override
	public Date getDate(SqlSession sqlSession) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		return sqlSession.selectOne(methodNamespace);
	}

	@Override
	public void createTable(SqlSession sqlSession) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		sqlSession.update(methodNamespace);
	}

	@Override
	public void addHome(SqlSession sqlSession, Home home) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		sqlSession.insert(methodNamespace, home);
	}

	@Override
	public void deleteTable(SqlSession sqlSession, String tableName) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		sqlSession.delete(methodNamespace, tableName);
	}

	@Override
	public void resetTableSequence(SqlSession sqlSession, String tableName) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		sqlSession.update(methodNamespace, tableName);
	}

	@Override
	public Home getHome(SqlSession sqlSession, String name) {
		String methodNamespace = String.join(".", new String[]{mapperNamespace, new Object(){}.getClass().getEnclosingMethod().getName()});
		return sqlSession.selectOne(methodNamespace, name);
	}

	;
}
