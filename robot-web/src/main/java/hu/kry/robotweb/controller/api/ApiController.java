package hu.kry.robotweb.controller.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.kry.robotweb.controller.api.dto.MainDataResponse;
import hu.kry.robotweb.controller.dto.MoveDto;
import hu.kry.robotweb.service.EntityService;
import kry.hu.Robot;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

	private final Robot robot;
	private final EntityService entityService;

	@GetMapping()
	MainDataResponse getMainData() {
		return new MainDataResponse(robot.toString(), entityService.listAll());
	}

	@PostMapping(value = "/waving")
	public String postWaving() {
		robot.hello();
		return "OK";
	}

	@PostMapping(value = "/move")
	public String postMove(@RequestBody @Valid MoveDto moveDto) {
		robot.mozog(moveDto.getX(), moveDto.getY());
		return "OK";
	}
}
