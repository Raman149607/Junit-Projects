package com.useradmin.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.useradmin.dto.FinalClassTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalClassTest.class)
public class FinalMethodTest {

	@Test
	public void TestFinalMethod_WithPowerMock() throws Exception {

		String message = " PowerMock with Mockito and JUnit ";
		FinalClassTest uti2 = PowerMockito.mock(FinalClassTest.class);
//		PowerMockito.whenNew(FinalClassTest.class).withNoArguments().thenReturn(uti);

	//	FinalClassTest uti2 = new FinalClassTest();
		//PowerMockito.verifyNew(FinalClassTest.class).withNoArguments();

		PowerMockito.when(uti2.finalMethod(message)).thenReturn(message);

		String message2 = uti2.finalMethod(message);
		Mockito.verify(uti2).finalMethod(message);
		//assertEquals(message, message2);
	}
}