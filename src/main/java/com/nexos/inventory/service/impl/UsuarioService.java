package com.nexos.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nexos.inventory.dto.Rq.CreateUserRq;
import com.nexos.inventory.entity.CargoEntity;
import com.nexos.inventory.entity.UsuarioEntity;
import com.nexos.inventory.repository.ICargoRepository;
import com.nexos.inventory.repository.IUsuarioRepository;
import com.nexos.inventory.service.IUsuarioService;
import com.nexos.inventory.util.UsuarioMapper;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	ICargoRepository iCargoRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Override
	public Integer crearUsuario(CreateUserRq createUserRq) throws Exception {
		return createMapUsuario(createUserRq);	
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer createMapUsuario(CreateUserRq createUserRq) throws Exception
	{
		UsuarioEntity usuarioEntity = usuarioMapper.crearUsuarioRQ(createUserRq);
		Optional<CargoEntity> cargoEntity = iCargoRepository.findById(createUserRq.getUserDTO().getCargoDTO().getIdCar());
		
		if (cargoEntity.isPresent()) {
			CargoEntity car = cargoEntity.get();
			car.setIdCargo(cargoEntity.get().getIdCargo());
			car.setNomCargo(cargoEntity.get().getNomCargo());
			usuarioEntity.setCargoEntity(car);
			return iUsuarioRepository.save(usuarioEntity).getId_usu();
		}else {
			//throw new RegistroNoEncontradoException("Solicitud de desembolso No Existe");
			throw new Exception("El id del Cargo #:"+createUserRq.getUserDTO().getCargoDTO().getIdCar()+" No Existe");
		}
	}
	
}
