package com.cs506.vigure.db.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	@Override
	@Transactional
	public UserEntity searchForEntityById(long input) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from UserEntity where ID='" + input + "'";
		
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

	@Override
	@Transactional
	public UserEntity searchForEntityByUserName(String userName) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from UserEntity where username='" + userName + "'";
		
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
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}

}
