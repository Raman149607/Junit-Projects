package com.bharath.useradmin.dao;

import com.bharath.useradmin.dto.User;
import com.bharath.useradmin.util.IDGenerator;

public class UserDAO {
	
	private User user;
	
	public int create(User user){
		int id = IDGenerator.generateID();
		//Save the user object to the db
		return id;
		
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
