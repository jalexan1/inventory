package com.nexos.inventory.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.inventory.entity.ProductoEntity;

/**
 * Interface IProductoRepository
 *
 * Interface de repositorio para la entidad de Usuario.
 * 
 * @author JhonT
 * @version %I%, %G%
 * 
 * */
@Repository
public interface IProductoRepository extends CrudRepository<ProductoEntity, Integer>, JpaSpecificationExecutor<ProductoEntity> {
	
}
