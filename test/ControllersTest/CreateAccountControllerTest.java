package ControllersTest;

import org.junit.jupiter.api.Test;
import com.cs506.vigure.Controllers.CreateAccountController;
import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountControllerTest {
	
	@Test
	void testLoadLoginPage() {
		CreateAccountController cac = new CreateAccountController();
		
		String result = cac.loadLoginPage();
		
		assertEquals("createAccount", result);
	}
	
}
