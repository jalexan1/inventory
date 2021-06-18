package com.nexos.inventory.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name="USUARIO")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "SEQ_ID_USU", allocationSize = 1, name = "SEQ_ID_USU")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_USU")
	@Column(name="ID_USU")
	private Integer id_usu;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "NOM_USU")
	private String nomUsuario;
	
	@Column(name = "FECHA_NAC", nullable = false)
	private LocalDate fechaNac;
	
	@Column(name = "FECHA_ING_EMPRESA", nullable = false)
	private LocalDate fechaIngEmpresa;
	
	@ManyToOne
	@JoinColumn(name = "ID_CARGO")
    private CargoEntity cargoEntity;
}
