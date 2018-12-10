package com.cs506.vigure.db.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Transactional
	public void updateUserSettings(
			String username, long ID, 
			String cat_interests, String bio) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserEntity> query1 = currentSession.createQuery(
				"update LoginEntity set userName =:username where ID = :ID");
		query1.setString("username", username);
		query1.setLong("ID", ID);
        query1.executeUpdate();
        
        Query<UserEntity> query2 = currentSession.createQuery(
				"update UserEntity set categoricalInterest =:cat_interests where ID = :ID");
		query2.setString("cat_interests", cat_interests);
		query2.setLong("ID", ID);
        query2.executeUpdate();
        
        Query<UserEntity> query3 = currentSession.createQuery(
				"update UserEntity set bio =:bio where ID = :ID");
		query3.setString("bio", bio);
		query3.setLong("ID", ID);
        query3.executeUpdate();
		
	}
	

}
