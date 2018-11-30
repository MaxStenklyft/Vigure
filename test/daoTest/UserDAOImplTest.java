package daoTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.cs506.vigure.db.dao.UserDAOImpl;

public class UserDAOImplTest {

	@Test
	void testAddRegisteredUser() {
		//test valid add
		UserDAOImpl userDAOImplInstance = new UserDAOImpl();
		userDAOImplInstance.addRegisteredUser(1, "ThisIsNotATest", "ThisIsNotATest", null);
	}
	
	@Test 
	void testSearchForEntityByUserName() {
		//test search for nonexistent user
		UserDAOImpl userDAOImplInstance = new UserDAOImpl();
		assertEquals(userDAOImplInstance.searchForEntityByUserName("ThisIsNotATest"), null);
	}
	
	@Test
	void testSearchForEntityByID(){
		//test search for nonexistent user
		UserDAOImpl userDAOImplInstance = new UserDAOImpl();
		assertEquals(userDAOImplInstance.searchForEntityById(-1), null);
	}
	
}
