package com.nexos.inventory.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.inventory.entity.MercanciaEntity;

/**
 * Interface IMercanciaRepository
 *
 * Interface de repositorio para la entidad Mercancia.
 * 
 * @author JhonT
 * @version %I%, %G%
 * 
 * */
@Repository
public interface IMercanciaRepository extends CrudRepository<MercanciaEntity, String>, JpaSpecificationExecutor<MercanciaEntity> {
	
}
