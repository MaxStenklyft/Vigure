package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.hibernate.query.Query;
import com.cs506.vigure.db.dao.LoginDAO;
import com.cs506.vigure.db.dao.LoginDAOImpl;
import com.cs506.vigure.db.entity.LoginEntity;

class LoginDAOImplTest {
	
	private LoginDAO loginDAO = new LoginDAOImpl();
	private SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
	private Session mockedSession = Mockito.mock(Session.class);
	private Query<LoginEntity> mockedQuery = Mockito.mock(Query.class);
	private List<LoginEntity> mockedList = Mockito.mock(List.class);
	
	@Test
	void testRegister() {
		loginDAO.setSessionFactory(this.mockedSessionFactory);
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.createQuery("from LoginEntity where userName='ThisIsNotATest'", LoginEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedSession.createQuery("from LoginEntity where userName='UniqueUserName'", LoginEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
	    
		//test valid username
		assertEquals(loginDAO.register("ThisIsNotATest@wisc.edu", "ThisIsNotATest", "ThisIsNotATest"), true); 
		
		//test unique username, but non-@wisc.edu email address
		assertEquals(loginDAO.register("ThisIsNotATest@notWisc.edu", "UniqueUserName", "ThisIsNotATest"), false);
		
		//test short password
		assertEquals(loginDAO.register("ThisIsNotATest@wisc.edu", "UniqueUserName", "No"), false);
		
		//test long password
		assertEquals(loginDAO.register("ThisIsNotATest@wisc.edu", "UniqueUserName", "Noooooooooooooooooooo"), false);
	}
	
	
	
	@Test
	void testValidateUser() {
		loginDAO.setSessionFactory(this.mockedSessionFactory);
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.createQuery("from LoginEntity where userName='ThisIsNotATest' and password='ThisIsNotATest'", LoginEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
		
		//testing return value
		assertEquals(loginDAO.validateUser("ThisIsNotATest", "ThisIsNotATest"), false);
	}
	
	
	@Test
	void testGetUsernameID() {
		loginDAO.setSessionFactory(this.mockedSessionFactory);
	    Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.createQuery("from LoginEntity where userName='ThisIsNotATest'", LoginEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
		
		//test invalid userName
		assertEquals(loginDAO.getUsernameID("ThisIsNotATest"), -1);
	}
	
}
