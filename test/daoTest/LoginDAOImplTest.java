package daoTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.cs506.vigure.db.dao.LoginDAOImpl;

class LoginDAOImplTest {

	@Test
	void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateUser() {
		//getting instance of LoginDAOImpl
		LoginDAOImpl loginDAOImplInstance = new LoginDAOImpl();
		
		//testing return value
		assertEquals(loginDAOImplInstance.validateUser("tstUsr97", "testpass"), true );
	}

}
