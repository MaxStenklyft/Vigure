package com.cs506.vigure.db.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import com.cs506.vigure.db.entity.UserEntity;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	/*
	@Autowired
	JdbcTemplate myDataSource;
	*/
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public boolean register(String email, String user, String password) {
		//Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from LoginEntity where userName='" + user + "'";
		
		Query<LoginEntity> loginQuery = currentSession.createQuery(sql, LoginEntity.class);
		
		List<LoginEntity> logins = loginQuery.getResultList();
		
		// begin username check
		if(logins.size() > 0) {
			// TODO non-unique username error
			return false;
		}
		else if(!(email.substring(email.indexOf("@")+1).equals("wisc.edu"))) {
			// TODO non-wisc email error
			return false;
		}
		else { // username is good, begin password check
			if(password.length() < 6 || password.length() > 20) {
				// TODO bad password length
				return false;
			}
		}
		
		String hashedPassword = null;
		
		try {
			// begin password hashing
			// Create MessageDigest instance for MD5
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        //Add password bytes to digest
	        md.update(password.getBytes());
	        //Get the hash's bytes
	        byte[] bytes = md.digest();
	        //This bytes[] has bytes in decimal format;
	        //Convert it to hexadecimal format
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i < bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        //Get complete hashed password in hex format
	        hashedPassword = sb.toString();	
	        password = null;
		}
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
		
		if(hashedPassword != null) { // if password hash was successful
			// store entry to login_model table in DB
			LoginEntity currUserLogin = new LoginEntity(email, user, hashedPassword);
			//sessionFactory.getCurrentSession().save(currUserLogin);
			currentSession.save(currUserLogin);
			
			return true; // passes all checks the user can be registered!
		}
		else {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean validateUser(String user, String password) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from LoginEntity where userName='" + user 
					 + "' and password='" + password + "'";
		
		Query<LoginEntity> loginQuery = currentSession.createQuery(sql, LoginEntity.class); 
		
		List<LoginEntity> logins = loginQuery.getResultList();
		
		if(logins.size() >= 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	@Transactional
	public int getUsernameID(String user) {
		//Session currentSession = sessionFactory.getCurrentSession();
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from LoginEntity where userName='" + user + "'";
		
		Query<LoginEntity> loginQuery = currentSession.createQuery(sql, LoginEntity.class);
		
		List<LoginEntity> logins = loginQuery.getResultList();
		
		if (logins.get(0) != null) {
			return logins.get(0).getId();
		}
		
		else {
			return -1;
		}
	}
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}


}