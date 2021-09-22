package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * The Class UserDaoService.
 */
@Component
public class UserDaoService {

	/** The users. */
	private static List<User> users = new ArrayList<>();

	/** The usercount. */
	private static int userCount = 3;

	static {

		users.add(new User(1, "Amresh", new Date()));
		users.add(new User(2, "Amru", new Date()));
		users.add(new User(3, "kumar", new Date()));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<User> findAll() {
		return users;
	}

	/**
	 * Save.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;

	}
	
	/**
	 * Find one.
	 *
	 * @param id the id
	 * @return the user
	 */
	public User findOne(int id) {
		
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

}
