package hu.kry.robotweb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hu.kry.robotweb.dto.MoveDto;
import hu.kry.robotweb.service.HelperService;
import kry.hu.Robot;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	private HelperService helperService;
	private Robot robot;

	@Autowired
	public void setHelperService(HelperService helperService) {
		this.helperService = helperService;
	}
	@Autowired
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	@GetMapping(value = "/")
	public ModelAndView getRoot() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("robot", robot);
		mav.addObject("entitasok", helperService.getEntities());
		return mav;
	}

	@PostMapping(value = "/waving")
	public ModelAndView postWaving() {
		// modell hasznalata
		robot.hello();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("robot", robot);
		return mav;
	}

	@GetMapping(value = "/move")
	public ModelAndView getMove() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("move");
		mav.addObject("moveDto", new MoveDto(10, 5));
		return mav;
	}

	@PostMapping(value = "/move")
	public ModelAndView postMove(@Valid MoveDto moveDto, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mav.setViewName("move");
			mav.addObject("moveDto", moveDto);
			return mav;
		}
		robot.mozog(moveDto.getX(), moveDto.getY());

		mav.setViewName("redirect:/");
		return mav;
	}

}
