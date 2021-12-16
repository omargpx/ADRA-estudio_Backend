/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.adra_estudio.ADRA.entity.RolUsuario;
import pe.org.adra_estudio.ADRA.repository.RolUsuarioRepo;
import pe.org.adra_estudio.ADRA.service.RolUsuarioService;

/**
 *
 * @author lober
 */
@Service 
@RequiredArgsConstructor 
@Transactional 
@Slf4j 
public class RolUsuarioImp implements RolUsuarioService{

    @Autowired
    private RolUsuarioRepo repo;
    
    @Override
    public List<RolUsuario> findAll(String query, String sortBy) {
        Sort sort;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();
            sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
        } else {
            sort = Sort.by(Sort.Direction.ASC, "id_rol_usuario");
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
            Sort sort = Sort.by(Sort.Direction.ASC, "id_rol_usuario");
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        Page<RolUsuario> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);

        if (!data.getContent().isEmpty()) {
            result.put("items", data.getContent());
        } else {
            result.put("items", new ArrayList<RolUsuario>());
        }
        result.put("totalPage", data.getTotalPages());
        result.put("totalRows", data.getNumberOfElements());
        result.put("page", page);
        result.put("limit", limit);
        return result;
    }

    @Override
    public List<RolUsuario> findAll() {
        return (List<RolUsuario>) repo.findAll();
    }

    @Override
    public RolUsuario findById(int id_rol_usuario) {
       return repo.findById(id_rol_usuario).orElse(null);
    }

    @Override
    public RolUsuario save(RolUsuario rolUsu) {
        return repo.save(rolUsu);
    }
    
}
