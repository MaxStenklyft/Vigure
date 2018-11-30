package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cs506.vigure.db.dao.DebateDAOImpl;
import com.cs506.vigure.db.entity.DebateEntity;

public class DebateDAOImplTest {
	DebateDAOImpl debateDAO = new DebateDAOImpl();
	private SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
	private Session mockedSession = Mockito.mock(Session.class);
	private Query<DebateEntity> mockedQuery = Mockito.mock(Query.class);
	private List<DebateEntity> mockedList = Mockito.mock(List.class);
	
	@Test
	void testSendDebateRequest() {
		debateDAO.setSessionFactory(this.mockedSessionFactory);
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		
		debateDAO.sendDebateRequest(new DebateEntity());
	}
	
	@Test
	void testGetUsersDebates() {
		debateDAO.setSessionFactory(this.mockedSessionFactory);
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.createQuery("from DebateEntity where instigatorNum='-1'", DebateEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
	    
		//test on nonexistent user
		assertEquals(debateDAO.getUsersDebates(-1).size(), 0);
	}
	
	@Test
	void testUpdateDebateStatus() {
		//test
		debateDAO.updateDebateStatus(null, 0);
	}

}
