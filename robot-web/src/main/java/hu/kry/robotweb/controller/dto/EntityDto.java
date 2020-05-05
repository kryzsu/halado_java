package hu.kry.robotweb.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityDto {
	@NotBlank
	private String Name;
	@NotNull
	private Integer x;
	@NotNull
	private Integer y;
}
