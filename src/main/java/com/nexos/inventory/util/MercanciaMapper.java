package com.nexos.inventory.util;

import org.springframework.stereotype.Component;

import com.nexos.inventory.dto.Rq.CreateMercanciaRq;
import com.nexos.inventory.entity.MercanciaEntity;

@Component
public class MercanciaMapper {

	public MercanciaEntity crearMercanciaRQ(CreateMercanciaRq createMercanciaRq) {
		MercanciaEntity mercanciaEntity = new MercanciaEntity();
		mercanciaEntity.setIdMercancia(createMercanciaRq.getMercanciaDTO().getIdMercancia());
		mercanciaEntity.setCantidad(createMercanciaRq.getMercanciaDTO().getCantidad());
		mercanciaEntity.setTipoEntrada(createMercanciaRq.getMercanciaDTO().getTipoEntrada());
		return mercanciaEntity;
	}

}
