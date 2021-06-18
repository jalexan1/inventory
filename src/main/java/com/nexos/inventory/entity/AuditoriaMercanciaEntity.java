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
@Table(name="AUDITORIA_MERCANCIA")
public class AuditoriaMercanciaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(sequenceName = "SEQ_ID_AUD_MER", allocationSize = 1, name = "SEQ_ID_AUD_MER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_AUD_MER")
	@Column(name="ID_AUD_MER")
	private Integer idAudMer;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "ID_MERCANCIA")
	private String idMercancia;
	
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "TIPO_MOVIMIENTO")
	private String tipoMovimiento;
	
	@Column(name = "FECHA_MOV", nullable = false)
	private LocalDate fechaMov;
	
	@ManyToOne
	@JoinColumn(name = "ID_MERCANCIA", insertable = false, updatable = false)
	private MercanciaEntity mercanciaEntity;
}
