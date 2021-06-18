package com.nexos.inventory.dto.Rq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexos.inventory.dto.UserDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Usuario", description = "Información Administración de Usuario")
@Data	
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRq {
	
	//@NotNull
	//@Valid
	@JsonProperty("User")
	@ApiModelProperty(notes = "Información del usuario", required = false)
	private UserDTO userDTO;
}
