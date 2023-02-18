package com.esercizio.florencecg.service;

import java.util.List;

import com.esercizio.florencecg.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUserById(Integer id);
	User saveUser(User user);
	User updateUser(Integer id, User user);
	void deleteUserById(Integer id);
	User findUserCognome(String cognome);

}
