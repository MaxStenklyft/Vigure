package com.cs506.vigure.db.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cs506.vigure.db.entity.LoginEntity;
import com.cs506.vigure.db.entity.UserEntity;

public class UserNameSearchDAOImpl implements UserNameSearchDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public UserEntity searchUserName(String input) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from UserEntity where userName='" + input + "'";
		
		Query<UserEntity> userQuery = currentSession.createQuery(sql, UserEntity.class);
		List<UserEntity> users = userQuery.getResultList();
		
		if (users.size() == 1) {
			return users.get(0);
		}
		
		else if (users.size() == 0) {
			//No match
			return null;
		}
		
		else {
			//TODO Error
			return null;
		}

	}
	
	
}
