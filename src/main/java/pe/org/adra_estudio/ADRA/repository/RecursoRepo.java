
package pe.org.adra_estudio.ADRA.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.adra_estudio.ADRA.entity.Recurso;


@Repository
public interface RecursoRepo  extends CrudRepository<Recurso,Integer>{

    @Query("SELECT c FROM Recurso c WHERE (id_recurso like %:query% or nombre_recurso like %:query%)")
    List<Recurso> findAll(String query, Sort sort);

    @Query("SELECT c FROM Recurso c WHERE (id_recurso like %:query% or nombre_recurso like %:query%)")
    Page<Recurso> findAllParams(String query, Pageable pageable);

}
