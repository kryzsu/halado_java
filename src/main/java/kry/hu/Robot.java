package kry.hu;

/*
kotelezo fuggoseg: labEgyseg
opcionalis fuggoseg: kar

fuggoseg:
- kontruktorba
- setteren kesztul
- privat adattagba
 */
public class Robot {
	Lab lab;
	Kar kar;

	public void setKar(Kar kar) {
		this.kar = kar;
	}

	public Robot(Lab lab) {
		this.lab = lab;
	}

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
