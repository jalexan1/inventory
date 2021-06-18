package com.nexos.inventory.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Mercancia", description = "Información en formato IFX de la Mercancia")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MercanciaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id de la Mercancia", required = true, example = "A001PC")
    @Size(min = 1, max = 200)
	@JsonProperty("IdMercancia")
	private String idMercancia;
    
	@ApiModelProperty(notes = "Cantidad de producto", required = true, example = "1")
	@JsonProperty("Cantidad")
	@Valid
	private Integer cantidad;
	
	@ApiModelProperty(notes = "Tipo entrada de la mercancia SALIDA=S y ENTRADA=E", required = true, example = "E")
    @Size(min = 1, max = 2)
	@JsonProperty("TipoEntrada")
	private String tipoEntrada;
	
	@ApiModelProperty(notes = "Informacion del producto", required = false)
	@JsonProperty("ProductoDTO")
	ProductoDTO productoDTO;
	
	@ApiModelProperty(notes = "Informacion del usuario", required = false)
	@JsonProperty("UserDTO")
	UserDTO userDTO;
}
