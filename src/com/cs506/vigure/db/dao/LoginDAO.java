package com.cs506.vigure.db.dao;

import com.cs506.vigure.db.entity.LoginEntity;

public interface LoginDAO {
	 boolean register(String email, String user, String password);
	
	 boolean validateUser(String user, String password);
}
