package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cs506.vigure.Controllers.DebateRoomController;

class DebateRoomControllerTest {
	
	@Test
	void testLoadDebatePage() {
		DebateRoomController debRoomContrInstance = new DebateRoomController();
		
		// getting return string from loadLoginPage method
		String redirect = debRoomContrInstance.loadDebatePage();
		
		assertEquals(redirect, "debateRoom");
	}
	
}
