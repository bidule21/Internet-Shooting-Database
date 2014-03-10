package net.vl0w.isd.result;

import net.vl0w.isd.shooter.Shooter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;

public class ResultTest {

	private Result result;

	@Before
	public void initResult() {
		Shooter shooter = mock(Shooter.class);
		result = new Result(shooter);
	}

	@Test
	public void noPosition_noSeries() {
		assertEquals(0, result.getResult(), 1);
	}

	@Test
	public void noPosition_singleSeries() {
		result.addSeries(104.9);
		assertEquals(104.9, result.getResult(), 1);
	}

	@Test
	public void noPosition_multipleSeries() {
		result.addSeries(104.9, 102.3);
		assertEquals(207.2, result.getResult(), 1);
		assertEquals(104.9, result.getSeries().get(0), 1);
		assertEquals(102.3, result.getSeries().get(1), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void tooHighSeriesValue() {
		result.addSeries(109.1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeSeriesValue() {
		result.addSeries(-102.3);
	}
}
