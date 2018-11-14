package com.cs506.vigure.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cs506.vigure.db.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addRegisteredUser(int id, String username,
			String bio, String coi) {
		
		UserEntity currUser = new UserEntity(id, username, bio, coi);
		sessionFactory.getCurrentSession().save(currUser);
	}

}
