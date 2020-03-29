package kry.hu;

import org.junit.Assert;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RobotTest {

	@Test
	public void mozogWithoutParameter() {
		// given
		Lab lab = mock(Lab.class);

		// when
		new Robot(lab).mozog();

		//then
		verify(lab, times(1)).move(10, 10);
	}

	@Test
	public void comp() {
		// given
		final int value = 123;
		Lab lab = mock(Lab.class);
		when(lab.comp()).thenReturn(value);

		// when
		int result = new Robot(lab).comp();

		//then
		verify(lab, times(1)).comp();
		Assert.assertEquals(value, result);
	}

	@Test
	public void testMozogWithString_Gazda() {
		// given
		Lab lab = mock(Lab.class);

		// when
		new Robot(lab).mozog("gazda");

		//then
		verify(lab, times(1)).move(0, 0);
	}

	@Test
	public void testMozogWithString_Vendeg() {
		// given
		Lab lab = mock(Lab.class);

		// when
		new Robot(lab).mozog("vendeg");

		//then
		verify(lab, times(1)).move(100, 100);
	}

	@Test
	public void testMozogWithString_Other() {
		// given
		Lab lab = mock(Lab.class);

		// when
		new Robot(lab).mozog("asdasdasd");

		//then
		verify(lab, times(0)).move(100, 100);
	}
	@Test
	public void testMozogWithString_Null() {
		// given
		Lab lab = mock(Lab.class);

		// when
		new Robot(lab).mozog(null);

		//then
		verify(lab, times(0)).move(100, 100);
	}

	@Test
	public void hello() {
		// given
		Lab lab = mock(Lab.class);
		Kar kar = mock(Kar.class);

		// when
		Robot robot = new Robot(lab);
		robot.setKar(kar);
		robot.hello();

		//then
		verify(kar, times(1)).integet();
		//then
		verify(lab, times(1)).move(0, 0);
	}
}