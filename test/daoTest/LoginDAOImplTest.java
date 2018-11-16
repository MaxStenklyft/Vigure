package daoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.cs506.vigure.db.dao.LoginDAOImpl;

class LoginDAOImplTest {
	
	@Test
	void testRegister() {
		//getting instance of LoginDAOImpl
		LoginDAOImpl loginDAOImplInstance = new LoginDAOImpl();
		
		//test valid username
		assertEquals(loginDAOImplInstance.register("ThisIsNotATest@wisc.edu", "ThisIsNotATest", "ThisIsNotATest"), true); 
		
		//test non-unique username
		assertEquals(loginDAOImplInstance.register("ThisIsNotATest@wisc.edu", "ThisIsNotATest", "ThisIsNotATest"), false);
		
		//test unique username, but non-@wisc.edu email address
		assertEquals(loginDAOImplInstance.register("ThisIsNotATest@notWisc.edu", "UniqueUserName", "ThisIsNotATest"), false);
		
		//test short password
		assertEquals(loginDAOImplInstance.register("ThisIsNotATest@wisc.edu", "UniqueUserName", "No"), false);
		
		//test long password
		assertEquals(loginDAOImplInstance.register("ThisIsNotATest@wisc.edu", "UniqueUserName", "Noooooooooooooooooooo"), false);
	}
	
	
	
	@Test
	void testValidateUser() {
		//getting instance of LoginDAOImpl
		LoginDAOImpl loginDAOImplInstance = new LoginDAOImpl();
		
		//testing return value
		assertEquals(loginDAOImplInstance.validateUser("ThisIsNotATest", "ThisIsNotATest"), false);
	}
	
	
	@Test
	void testGetUsernameID() {
		//getting instance of LoginDAOImpl
		LoginDAOImpl loginDAOImplInstance = new LoginDAOImpl();
		
		//test invalid userName
		assertEquals(loginDAOImplInstance.getUsernameID("ThisIsNotATest"), -1);
	}
	
}
