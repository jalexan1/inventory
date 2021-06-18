package com.nexos.inventory.dto;

import java.io.Serializable;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "ProductoDTO", description = "Información en formato IFX de un Producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Id del producto", required = true, example = "1")
	@JsonProperty("Id_pro")
	@Valid
	private Integer id_pro;
	
	@ApiModelProperty(notes = "Nombre del producto", required = false, example = "Computadores")
    //@Size(min = 1, max = 100)
	@JsonProperty("NomPro")
	private String NomPro;
}
