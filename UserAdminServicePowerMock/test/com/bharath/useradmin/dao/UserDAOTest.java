package com.bharath.useradmin.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bharath.useradmin.dto.User;
import com.bharath.useradmin.util.IDGenerator;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {
	
	@Mock
	User user;
	
	@InjectMocks
	UserDAO dao;

	@Test
	public void createSHouldReturnUserIDBack() {
		
		mockStatic(IDGenerator.class);
		when(IDGenerator.generateID()).thenReturn(1);
		int result = dao.create(user);
		assertEquals(1, result);
		
		
		
	}

}
