package com.esercizio.florencecg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esercizio.florencecg.DTO.PartialUserDTO;
import com.esercizio.florencecg.DTO.UserDTO;
import com.esercizio.florencecg.entity.User;
import com.esercizio.florencecg.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	/*
	 * Nota: Presentando l'entità User dei contenuti sensibili (password), sono stati realizzati due API diverse
	 * per ottenere la lista di utenti presenti nel db. Per evitare di ottenere in risposta anche il campo relativo alla 
	 * password mi sono avvalso di un DTO appositamente preparato.
	 */
	
	@GetMapping("/api/user/all")
	public List<User> getAllUsers(){
		 return service.getAllUsers();
		
	}
	
	@GetMapping("/api/admin/user/all")
	public List<UserDTO> getAllUsersWithPassword(){
		List<User> users = service.getAllUsers();
		List<UserDTO> usersDTO = new ArrayList<>();
		for (User user : users) {
	        UserDTO userDTO = new UserDTO(user.getId(), user.getNome(), user.getCognome(),user.getIndirizzo(), user.getEmail());
	        usersDTO.add(userDTO);
	    }
		return usersDTO;
	}
	
	/*
	 * Nota: le API che permettono di effetturare operazioni diverse dal semplice get di dati sono state dotate di una sigla /admin/,
	 * immaginando uno scenario in cui sia richiesto di gestire anche la sicurezza.
	 */
		 
	
	@PostMapping("/api/admin/user/save")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PutMapping("/api/admin/user/update/id={id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		return service.updateUser(id, user);
	}
	
	@DeleteMapping("/api/admin/user/delete/id={id}")
	public void deleteUser(@PathVariable Integer id) {
		service.deleteUserById(id);
	}
	
	@GetMapping("/api/user/id={id}")
	public UserDTO getUserById(@PathVariable Integer id) {
		User user = service.getUserById(id);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setCognome(user.getCognome());
		userDTO.setEmail(user.getEmail());
		userDTO.setIndirizzo(user.getIndirizzo());
		return userDTO;
	}
	
	@GetMapping("/api/user/cognome={cognome}")
	public UserDTO trovaUtenteByCognome(@PathVariable String cognome) {
		User user = service.findUserCognome(cognome);
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setCognome(user.getCognome());
		userDTO.setEmail(user.getEmail());
		userDTO.setIndirizzo(user.getIndirizzo());
		return userDTO;
	}
	
	/*
	 * Nota: per la realizzazione del metodo partialUpdateUser è stato creato un secondo DTO, che presenta come
	 * unico campo quello passibile di modifica, ovvero l'indirizzo.
	 */
	
	@PatchMapping("/api/admin/user/partial/update/id={id}")
	public UserDTO partialUpdateUser(@PathVariable Integer id, @RequestBody PartialUserDTO partialDTO) {
		User user = service.getUserById(id);
		UserDTO userDTO = new UserDTO();
		if (!(user == null)) {
			user.setIndirizzo(partialDTO.getIndirizzo());
			userDTO.setId(user.getId());
			userDTO.setNome(user.getNome());
			userDTO.setCognome(user.getCognome());
			userDTO.setEmail(user.getEmail());
			userDTO.setIndirizzo(user.getIndirizzo());
			service.saveUser(user);
		}
		return userDTO;
	}

}
