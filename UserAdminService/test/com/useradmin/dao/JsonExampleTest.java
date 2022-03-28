package com.useradmin.dao;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.useradmin.dto.User;


public class JsonExampleTest {
	
	@Mock(answer = Answers.CALLS_REAL_METHODS)
	JsonExample jsonExample;
	
	@Mock
	User user;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void jsonValueTest() {
		
		when(user.getName()).thenReturn("sonoo");
		when(user.getId()).thenReturn(27);
	    //when(jsonExample.jsonString()).thenReturn("{name:\"sonoo\",id:27}");
		JSONAssert.assertEquals("{name:\"sonoo\",id:27}", jsonExample.jsonString(user), JSONCompareMode.LENIENT);
		
	}
	
	@Test
	public void jsonObjectTest() {
		//JSONObject jsonObject = jsonExample.jsonObject();
		//String jsonString = JSONValue.toJSONString(jsonObject);
		when(user.getName()).thenReturn("sonoo");
		when(user.getId()).thenReturn(27);
	    //when(jsonExample.jsonObject(user)).thenReturn(jsonObject);
	    JSONAssert.assertEquals("{name:\"sonoo\",id:27}", jsonExample.jsonObject(user).toJSONString(), JSONCompareMode.LENIENT);
	   // Mockito.verify(jsonObject).;
		
	
		
	}

}
