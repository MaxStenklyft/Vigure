package com.cs506.vigure.db.dao;

import com.cs506.vigure.db.entity.UserEntity;

public interface UserDAO {
	void addRegisteredUser(int id, String username, String bio, String coi);
	
}
