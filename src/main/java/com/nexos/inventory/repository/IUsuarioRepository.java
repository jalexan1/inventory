package com.nexos.inventory.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nexos.inventory.entity.UsuarioEntity;

/**
 * Interface IUsuarioRepository
 *
 * Interface de repositorio para la entidad de Usuario.
 * 
 * @author JhonT
 * @version %I%, %G%
 * 
 * */
@Repository
public interface IUsuarioRepository extends CrudRepository<UsuarioEntity, Integer>, JpaSpecificationExecutor<UsuarioEntity> {
	
}
