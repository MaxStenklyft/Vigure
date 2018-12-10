package com.cs506.vigure.db.dao;

import org.hibernate.Session;

import com.cs506.vigure.db.entity.LoginEntity;
import com.cs506.vigure.db.entity.UserEntity;

public interface LoginDAO {
	 boolean register(String email, String user, String password);
	
	 boolean validateUser(String user, String password);
	 
	 int getUsernameID(String user);

}
