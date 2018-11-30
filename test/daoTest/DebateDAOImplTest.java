package daoTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.cs506.vigure.db.dao.DebateDAOImpl;
import com.cs506.vigure.db.dao.LoginDAOImpl;
import com.cs506.vigure.db.entity.DebateEntity;

public class DebateDAOImplTest {
	
	@Test
	void testSendDebateRequest() {
		//test 
		DebateDAOImpl debateDAOImplInstance = new DebateDAOImpl();
		debateDAOImplInstance.sendDebateRequest(new DebateEntity());
	}
	
	@Test
	void testGetUsersDebates() {
		//test on nonexistent user
		DebateDAOImpl debateDAOImplInstance = new DebateDAOImpl();
		assertEquals(debateDAOImplInstance.getUsersDebates(-1).size(), 0);
	}
	
	@Test
	void testUpdateDebateStatus() {
		//test
		DebateDAOImpl debateDAOImplInstance = new DebateDAOImpl();
		debateDAOImplInstance.updateDebateStatus(null, 0);
	}

}
