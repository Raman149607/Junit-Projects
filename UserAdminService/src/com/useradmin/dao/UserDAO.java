package com.useradmin.dao;

import com.useradmin.dto.User;
import com.useradmin.util.IDGenerator;

public class UserDAO {

	private User user;

	public UserDAO(User user) {
		this.user = user;
	}

	private User privateMethod() {

		return user;

	}

	public String finalMethod2(User user) {
		String str = user.finalMethod();
		// Save the user object to the db
		return str;

	}

	public int create(User user) {
		int id = IDGenerator.generateID();
		// Save the user object to the db
		return id;

	}

	public String usesVoidMethod(String name) {

		try {
			user.setName(name);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
		return name;

	}
	
	private static boolean isCountry(String countryCode) {
        return false;
    }
	
	public int fetchMyCountryCode(String countryCode) {
        if (isCountry(user.getCountryCode())) {
            return 5;
        }
        return 10;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
