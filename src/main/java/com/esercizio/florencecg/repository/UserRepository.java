package com.esercizio.florencecg.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esercizio.florencecg.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	/*
	 * Nota: per la realizzazione del metodo che ricerca un User in base al cognome è stata realizzata
	 * una query parametrica basata sul linguaggio SQL.
	 */
	
	@Query(value = "SELECT u.* FROM user u WHERE u.cognome = :cognome", nativeQuery = true)
	  User findUserCognome(@Param("cognome") String cognome);
	


}

