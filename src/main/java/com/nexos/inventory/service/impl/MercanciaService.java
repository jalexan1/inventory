package com.nexos.inventory.service.impl;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.nexos.inventory.dto.PageDTO;
import com.nexos.inventory.dto.Rq.CreateMercanciaRq;
import com.nexos.inventory.entity.AuditoriaMercanciaEntity;
import com.nexos.inventory.entity.MercanciaEntity;
import com.nexos.inventory.entity.ProductoEntity;
import com.nexos.inventory.entity.UsuarioEntity;
import com.nexos.inventory.mapper.PageMapper;
import com.nexos.inventory.repository.IAuditoriaMercanciaRepository;
import com.nexos.inventory.repository.IMercanciaRepository;
import com.nexos.inventory.repository.IProductoRepository;
import com.nexos.inventory.repository.IUsuarioRepository;
import com.nexos.inventory.service.IMercanciaService;
import com.nexos.inventory.util.MercanciaMapper;
import com.nexos.inventory.util.PaginadorGenerico;

@Service
public class MercanciaService implements IMercanciaService {
	
	@Autowired
	IMercanciaRepository iMercanciaRepository;
	
	@Autowired
	IUsuarioRepository iUsuarioRepository;
	
	@Autowired
	IProductoRepository iProductoRepository;
	
	@Autowired
	private MercanciaMapper mercanciaMapper;
	
	@Autowired
	IAuditoriaMercanciaRepository iAuditoriaMercanciaRepository;
	
	@Autowired
	private PaginadorGenerico<MercanciaEntity> paginadorMercancia;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired 
	private PageMapper<MercanciaEntity> pageMapperMercancia;
	
	@Override
	public String crearMercancia(CreateMercanciaRq createMercanciaRq) throws Exception {
		String res = createMapMercancia(createMercanciaRq);
		auditoriaMercancia(createMercanciaRq.getMercanciaDTO().getIdMercancia(), "Crear_Entrada_Mercancia");
		return res;
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String createMapMercancia(CreateMercanciaRq createMercanciaRq) throws Exception
	{
		MercanciaEntity mercanciaEntity = mercanciaMapper.crearMercanciaRQ(createMercanciaRq);
		Optional<ProductoEntity> productoEntity = iProductoRepository.findById(createMercanciaRq.getMercanciaDTO().getProductoDTO().getId_pro());
		Optional<UsuarioEntity> usuarioEntity = iUsuarioRepository.findById(createMercanciaRq.getMercanciaDTO().getUserDTO().getId_usu());
		
		if ( !productoEntity.isPresent() ) {
			throw new Exception("El id del Producto #:"+createMercanciaRq.getMercanciaDTO().getProductoDTO().getId_pro()+" No Existe");
		}else if ( !usuarioEntity.isPresent() ) {
			throw new Exception("El id del Usuario #:"+createMercanciaRq.getMercanciaDTO().getUserDTO().getId_usu()+" No Existe");
		}
		
		ProductoEntity pro = productoEntity.get();
		UsuarioEntity usu = usuarioEntity.get();
		mercanciaEntity.setProductoEntity(pro);
		mercanciaEntity.setUsuarioEntity(usu);
		return iMercanciaRepository.save(mercanciaEntity).getIdMercancia();
	}
	
	@Override
	public Boolean eliminarMercancia(CreateMercanciaRq createMercanciaRq) throws Exception {
		return eliminarMercanciaTransa(createMercanciaRq);	
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Boolean eliminarMercanciaTransa(CreateMercanciaRq createMercanciaRq) throws Exception
	{
		
		if( iMercanciaRepository.existsById(createMercanciaRq.getMercanciaDTO().getIdMercancia()) ){
			Optional<MercanciaEntity> merOpt = iMercanciaRepository.findById(createMercanciaRq.getMercanciaDTO().getIdMercancia());
			
			//Para eliminar mercancía, solo lo puede hacer el usuario que la registró.
			if (merOpt.get().getUsuarioEntity().getId_usu().toString()
					.equalsIgnoreCase(createMercanciaRq.getMercanciaDTO().getUserDTO().getId_usu().toString())) {
				
				MercanciaEntity mer = merOpt.get();
				iMercanciaRepository.delete(mer);
			}else {
				throw new Exception("No se puede eliminar la Mercancia el usuario es diferente.");
			}
		}else {
			throw new Exception("El id de la Mercancia #:"+createMercanciaRq.getMercanciaDTO().getIdMercancia()+" No Existe");
		}
		return true;
	}
	
	public void auditoriaMercancia(String idMercancia, String tpMovimiento) {
		AuditoriaMercanciaEntity aud = new AuditoriaMercanciaEntity();
		//aud.setIdAudMer(idAudMer);
		aud.setIdMercancia(idMercancia);
		aud.setTipoMovimiento(tpMovimiento);////crear update delete Entrada//inserta update delete Salida
		//LocalDateTime hora =  LocalDateTime.now();
		LocalDate hora =  LocalDate.now();
		aud.setFechaMov(hora);
		iAuditoriaMercanciaRepository.save(aud);
	}
	
	//@Override
	public Map<String, Object> getMercancia(PageDTO page) {
		
		Page<MercanciaEntity> pageEntity = paginadorMercancia.consultar(page, iMercanciaRepository);
		Type targetListType = new TypeToken<List<MercanciaEntity>>() {}.getType();		
		List<MercanciaEntity> lineDTOList = mapper.map(pageEntity.getContent(), targetListType);		
		return pageMapperMercancia.mapper(pageEntity, lineDTOList);
	}
}
