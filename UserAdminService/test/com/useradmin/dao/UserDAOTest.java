package com.useradmin.dao;

import static org.junit.Assert.*;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import com.useradmin.dto.User;
import com.useradmin.util.IDGenerator;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ IDGenerator.class, User.class })

public class UserDAOTest {

	@Mock
	User user;

	@InjectMocks
	UserDAO dao;

	private UserDAO userDAO;
	


	@Test
	public void staticMethod_WithPowerMock() {

		mockStatic(IDGenerator.class);
		when(IDGenerator.generateID()).thenReturn(1);
		int result = dao.create(user);
		assertEquals(1, result);

	}

	@Test
	public void TestFinalMethodUser_WithPowerMock() throws Exception {

		User mock = PowerMockito.mock(User.class);

		userDAO = new UserDAO(mock);

		PowerMockito.when(mock.finalMethod()).thenReturn("JUnit");

		String message2 = userDAO.finalMethod2(mock);
		Mockito.verify(mock).finalMethod();
		assertEquals("JUnit", message2);
	}

	@Test
	public void privateMethodShouldBeMocked() throws Exception {

		UserDAO spy = PowerMockito.spy(dao);
		when(user.getName()).thenReturn("Test");
		User invokeMethod = (User) WhiteboxImpl.invokeMethod(spy, "privateMethod");
		assertEquals("Test", invokeMethod.getName());
	}

//	
//	 @Test
//	 public void testCountryCode() throws Exception {
//	 PowerMockito.spy(UserDAO.class);
//	 PowerMockito.doReturn(true).when(UserDAO.class, "isCountry",startsWith("IN")); 
//	 assertThat(dao.fetchMyCountryCode("IN"), equalTo(5)); 
//	 
//	 }
	 

	@Test
	public void usesVoidMethodShouldCalltest() throws Exception {
		doNothing().when(user).setName("Raman");
		assertSame("Raman", dao.usesVoidMethod("Raman"));
		verify(user).setName("Raman");
	}

	@Test
	public void voidMethodShouldThrowException() throws Exception {
		doThrow(Exception.class).when(user).setName("Raman");
		assertThrows(RuntimeException.class, () -> {
			dao.usesVoidMethod("Raman");
		});

	}

	@Test
	public void testConnsecutiveCalls() throws Exception {
		doNothing().doThrow(Exception.class).when(user).setName("Raman");
		dao.usesVoidMethod("Raman");
		verify(user).setName("Raman");
		assertThrows(RuntimeException.class, () -> {
			dao.usesVoidMethod("Raman");
		});

	}
	

	
	

}
