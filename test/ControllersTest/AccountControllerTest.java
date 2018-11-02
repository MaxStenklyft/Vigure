package ControllersTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cs506.vigure.Controllers.AccountController;


class AccountControllerTest {
		
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	void testLoadLoginPage() {
		// getting instance of an AccountController
		AccountController accountControllerInstance = new AccountController();

		// getting return string from loadLoginPage method
		String redirect = accountControllerInstance.loadLoginPage();
		
		assertEquals(redirect, "loginSignUp");
	}

	@Test
	void testLogin() throws Exception {		
		// getting instance of an AccountController
		//AccountController accountControllerInstance = new AccountController();
		//HttpSession session = new MockHttpSession(null, "test-session-id");
		//mockMvc = MockMvcBuilders
        //        .standaloneSetup(accountControllerInstance)
        //        .build();
		
		//mockMvc.perform(post("/login").param("username", "tstUsr97")
		//        .param("password", "testpass"));
				//.andExpect(status().isOk())/*.andExpect(view().name("testLoginSucc"))*/;
		
		fail("not yet implemented");
	}
	
	@Test
	void testLogout() {
		// mocking http session, giving it test username
		HttpSession session = new MockHttpSession(null, "test-session-id");
		session.setAttribute("username", "tstUsr97");
		
		// getting instance of an AccountController
		AccountController accountControllerInstance = new AccountController();
		
		// getting return string from logout method
		String redirect = accountControllerInstance.logout(session);
		
		// getting username attribute from session
		Object attribute = session.getAttribute("username");
		
		// asserting that logout method redirected page and removed usernamej
		// attribute from httpsession
		assertEquals("redirect:../", redirect);
		assertEquals(null, attribute);
	}

}
