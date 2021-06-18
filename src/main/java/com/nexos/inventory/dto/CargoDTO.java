package com.nexos.inventory.dto;

import java.io.Serializable;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Cargo", description = "Información en formato IFX de un Cargo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class CargoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id del cargo", required = true, example = "1")
	@JsonProperty("IdCar")
	@Valid
	private Integer idCar;
	
	@ApiModelProperty(notes = "Nombre del cargo", required = false, example = "Asesor de ventas")
    //@Size(min = 1, max = 100)
	@JsonProperty("NomCar")
	private String nomCar;
}
