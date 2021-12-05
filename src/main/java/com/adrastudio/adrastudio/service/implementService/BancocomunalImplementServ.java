package com.adrastudio.adrastudio.service.implementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.adrastudio.adrastudio.entity.BancoComunal;
import com.adrastudio.adrastudio.repository.BancoComunalRepo;
import com.adrastudio.adrastudio.service.BancoComunalService;

@Service
public class BancocomunalImplementServ implements BancoComunalService{
	
	@Autowired
	private BancoComunalRepo repo;

	@Override
	public List<BancoComunal> findAll() {
		
		return (List<BancoComunal>) repo.findAll();
	}

	@Override
	public BancoComunal findById(int id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public BancoComunal save(BancoComunal banco) {
		
		return repo.save(banco);
	}

	@Override
	public void delete(BancoComunal banco) {
		
		repo.delete(banco);
	}

	@Override
	public List<BancoComunal> findAll(String query, String sortBy) {
		Sort sb;
		if (!sortBy.equals("")) {
			String sortColumn = sortBy.split("\\|")[0];
			String sortDirection = sortBy.split("\\|")[1].toUpperCase();
			sb = Sort.by(sortDirection.equals("DESC") ? Direction.DESC : Direction.ASC, sortColumn);
		} else {
			sb = Sort.by(Direction.ASC, "ID_BANCO_COMUNAL");
		}
		return repo.findAll("%" + query.toUpperCase() + "%", sb);
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
			Sort sort = Sort.by(Direction.ASC, "ID_BANCO_COMUNAL");
			pageable = PageRequest.of(page - 1, limit, sort);
		}

		Page<BancoComunal> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);

		if (!data.getContent().isEmpty()) {
			result.put("items", data.getContent());
		} else {
			result.put("items", new ArrayList<BancoComunal>());
		}
		result.put("totalPage", data.getTotalPages());
		result.put("totalRows", data.getNumberOfElements());
		result.put("page", page);
		result.put("limit", limit);
		return result;
	}

}
