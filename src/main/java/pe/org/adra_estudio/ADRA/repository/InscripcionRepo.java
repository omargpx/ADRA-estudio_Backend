/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.org.adra_estudio.ADRA.repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.adra_estudio.ADRA.entity.Inscripcion;

@Repository
public interface InscripcionRepo extends CrudRepository<Inscripcion,Integer>{
    
    @Query("SELECT c FROM Inscripcion c WHERE (id_iscripcion like %:query% or valoracion like %:query%)")
    List<Inscripcion> findAll(String query, Sort sort);

    @Query("SELECT c FROM Inscripcion c WHERE (id_inscripcion like %:query% or valoracion like %:query%)")
    Page<Inscripcion> findAllParams(String query, Pageable pageable);

}
