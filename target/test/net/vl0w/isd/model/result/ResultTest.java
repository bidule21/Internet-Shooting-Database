package net.vl0w.isd.model.result;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ResultTest {

	private Result result;

	@Before
	public void initResult() {
		result = new Result();
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
		result.addSeries(104.9);
		result.addSeries(102.3);
		assertEquals(207.2, result.getResult(), 1);
		assertEquals(104.9, result.series(0), 1);
		assertEquals(102.3, result.series(1), 1);
	}

	@Test
	public void singlePosition_singleSeries() {
		result.addSeries(Position.KNEELING, 104.9);
		assertEquals(104.9, result.getResult(), 1);
		assertEquals(104.9, result.position(Position.KNEELING), 1);
	}

	@Test
	public void singlePosition_multipleSeries() {
		result.addSeries(Position.KNEELING, 104.9);
		result.addSeries(Position.KNEELING, 102.3);
		assertEquals(207.2, result.getResult(), 1);
		assertEquals(207.2, result.position(Position.KNEELING), 1);
	}

	@Test
	public void multiplePositions_singleSeries() {
		result.addSeries(Position.KNEELING, 103.6);
		result.addSeries(Position.STANDING, 102.3);
		assertEquals(205.9, result.getResult(), 1);
		assertEquals(103.6, result.position(Position.KNEELING), 1);
		assertEquals(102.3, result.position(Position.STANDING), 1);
	}

	@Test
	public void multiplePositions_multipleSeries() {
		result.addSeries(Position.KNEELING, 103.6);
		result.addSeries(Position.KNEELING, 101.5);
		result.addSeries(Position.STANDING, 102.3);
		result.addSeries(Position.STANDING, 106.3);
		result.addSeries(Position.STANDING, 100.2);

		// Overall result check
		assertEquals(513.9, result.getResult(), 1);

		// Position result check
		assertEquals(205.1, result.position(Position.KNEELING), 1);
		assertEquals(308.8, result.position(Position.STANDING), 1);

		// Series result check
		assertEquals(103.6, result.series(Position.KNEELING, 0), 1);
		assertEquals(101.5, result.series(Position.KNEELING, 1), 1);
		assertEquals(102.3, result.series(Position.STANDING, 0), 1);
		assertEquals(106.3, result.series(Position.STANDING, 1), 1);
		assertEquals(100.2, result.series(Position.STANDING, 2), 1);
	}

	@Test
	public void illegalSeriesIndex_ReturnZero() {
		result.addSeries(102.3);
		result.addSeries(103.4);
		assertEquals(0, result.series(-1), 1);
		assertEquals(102.3, result.series(0), 1);
		assertEquals(103.4, result.series(1), 1);
		assertEquals(0, result.series(2), 1);
		assertEquals(0, result.series(3), 1);
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
