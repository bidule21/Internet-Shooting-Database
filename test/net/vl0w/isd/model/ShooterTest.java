package net.vl0w.isd.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShooterTest {

	private Shooter shooter;

	@Before
	public void createShooter() {
		shooter = new Shooter("Jerry", "Jackson");
	}

	@Test
	public void testToString() {
		assertEquals("Jerry Jackson", shooter.toString());
	}

	@Test
	public void testNewResult() {
		Result result = shooter.newResult();
		assertEquals(shooter, result.getShooter());
	}
}
