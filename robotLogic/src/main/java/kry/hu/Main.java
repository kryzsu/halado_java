package kry.hu;

import kry.hu.dto.RobotParametersDto;

public class Main {
	public static void main(String[] args) {

		RobotParametersDto robotParametersDto = RobotParametersDto.builder()
				.conpsumtion(123)
				.id("3PO_1")
				.name("3PO")
				.owner("Luke")
				.ownerId("Luke 1")
				.place("Tatuin")
				.build();


		Lab lab = new LabEgyseg();
		Robot robot = new Robot(lab);
		robot.setParameters(robotParametersDto);
		robot.mozog();

		System.out.println(robot);
	}
}
