package kry.hu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RobotParametersDto {
	private String name;
	private String owner;
	private String id;
	private String ownerId;
	private String place;
	private int conpsumtion;
}
