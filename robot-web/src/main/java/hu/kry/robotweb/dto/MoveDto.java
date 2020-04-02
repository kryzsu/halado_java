package hu.kry.robotweb.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveDto {
	@NotNull
	@Min(0)
	private Integer x;
	@NotNull
	@Min(0)
	private Integer y;
}
