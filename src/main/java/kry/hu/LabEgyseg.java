package kry.hu;

public class LabEgyseg implements Lab {
	@Override
	public void move(int x, int y) {
			System.out.printf("mozogtunk: x:%d, y:%d%n", y, y);
	}

	@Override
	public int comp() {
		return 10;
	}
}
