package kry.hu;

import kry.hu.dto.RobotParametersDto;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
kotelezo fuggoseg: labEgyseg
opcionalis fuggoseg: kar

fuggoseg:
- kontruktorba
- setteren kesztul
- privat adattagba
 */
@RequiredArgsConstructor
@ToString
public class Robot {
	private final Lab lab;
	@Setter
	private Kar kar;
	@Setter
	private RobotParametersDto parameters;

	public void hello() {
		System.out.println("hello");
		lab.move(0,0);
		if (kar != null) {
			kar.integet();
		}
	}

	// egy viselkedes hasznalja a fuggoseg viselkedeset
	public void mozog() {
		lab.move(10, 10);
	}

	public int comp() {
		return lab.comp();
	}

	public void mozog(String entity) {
		if ("gazda".equals(entity)) {
			lab.move(0,0);
		} else if ("vendeg".equals(entity)){
			lab.move(100, 100);
		}
	}
}
