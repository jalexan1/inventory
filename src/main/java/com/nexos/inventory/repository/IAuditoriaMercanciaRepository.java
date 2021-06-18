package com.nexos.inventory.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.inventory.entity.AuditoriaMercanciaEntity;

/**
 * Interface IAuditoriaMercanciaRepository
 *
 * Interface de repositorio para la entidad de AuditoriaMercancia
 * 
 * @author JhonT
 * @version %I%, %G%
 * 
 * */
@Repository
public interface IAuditoriaMercanciaRepository extends CrudRepository<AuditoriaMercanciaEntity, Integer>, JpaSpecificationExecutor<AuditoriaMercanciaEntity> {
	
}
