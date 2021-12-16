/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.service;

import java.util.HashMap;
import java.util.List;
import pe.org.adra_estudio.ADRA.entity.RolUsuario;

/**
 *
 * @author lober
 */
public interface RolUsuarioService {

    public List<RolUsuario> findAll(String query, String sortBy);

    public HashMap<String, Object> findAll(String query, int page, int limit, String sortBy);

    public List<RolUsuario> findAll();

    public RolUsuario findById(int id_rol_usuario);

    public RolUsuario save(RolUsuario banco);
}
