package pe.org.adra_estudio.ADRA.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.org.adra_estudio.ADRA.repository.UsuarioRepo;
import pe.org.adra_estudio.ADRA.service.UsuarioService;
import pe.org.adra_estudio.ADRA.entity.Usuario;
/**
 *
 * @author lober
 */
@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    private UsuarioRepo repo;

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(int email) {
        return repo.findByEmail(email);
    }

    
    
}
