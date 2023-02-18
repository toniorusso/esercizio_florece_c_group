package com.esercizio.florencecg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio.florencecg.entity.User;
import com.esercizio.florencecg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUsers() {
		Iterable<User> listOfUsers = repository.findAll();
		List<User> users = (List<User>) listOfUsers;
		return users;
	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> optUser = repository.findById(id);
		User user = new User();
		if (!optUser.isEmpty()) {
		  user = optUser.get();
		}
		return user;
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public User updateUser(Integer id, User user) {
		Optional<User> optUser = repository.findById(id);
		User us = new User();
		if (!optUser.isEmpty()) {
			us = optUser.get();
			us.setNome(user.getNome());
			us.setCognome(user.getCognome());
			us.setEmail(user.getEmail());
			us.setIndirizzo(user.getIndirizzo());
			us.setPassword(user.getPassword());
			repository.save(us);
		}
		return us;
	}

	@Override
	public void deleteUserById(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public User findUserCognome(String cognome) {
		return repository.findUserCognome(cognome);
	}



}
