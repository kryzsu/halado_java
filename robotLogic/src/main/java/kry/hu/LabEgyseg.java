package kry.hu;

import lombok.ToString;

@ToString
public class LabEgyseg implements Lab {
	private String operation = "idle";
	@Override
	public void move(int x, int y) {
		operation = String.format("moving: x:%d, y:%d", y, y);
	}

	@Override
	public int comp() {
		return 10;
	}
}
