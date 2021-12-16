/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.org.adra_estudio.ADRA.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.adra_estudio.ADRA.entity.RolUsuario;

/**
 *
 * @author lober
 */
@Repository
public interface RolUsuarioRepo extends CrudRepository<RolUsuario, Integer>{
    
    @Query("SELECT c FROM RolUsuario c WHERE (id_usuario like %:query% or id_rol_usuario like %:query%)")
    List<RolUsuario> findAll(String query, Sort sort);

    @Query("SELECT c FROM RolUsuario c WHERE (id_usuario like %:query% or id_rol_usuario like %:query%)")
    Page<RolUsuario> findAllParams(String query, Pageable pageable);
    
}
