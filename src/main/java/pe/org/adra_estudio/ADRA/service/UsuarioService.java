/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.Rol;
import pe.org.adra_estudio.ADRA.entity.Usuario;

/**
 *
 * @author lober
 */
public interface UsuarioService {

    public List<Usuario> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);

    public List<Usuario> findAll();

    // buscar por email
    public Usuario findByEmail(int email);
    
    //crud 
    public Usuario saveUsuario(Usuario usuario);
    //public Rol saveRol(Rol rol);
    public void addRoltoUsuario(int email,String Rolname);

}
