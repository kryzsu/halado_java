package hu.kry.robotweb.repo;

import java.util.List;

import hu.kry.robotweb.controller.dto.EntityDto;

public interface EntityRepository {
	void save(EntityDto entityDto);
	EntityDto getByName(String name);
	List<EntityDto> getAll();
}
