package com.nexos.inventory.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="CARGO")
public class CargoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CARGO")
	private Integer idCargo;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "NOM_CARGO")
	private String nomCargo;
	
}
