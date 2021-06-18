package com.nexos.inventory.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
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

@ApiModel(value = "UserDTO", description = "Información en formato IFX de un Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id del usuario", required = false, example = "1")
	@JsonProperty("Id_usu")
	private Integer id_usu;
	
	@ApiModelProperty(notes = "Nombre del usuario", required = false, example = "Juan Velez")
    //@Size(min = 1, max = 100)
	@JsonProperty("NomUsu")
	private String nomUsu;
    
    @ApiModelProperty(notes = "Indica fecha de nacimiento. Ejemplo: 1980-07-01", required = false, example = "1980-07-01")
	@JsonProperty("FecNac")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fecNac;
	
	@JsonProperty("FecIngEmp")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate fecIngEmp;
	
	@ApiModelProperty(notes = "Informacion del cargo", required = false)
	@JsonProperty("CargoDTO")
	CargoDTO cargoDTO;
}
