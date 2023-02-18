package com.esercizio.florencecg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//mapping dell'entità per generare la tabella sul DB

@Entity
@Table(name = "User")
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 55, nullable = false)
	private String nome;
	
	@Column(name = "cognome", length = 55, nullable = false)
	private String cognome;
	
	@Column(name = "email", length = 55, nullable = false)
	private String email;
	
	@Column(name = "indirizzo", length = 155, nullable = false)
	private String indirizzo;
	
	@Column(name = "password", length = 55, nullable = false)
	private String password;


	//costruttore di default
	public User() {
		
	}

	//getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
