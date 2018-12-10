
package com.cs506.vigure.db.dao;

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

import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.LoginEntity;
import com.cs506.vigure.db.entity.UserEntity;

import Enums.DebateStatusEnum;

@Repository
public class DebateDAOImpl implements DebateDAO {
	
	// inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public void sendDebateRequest(DebateEntity debateEntity) {
		sessionFactory.getCurrentSession().save(debateEntity);
	}

	@Override
	@Transactional
	public List<DebateEntity> getUsersDebates(long userId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from DebateEntity where instigatorNum='" + userId + "'";// OR where defenderNum='" + userId + "'";
		
		Query<DebateEntity> debateQuery = currentSession.createQuery(sql, DebateEntity.class); 
		
		List<DebateEntity> debates = debateQuery.getResultList();
		
		return debates;
	}
	
	@Override
	@Transactional
	public DebateEntity getDebate(long debateId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String sql = "from DebateEntity where ID='" + debateId + "'";// OR where defenderNum='" + userId + "'";
		
		Query<DebateEntity> debateQuery = currentSession.createQuery(sql, DebateEntity.class); 
		
		List<DebateEntity> debates = debateQuery.getResultList();
		
		return debates.get(0);
	}


	@Override
	@Transactional
	public void updateDebateStatus(DebateStatusEnum status, long debateID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<DebateEntity> query1 = currentSession.createQuery("update DebateEntity set status =:status where ID = :ID");
		query1.setInteger("status", 2);
		query1.setLong("ID", debateID);
        query1.executeUpdate();
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	

}