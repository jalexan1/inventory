package com.nexos.inventory.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase BeansConfig
 *
 * Carga los beans necesarios para el sistema
 * 
 * @author JhonT
 * @version %I%, %G%
 * 
 * */
@Configuration
public class BeansConfig {

	/**
	 * Este metodo se encarga de inyectar un ModelMapper al proyecto
	 *
	 * @return ModelMapper
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
