package hu.kry.robotweb;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kry.hu.KarEgyseg;
import kry.hu.Lab;
import kry.hu.LabEgyseg;
import kry.hu.Robot;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {
	private Robot robot;

	@PostConstruct
	private void init() {
		Lab lab = new LabEgyseg();
		robot = new Robot(lab);
		robot.setKar( new KarEgyseg());
	}

	@GetMapping(value = "/")
	public ModelAndView getRoot() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("robot", robot);
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

	@PostMapping(value = "/moveEnd")
	public ModelAndView postMoveEnd() {
		// modell hasznalata
		robot.mozog();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("robot", robot);
		return mav;
	}

	@PostMapping(value = "/move")
	public ModelAndView postMove( @RequestParam int x, @RequestParam int y) {
		log.info(String.format("x:%d, y: %d", x, y));
		// modell hasznalata
		robot.mozog(x, y);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("robot", robot);
		return mav;
	}

}
