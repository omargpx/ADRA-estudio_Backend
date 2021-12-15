package pe.org.adra_estudio.ADRA.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.adra_estudio.ADRA.entity.Persona;

@Repository
public interface PersonaRepo extends CrudRepository<Persona, Integer> {

    @Query("SELECT c FROM Persona c WHERE (NU_DNI like %:query% or ID_PERSONA like %:query%)")
    List<Persona> findAll(String query, Sort sort);

    @Query("SELECT c FROM Persona c WHERE (NU_DNI like %:query% or ID_PERSONA like %:query%)")
    Page<Persona> findAllParams(String query, Pageable pageable);
    
    //buscar persona por el dni
    public Persona findByNUDNI(int dni);

}
