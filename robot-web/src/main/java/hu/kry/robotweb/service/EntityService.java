package hu.kry.robotweb.service;

import java.util.List;
import hu.kry.robotweb.controller.dto.EntityDto;

public interface EntityService {
	void add(EntityDto entityDto);
	List<EntityDto> listAll();
}
