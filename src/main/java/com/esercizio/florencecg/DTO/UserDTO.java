package com.esercizio.florencecg.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Integer id;
	
	private String email;
	
	private String nome;
	
	private String cognome;
	
	private String indirizzo;

}