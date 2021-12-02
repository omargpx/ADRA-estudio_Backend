package com.adrastudio.adrastudio.service;

import java.util.HashMap;
import java.util.List;

import com.adrastudio.adrastudio.entity.Persona;

public interface PersonaService {
	
	public List<Persona> findAll();

    public Persona findById(int id);

    public Persona save(Persona persona);

    public void delete(Persona persona);

    public List<Persona> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);

}
