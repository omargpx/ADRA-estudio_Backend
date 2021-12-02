package com.adrastudio.adrastudio.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrastudio.adrastudio.entity.BancoComunal;

@Repository
public interface BancoComunalRepo extends CrudRepository<BancoComunal, Integer>{
	
	@Query("SELECT e FROM tbl_banco_comunal e WHERE (NO_BANCO_COMUNAL like %:query% or ID_DISTRITO  like %:query%)")
    List<BancoComunal> findAll(String query, Sort sort);

    @Query("SELECT e FROM tbl_banco_comunal e WHERE (NO_BANCO_COMUNAL like %:query% or ID_DISTRITO  like %:query%)")
    Page<BancoComunal> findAllParams(String query, Pageable pageable);

}
