package net.vl0w.isd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ResultTest {

	@Test(expected = DataException.class)
	public void setShot_NoSegmentAsParameter_MultipleSegmentsInResult_Error()
			throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.addSegment(segment());
		result.addSegment(segment());

		result.setShot(1, 10.9);
	}

	@Test(expected = DataException.class)
	public void setShot_TooMuchShotsForSegment_Error() throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.addSegment(segment(5));

		result.setShot(1, 10);
		result.setShot(2, 10);
		result.setShot(3, 10);
		result.setShot(4, 10);
		result.setShot(5, 10);
		result.setShot(6, 10);
	}

	@Test(expected = DataException.class)
	public void setShot_NoDecimalsAllowed_Error() throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.setDecimalsAllowed(false);
		result.addSegment(segment());

		result.setShot(1, 10.5);
	}

	@Test(expected = DataException.class)
	public void setShot_MultipleSegments_IllegalSegmentSpecified_Error()
			throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.addSegment(segment());

		result.setShot(segment(), 1, 10.5);
	}

	@Test(expected = DataException.class)
	public void setShot_IllegalShotNumber_Error() throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.addSegment(segment(5));

		result.setShot(7, 10.5);
	}

	@Test
	public void getResult_OneSegment() throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.setDecimalsAllowed(true);
		result.addSegment(segment());

		result.setShot(1, 10.5);
		result.setShot(2, 10.2);
		result.setShot(3, 10.4);
		result.setShot(4, 10.9);
		result.setShot(5, 9.9);

		assertEquals(51.9, result.getResult(), 1);
	}

	@Test
	public void getResult_ShotValueHasChanged() throws DataException {
		Result result = new Result(Weapon.UNKNOWN);
		result.addSegment(segment());

		result.setShot(1, 10.0);
		result.setShot(2, 10.1);
		result.setShot(3, 10.2);
		result.setShot(4, 10.3);
		result.setShot(5, 10.4);
		result.setShot(6, 10.5);
		result.setShot(7, 10.6);
		result.setShot(8, 10.7);
		result.setShot(9, 10.8);
		result.setShot(10, 10.9);

		assertEquals(104.5, result.getResult(), 1);

		// Set sixth shot
		result.setShot(5, 9.5);

		// Assert all shots
		assertEquals(103.6, result.getResult(), 1);
	}

	private Segment segment() {
		return segment(10);
	}

	private Segment segment(int shots) {
		Segment segment = mock(Segment.class);
		when(segment.getShotCount()).thenReturn(shots);
		return segment;
	}
}
