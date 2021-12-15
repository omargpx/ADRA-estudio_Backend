package pe.org.adra_estudio.ADRA.service.implement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.adra_estudio.ADRA.entity.Persona;
import pe.org.adra_estudio.ADRA.repository.UsuarioRepo;
import pe.org.adra_estudio.ADRA.service.UsuarioService;
import pe.org.adra_estudio.ADRA.entity.Usuario;
/**
 *
 * @author lober
 */
@Service 
@RequiredArgsConstructor 
@Transactional 
@Slf4j 
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    private UsuarioRepo repo;

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(int email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repo.findAll();
    }

    @Override
    public List<Usuario> findAll(String query, String sortBy) {
        Sort sort;
        if (!sortBy.equals("")) {
            String sortColumn = sortBy.split("\\|")[0];
            String sortDirection = sortBy.split("\\|")[1].toUpperCase();
            sort = Sort.by(sortDirection.equals("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortColumn);
        } else {
            sort = Sort.by(Sort.Direction.ASC, "id_usuario");
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
            Sort sort = Sort.by(Sort.Direction.ASC, "id_usuario");
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        Page<Usuario> data = repo.findAllParams("%" + query.toUpperCase() + "%", pageable);

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

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        //log.info("guardando al usuario {} en la base de datos ",usuario.getEmail());
        return repo.save(usuario);
    }

    @Override
    public void addRoltoUsuario(int email, String Rolname) {
        //log.info("agregando Rol {} al usuario {} ");
        Usuario usuario = repo.findByEmail(email);
    }

    
    
}
