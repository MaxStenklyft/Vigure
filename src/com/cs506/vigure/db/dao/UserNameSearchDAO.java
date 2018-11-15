package com.cs506.vigure.db.dao;

import com.cs506.vigure.db.entity.UserEntity;

/**
* The searchUserName method returns a userEntity with a matching userName.
* This method returns a userEntity object or null if there are no userName matches.
*
* @author  Cameron Johnson
* @version 
* @since    
*/
public interface UserNameSearchDAO {
	UserEntity searchUserName(String input);
}
