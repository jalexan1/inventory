package com.nexos.inventory.service;

import java.util.Map;

import com.nexos.inventory.dto.PageDTO;
import com.nexos.inventory.dto.Rq.CreateMercanciaRq;

public interface IMercanciaService {
	public String crearMercancia(CreateMercanciaRq createMercanciaRq) throws Exception;
	public Boolean eliminarMercancia(CreateMercanciaRq createMercanciaRq) throws Exception;
	public Map<String, Object> getMercancia(PageDTO page);
}
