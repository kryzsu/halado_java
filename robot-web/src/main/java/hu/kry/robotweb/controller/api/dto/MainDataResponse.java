package hu.kry.robotweb.controller.api.dto;

import java.util.List;

import hu.kry.robotweb.controller.dto.EntityDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MainDataResponse {
	private String robot;
	private List<EntityDto> entities;
}
