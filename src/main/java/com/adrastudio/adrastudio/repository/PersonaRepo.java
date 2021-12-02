package com.adrastudio.adrastudio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrastudio.adrastudio.entity.Persona;

@Repository
public interface PersonaRepo extends CrudRepository<Persona, Integer>{

	 @Query("SELECT e FROM tbl_persona e WHERE (no_persona like %:query% or ap_paterno  like %:query%)")
	    List<Persona> findAll(String query, Sort sort);

	 @Query("SELECT e FROM tbl_persona e WHERE (no_persona like %:query% or ap_paterno  like %:query%)")
	 Page<Persona> findAllParams(String query, Pageable pageable);
	
}
