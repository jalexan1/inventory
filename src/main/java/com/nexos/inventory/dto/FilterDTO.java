package com.nexos.inventory.dto;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "FiltroConsulta", description = "Representacion de filtros en la consulta dinamica")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-06-18T12:36:00.113Z")
public class FilterDTO {

	public enum Types{INTEGER, STRING, DATE, CHAR};	
	public enum Operations{EQUALS, LIKE, BETWEEN};
	
	@ApiModelProperty(notes = "Valores a consultar", required = true, example = "123")
	@JsonProperty("values")
	private String[] values;
	
	@ApiModelProperty(notes = "Operaciones sobre la consulta", required = true, example = "EQUALS")
	@JsonProperty("operation")
	private Operations operation;
	
	@ApiModelProperty(notes = "Tipo de dato con el cual se realiza la consulta", required = true, example = "STRING")
	@JsonProperty("type")
	private Types type;
	
}
