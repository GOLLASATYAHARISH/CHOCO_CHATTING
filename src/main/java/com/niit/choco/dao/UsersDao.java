package com.niit.choco.dao;

import java.util.List;

import com.niit.choco.model.Users;

public interface UsersDao {

	void registerUser(Users user);
	void updateUsers(Users users);
	
	List<Users> listUsers();

	public List<Users> findFriends(String name);
	
	int validateUser(String name, String password);
	void logout(String name);	
}
