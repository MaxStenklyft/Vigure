package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cs506.vigure.Controllers.AccountSettingsController;
import com.cs506.vigure.Controllers.HomeController;

class AccountSettingsControllerTest {

	@Test
	void testLoadUserSettings() {
		// getting instance of a HomeController
		AccountSettingsController accSettControllerInstance = new AccountSettingsController();

		// getting return string from loadLoginPage method
		String redirect = accSettControllerInstance.loadUserSettingsPage();
				
		assertEquals(redirect, "settings");	
	}
	
	@Test
	void testChangeUserSettings() {
		fail("Not yet implemented");
	}

}
