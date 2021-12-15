/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.adra_estudio.ADRA.entity.Capacitacion;
import pe.org.adra_estudio.ADRA.repository.CapacitacionRepo;
import pe.org.adra_estudio.ADRA.service.CapacitacionService;

/**
 *
 * @author lober
 */
@Service
public class CapaciacionServiceImp implements CapacitacionService{

    @Autowired
    private CapacitacionRepo repo;
    
    @Transactional(readOnly = true)
    @Override
    public List<Capacitacion> findAll() {
        return (List<Capacitacion>) repo.findAll();
    }

    @Override
    public Capacitacion findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Capacitacion save(Capacitacion capacitacion) {
        return repo.save(capacitacion);
    }

    @Override
    public void delete(Capacitacion capacitacion) {
        repo.delete(capacitacion);
    }

    @Override
    public List<Capacitacion> findAll(String query, String sortBy) {
       Sort sort;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();
            sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
        } else {
            sort = Sort.by(Sort.Direction.ASC, "id_capacitacion");
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

            Sort sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
            pageable = PageRequest.of(page - 1, limit, sort);
        } else {
            Sort sort = Sort.by(Sort.Direction.ASC, "id_capacitacion");
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        Page<Capacitacion> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);

        if (!data.getContent().isEmpty()) {
            result.put("items", data.getContent());
        } else {
            result.put("items", new ArrayList<Capacitacion>());
        }
        result.put("totalPage", data.getTotalPages());
        result.put("totalRows", data.getNumberOfElements());
        result.put("page", page);
        result.put("limit", limit);
        return result;
    }
    
}
