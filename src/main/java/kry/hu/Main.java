package kry.hu;

public class Main {
	public static void main(String[] args) {
		Lab lab = new LabEgyseg();
		Robot robot = new Robot(lab);

		robot.mozog();
	}
}
