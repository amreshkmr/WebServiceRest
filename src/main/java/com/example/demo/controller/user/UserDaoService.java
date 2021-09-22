package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usercount = 3;

	static {

		users.add(new User(1, "Amresh", new Date()));
		users.add(new User(2, "Amru", new Date()));
		users.add(new User(3, "kumar", new Date()));

	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usercount);
		}
		users.add(user);
		return user;

	}
	
	public User findOne(int id) {
		
		for(User u:users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}

}
