package com.cs506.vigure.db.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

import Enums.DebateStatusEnum;


public interface DebateDAO {
	void sendDebateRequest(DebateEntity debateEntity);
	
	List<DebateEntity> getUsersDebates(long userId);
	 
	void updateDebateStatus(DebateStatusEnum status, long l);
	
	void setSessionFactory(SessionFactory sessionFactory);

	DebateEntity getDebate(long debateId);
}
