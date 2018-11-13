package com.cs506.vigure.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserDAOImpl implements UserDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addRegisteredUser(int id, String firstName, String lastName, String picture, String username,
			String bio, String coi) {
		Session currentSession = sessionFactory.getCurrentSession();
	}

}
