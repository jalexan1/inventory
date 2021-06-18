package com.nexos.inventory.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.inventory.dto.PageDTO;
import com.nexos.inventory.dto.Rq.CreateMercanciaRq;
import com.nexos.inventory.service.IMercanciaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/V1/management")
public class MercanciaController {
	
	@Autowired
	private IMercanciaService iMercanciaService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/mercancia")
	public ResponseEntity<Object> crearUsuario(
		@Valid @RequestBody CreateMercanciaRq createMercanciaRq, 
		BindingResult result) {
		
		try {
			log.info("Ingresa a crear Mercancia");
			//MercanciaRs mercanciaRs = new MercanciaRs(iMercanciaService.crearMercancia(createMercanciaRq));
			return new ResponseEntity<>(iMercanciaService.crearMercancia(createMercanciaRq),HttpStatus.CREATED);
		} catch (Exception e) {
			log.warn("Error: "+e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/mercancia")
	public ResponseEntity<Object> eliminarUsuario(
		@Valid @RequestBody CreateMercanciaRq createMercanciaRq, 
		BindingResult result) {
		
		try {
			log.info("Ingresa a eliminar Mercancia por Id:"+createMercanciaRq.getMercanciaDTO().getIdMercancia());
			return new ResponseEntity<>(iMercanciaService.eliminarMercancia(createMercanciaRq),HttpStatus.OK);
		} catch (Exception e) {
			log.warn("Error: "+e.getMessage());
			return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		}
		
	}
	
	//@Override
	@PostMapping(value = "/mercancia/dinamicQuery")
	public ResponseEntity<Object> getMercancia(
			@Valid @RequestBody PageDTO page, 
			BindingResult result) {
		
		Map<String, Object> mer = iMercanciaService.getMercancia(page);
		return new ResponseEntity<>(mer, HttpStatus.OK);
	}
	
}
