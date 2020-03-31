package kry.hu;

import lombok.ToString;

@ToString
public class KarEgyseg implements Kar {
	private String operation = "idle";
	@Override
	public void integet() {
		operation = "waiving";
	}
}
