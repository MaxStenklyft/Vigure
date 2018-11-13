package com.cs506.vigure.db.dao;

import java.util.List;

import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

import Enums.DebateStatusEnum;


public interface DebateDAO {
	void sendDebateRequest(DebateEntity debateEntity);
	
	List<DebateEntity> getUsersDebates(UserEntity user);
	 
	void updateDebateStatus(DebateStatusEnum status, int debateID);
}
