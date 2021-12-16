/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import pe.org.adra_estudio.ADRA.entity.TipoRecurso;
import pe.org.adra_estudio.ADRA.repository.TipoRecursoRepo;
import pe.org.adra_estudio.ADRA.service.TipoRecursoService;


@Service
public class TipoRecursoServiceImp implements TipoRecursoService{
    @Autowired
    private TipoRecursoRepo repo;
    
    @Transactional(readOnly = true)
    @Override
    public List<TipoRecurso> findAll() {
        return (List<TipoRecurso>) repo.findAll();
    }

    @Override
    public TipoRecurso findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public TipoRecurso save(TipoRecurso tipo) {
        return repo.save(tipo);
    }

    @Override
    public void delete(TipoRecurso tipo) {
        repo.delete(tipo);
    }

    @Override
    public List<TipoRecurso> findAll(String query, String sortBy) {
       Sort sort;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();
            sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
        } else {
            sort = Sort.by(Sort.Direction.ASC, "ID_TI_RECURSO");
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
            Sort sort = Sort.by(Sort.Direction.ASC, "ID_TI_RECURSO");
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        Page<TipoRecurso> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);

        if (!data.getContent().isEmpty()) {
            result.put("items", data.getContent());
        } else {
            result.put("items", new ArrayList<TipoRecurso>());
        }
        result.put("totalPage", data.getTotalPages());
        result.put("totalRows", data.getNumberOfElements());
        result.put("page", page);
        result.put("limit", limit);
        return result;
    }
}
