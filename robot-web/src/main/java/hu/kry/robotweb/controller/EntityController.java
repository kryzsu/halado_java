package hu.kry.robotweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hu.kry.robotweb.controller.dto.EntityDto;
import hu.kry.robotweb.service.EntityService;

@Controller
public class EntityController {
	private EntityService entityService;

	@Autowired
	public void setEntityService(EntityService entityService) {
		this.entityService = entityService;
	}

	@GetMapping("/entity")
	ModelAndView showForm() {
		return new ModelAndView("entity").addObject("entityDto", new EntityDto());
	}

	@PostMapping("/entity")
	ModelAndView saveForm(@Valid EntityDto entityDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("entity");
		}

		// mentes
		entityService.add(entityDto);
		return new ModelAndView("redirect:/");
	}

}
