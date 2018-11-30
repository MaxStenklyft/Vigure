package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cs506.vigure.db.dao.UserDAOImpl;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

public class UserDAOImplTest {
	UserDAOImpl userDAO = new UserDAOImpl();
	private SessionFactory mockedSessionFactory = Mockito.mock(SessionFactory.class);
	private Session mockedSession = Mockito.mock(Session.class);
	private Query<UserEntity> mockedQuery = Mockito.mock(Query.class);
	private List<UserEntity> mockedList = Mockito.mock(List.class);

	@Test
	void testAddRegisteredUser() {
		userDAO.setSessionFactory(this.mockedSessionFactory);
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		
		//test valid add
		userDAO.addRegisteredUser(1, "ThisIsNotATest", "ThisIsNotATest", null);
	}
	
	@Test 
	void testSearchForEntityByUserName() {
		userDAO.setSessionFactory(this.mockedSessionFactory);
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("from UserEntity where username='ThisIsNotATest'", UserEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
		
		//test search for nonexistent user
		assertEquals(userDAO.searchForEntityByUserName("ThisIsNotATest"), null);
	}
	
	@Test
	void testSearchForEntityByID(){
		userDAO.setSessionFactory(this.mockedSessionFactory);
		Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
		Mockito.when(mockedSession.createQuery("from UserEntity where ID='-1'", UserEntity.class)).thenReturn(mockedQuery);
	    Mockito.when(mockedQuery.getResultList()).thenReturn(mockedList);
		
		//test search for nonexistent user
		assertEquals(userDAO.searchForEntityById(-1), null);
	}
	
}
