package com.nexos.inventory.util;

import org.springframework.stereotype.Component;
import com.nexos.inventory.dto.Rq.CreateUserRq;
import com.nexos.inventory.entity.UsuarioEntity;

@Component
public class UsuarioMapper {

	public UsuarioEntity crearUsuarioRQ(CreateUserRq createUserRq) {
		UsuarioEntity usuarioEntity = new UsuarioEntity();
		usuarioEntity.setId_usu(createUserRq.getUserDTO().getId_usu());
		usuarioEntity.setNomUsuario(createUserRq.getUserDTO().getNomUsu());
		usuarioEntity.setFechaNac(createUserRq.getUserDTO().getFecNac());
		usuarioEntity.setFechaIngEmpresa(createUserRq.getUserDTO().getFecIngEmp());
		return usuarioEntity;
	}

}
