package hu.kry.robotweb.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EntityDto {
	@NotBlank
	private String Name;
	@NotNull
	private Integer x;
	@NotNull
	private Integer y;
}
