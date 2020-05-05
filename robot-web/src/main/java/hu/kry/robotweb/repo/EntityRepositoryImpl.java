package hu.kry.robotweb.repo;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.kry.robotweb.controller.dto.EntityDto;

@Component
public class EntityRepositoryImpl implements EntityRepository {
	private final List<EntityDto> entities = new ArrayList<>();

	// for demo purposes
	@PostConstruct
	public void init() {
		entities.add(EntityDto.builder().Name("owner").x(10).y(10).build());
		entities.add(EntityDto.builder().Name("table").x(20).y(10).build());
	}

	@Override
	public void save(EntityDto entityDto) {
		entities.add(entityDto);
	}

	@Override
	public EntityDto getByName(String name) {
		for (EntityDto entityDto: entities) {
			if (entityDto.getName().equals(name)) {
				return entityDto;
			}
		}
		return null;
	}

	@Override
	public List<EntityDto> getAll() {
		return entities;
	}


}
