package com.adrastudio.adrastudio.implementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adrastudio.adrastudio.entity.Persona;
import com.adrastudio.adrastudio.repository.PersonaRepo;
import com.adrastudio.adrastudio.service.PersonaService;

@Service
public class PersonaServiceImp implements PersonaService{

	@Autowired
	private PersonaRepo repo;
	
	@Transactional
	@Override
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona>) repo.findAll();
	}

	@Override
	public Persona findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return repo.save(persona);
	}

	@Override
	public void delete(Persona persona) {
		// TODO Auto-generated method stub
		repo.delete(persona);
	}

	@Override
	public List<Persona> findAll(String query, String sortBy) {
		Sort sort;
		if (!sortBy.equals("")) {
			String sortColumn = sortBy.split("\\|")[0];
			String sortDirection = sortBy.split("\\|")[1].toUpperCase();
			sort = Sort.by(sortDirection.equals("DESC") ? Direction.DESC : Direction.ASC, sortColumn);
		} else {
			sort = Sort.by(Direction.ASC, "ID_PERSONA");
		}
		return repo.findAll("%" + query.toUpperCase() + "%", sort);
	}

	@Override
	public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy) {
		HashMap<String, Object> result = new HashMap<>();
		Pageable pageable;

		if (!sortBy.equals("")) {
			String sortColumn = sortBy.split("\\|")[0];
			String sortDirection = sortBy.split("\\|")[1].toUpperCase();

			Sort sort = Sort.by(sortDirection.equals("DESC") ? Direction.DESC : Direction.ASC, sortColumn);
			pageable = PageRequest.of(page - 1, limit, sort);
		} else {
			Sort sort = Sort.by(Direction.ASC, "ID_PERSONA");
			pageable = PageRequest.of(page - 1, limit, sort);
		}
		Page<Persona> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);
		if (!data.getContent().isEmpty()) {
			result.put("items", data.getContent());
		} else {
			result.put("items", new ArrayList<Persona>());
		}
		result.put("totalPage", data.getTotalPages());
		result.put("totalRows", data.getNumberOfElements());
		result.put("page", page);
		result.put("limit", limit);
		return result;
	}

}
