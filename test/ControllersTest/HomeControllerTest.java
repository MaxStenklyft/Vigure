package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.cs506.vigure.Controllers.HomeController;

class HomeControllerTest {

	@Test
	void testLoadLoginPage() {
		// getting instance of a HomeController
		HomeController homeControllerInstance = new HomeController();

		// getting return string from loadLoginPage method
		String redirect = homeControllerInstance.loadLoginPage();
				
		assertEquals(redirect, "home");
	}

}
