package com.useradmin.dao;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.useradmin.dto.User;

public class JsonExample {

	//User user = new User();

	public String jsonString(User user2) {
		Map obj = new HashMap();
		obj.put("name", user2.getName());
		obj.put("id", user2.getId());
		String jsonText = JSONValue.toJSONString(obj);
		return jsonText;
	}

	public JSONObject jsonObject(User user1) {
		JSONObject obj = new JSONObject();
		obj.put("name", user1.getName());
		obj.put("id", user1.getId());
		   
		return obj;
	}
}