package hu.kry.robotweb;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kry.hu.KarEgyseg;
import kry.hu.Lab;
import kry.hu.LabEgyseg;
import kry.hu.Robot;

@Controller
public class MainController {
	private Robot robot;

	@PostConstruct
	private void init() {
		Lab lab = new LabEgyseg();
		robot = new Robot(lab);
		robot.setKar( new KarEgyseg());
	}

	@GetMapping(value = "/")
	@ResponseBody
	public String getRoot() {
		return "OK";
	}

	@PostMapping(value = "/waving")
	@ResponseBody
	public String postWaving() {
		robot.hello();
		return robot.toString();
	}

	@PostMapping(value = "/moveEnd")
	@ResponseBody
	public String postMoveEnd() {
		robot.mozog();
		return robot.toString();
	}

}
