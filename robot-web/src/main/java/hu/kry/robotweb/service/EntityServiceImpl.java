package hu.kry.robotweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.kry.robotweb.controller.dto.EntityDto;
import hu.kry.robotweb.repo.EntityRepository;

@Component
public class EntityServiceImpl implements EntityService {
	private EntityRepository entityRepository;

	@Autowired
	public void setEntityRepository(EntityRepository entityRepository) {
		this.entityRepository = entityRepository;
	}

	@Override
	public void add(EntityDto entityDto) {
		entityRepository.save(entityDto);
	}

	@Override
	public List<EntityDto> listAll() {
		return entityRepository.getAll();
	}
}
