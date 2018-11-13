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

import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

import Enums.DebateStatusEnum;

@Repository
public class DebateDAOImpl implements DebateDAO {
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public void sendDebateRequest(DebateEntity debateEntity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(debateEntity);
	}

	@Override
	public List<DebateEntity> getUsersDebates(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateDebateStatus(DebateStatusEnum status, int debateID) {
		// TODO Auto-generated method stub
		
	}
	

}