package com.nexos.inventory.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*
* @author JhonT
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="MERCANCIA")
public class MercanciaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_MERCANCIA")
	private String idMercancia;
	
	@NotNull
	@Column(name = "CANTIDAD", nullable = false)
	private Integer cantidad;
	
	@NotNull
	@Column(name = "TIPO_ENTRADA", nullable = false)//Tipo entrada de la mercancia SALIDA=S y ENTRADA=E
	private String tipoEntrada;
	
	@ManyToOne
	@JoinColumn(name = "ID_USU")
    private UsuarioEntity usuarioEntity;
	
	@ManyToOne
	@JoinColumn(name = "ID_PRO")
	private ProductoEntity productoEntity;
}
