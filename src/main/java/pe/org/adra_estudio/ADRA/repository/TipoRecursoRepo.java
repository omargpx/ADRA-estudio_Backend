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
import pe.org.adra_estudio.ADRA.entity.TipoRecurso;


@Repository
public interface TipoRecursoRepo extends CrudRepository<TipoRecurso,Integer>{
     @Query("SELECT c FROM TipoRecurso c WHERE (id_tipo_recurso like %:query% or nombre_tipo_recurso like %:query%)")
    List<TipoRecurso> findAll(String query, Sort sort);

    @Query("SELECT c FROM TipoRecurso c WHERE (id_tipo_recurso like %:query% or nombre_tipo_recurso like %:query%)")
    Page<TipoRecurso> findAllParams(String query, Pageable pageable);
}
