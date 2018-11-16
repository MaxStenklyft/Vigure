package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cs506.vigure.Controllers.DebateRoomController;

class DebateRoomControllerTest {

	@Test
	void testLoadDebatePage() {
		DebateRoomController dbRoom = new DebateRoomController();
		assertEquals("debateRoom", dbRoom.loadDebatePage());
	}

}
