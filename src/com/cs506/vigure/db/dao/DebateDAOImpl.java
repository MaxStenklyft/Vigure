package com.cs506.vigure.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs506.vigure.db.entity.LoginEntity;

@Repository
public class DebateDAOImpl implements DebateDAO {
	
//	/*
//	@Autowired
//	JdbcTemplate myDataSource;
//	*/
//	
//	// inject session factory
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	public void register(String email, String user, String password) {
//		// TODO figure out user registration
//	}
//
//	@Override
//	@Transactional
//	public boolean validateUser(String user, String password) {
//		
//		Session currentSession = sessionFactory.getCurrentSession();
//		
//		String sql = "from LoginEntity where userName='" + user 
//					 + "' and password='" + password + "'";
//		
//		Query<LoginEntity> loginQuery = currentSession.createQuery(sql, LoginEntity.class); 
//		
//		List<LoginEntity> logins = loginQuery.getResultList();
//		
//		if(logins.size() >= 1) {
//			return true;
//		}
//		
//		return false;
//	}

}