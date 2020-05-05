package hu.kry.robotweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hu.kry.robotweb.controller.dto.EntityDto;
import hu.kry.robotweb.service.EntityService;
import kry.hu.KarEgyseg;
import kry.hu.LabEgyseg;
import kry.hu.Robot;

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

	private void v() {
		Predicate<Robot> hasArm = (Robot rItem) -> !rItem.toString().contains("kar=,");
		Predicate<Robot> isMoving = (Robot rItem) -> !rItem.toString().contains("LabEgyseg(operation=idle)");
		Function<Integer, Integer> f = (Integer a) -> 2 * a;

		ArrayList<Robot> robotList = new ArrayList<>();
		Robot r = new Robot(new LabEgyseg());
		robotList.add(r);
		r = new Robot(new LabEgyseg());
		r.setKar(new KarEgyseg());
		robotList.add(r);

		List<Robot> robotList1 = robotList.stream().filter(
				hasArm.and(isMoving)
		).collect(Collectors.toList());

	}

}
