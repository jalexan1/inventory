package com.nexos.inventory.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nexos.inventory.dto.Rq.CreateUserRq;
import com.nexos.inventory.service.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/V1/userManagement")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/usuario")
	public ResponseEntity<Object> crearUsuario(
		@Valid @RequestBody CreateUserRq createUserRq, 
		BindingResult result) {
		
		try {
			log.info("Ingresa a crearUsuario");
			//UserRs userRs = new UserRs(iUsuarioService.crearUsuario(createUserRq));
			return new ResponseEntity<>(iUsuarioService.crearUsuario(createUserRq),HttpStatus.CREATED);
		} catch (Exception e) {
			log.warn("Error: "+e.getMessage());
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
	}
}
