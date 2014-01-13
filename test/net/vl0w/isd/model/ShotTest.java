package net.vl0w.isd.model;

import net.vl0w.isd.DataException;
import net.vl0w.isd.model.Shot;

import org.junit.Test;

public class ShotTest {

	@Test(expected = DataException.class)
	public void setValue_ValueTooHigh_Error() throws DataException {
		new Shot(11.0);
	}

	@Test(expected = DataException.class)
	public void setValue_ValueTooLow_Error() throws DataException {
		new Shot(0.9);
	}

	@Test
	public void setValue_ValueIsZero_NoException() throws DataException {
		new Shot(0);
	}

	@Test
	public void setValue_LegalValues_NoException() throws DataException {
		new Shot(1.0);
		new Shot(10.9);
	}
}
