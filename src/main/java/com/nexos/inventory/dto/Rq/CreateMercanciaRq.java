package com.nexos.inventory.dto.Rq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexos.inventory.dto.MercanciaDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Mercancia", description = "Información Administración de la Mercancia")
@Data	
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateMercanciaRq {
	
	//@NotNull
	//@Valid
	@JsonProperty("Mercancia")
	@ApiModelProperty(notes = "Información de la mercancia", required = false)
	private MercanciaDTO mercanciaDTO;
}
