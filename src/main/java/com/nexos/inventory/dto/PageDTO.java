package com.nexos.inventory.dto;

import java.io.Serializable;
import java.util.HashMap;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Representacion de la paginacion")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-18T12:34:00.113Z")
@Getter
@Setter
@ToString
public class PageDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Numero de la pagina donde se realiza consulta", required = true, example = "1")
	@JsonProperty("page")
	private int page;
	
	@ApiModelProperty(notes = "Numero de registros por pagina", required = true, example = "5")
	@JsonProperty("size")
	private int size;
	
	@ApiModelProperty(notes = "Condiciones que se realizan en el filtro", required = true, example = "FiltroConsulta")
	@JsonProperty("conditions")
	private HashMap<String, FilterDTO> conditions;
	
	@ApiModelProperty(notes = "Campo sobre el cual se va a arealizar el ordenamiento", required = true, example = "OrdenConsulta")
	@JsonProperty("order")
	private String order;
	
	@ApiModelProperty(notes = "Tipo de orden para el campo order", required = true, example = "DESC")
	@JsonProperty("orderType")
	private String orderType;

}
