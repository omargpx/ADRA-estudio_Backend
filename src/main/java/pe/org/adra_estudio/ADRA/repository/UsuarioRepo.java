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
import pe.org.adra_estudio.ADRA.entity.Usuario;
/**
 *
 * @author lober
 */
@Repository
public interface UsuarioRepo extends CrudRepository<Usuario, Integer>{
    @Query("SELECT c FROM Usuario c WHERE (id_usuario like %:query% or clave like %:query%)")
    List<Usuario> findAll(String query, Sort sort);

    @Query("SELECT c FROM Usuario c WHERE (id_usuario like %:query% or clave like %:query%)")
    Page<Usuario> findAllParams(String query, Pageable pageable);
    
}
