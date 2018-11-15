package com.cs506.vigure.db.dao;

import com.cs506.vigure.db.entity.UserEntity;

public interface UserNameSearchDAO {
	UserEntity searchUserName(String input);
}
