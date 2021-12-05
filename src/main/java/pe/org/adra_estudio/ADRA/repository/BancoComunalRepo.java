package pe.org.adra_estudio.ADRA.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.org.adra_estudio.ADRA.entity.BancoComunal;

@Repository
public interface BancoComunalRepo extends CrudRepository<BancoComunal, Integer> {

    @Query("SELECT c FROM BancoComunal c WHERE (NO_BANCO_COMUNAL like %:query% or id_banco_comunal like %:query%)")
    List<BancoComunal> findAll(String query, Sort sort);

    @Query("SELECT c FROM BancoComunal c WHERE (NO_BANCO_COMUNAL like %:query% or id_banco_comunal like %:query%)")
    Page<BancoComunal> findAllParams(String query, Pageable pageable);

}
