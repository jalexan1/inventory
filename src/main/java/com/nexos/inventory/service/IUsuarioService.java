package com.nexos.inventory.service;

import com.nexos.inventory.dto.Rq.CreateUserRq;

public interface IUsuarioService {
	public Integer crearUsuario(CreateUserRq createUserRq) throws Exception;
}
