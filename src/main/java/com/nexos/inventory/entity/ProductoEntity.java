package com.nexos.inventory.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="PRODUCTO")
public class ProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "SEQ_ID_PRO", allocationSize = 1, name = "SEQ_ID_PRO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_PRO")
	@Column(name="ID_PRO")
	private Integer id_pro;
	
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "NOM_PRO")
	private String nomPro;
	
}
