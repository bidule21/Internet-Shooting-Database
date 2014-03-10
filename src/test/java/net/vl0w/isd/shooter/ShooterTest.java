package net.vl0w.isd.shooter;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ShooterTest {

	@Test
	public void testToString() {
		Shooter shooter = new Shooter("Jerry", "Jackson");
		assertEquals("Jerry Jackson", shooter.toString());
	}

	@Test
	public void testEquality() {
		Shooter jerryJackson = new Shooter("Jerry", "Jackson");
		Shooter lukeJackson = new Shooter("Luke", "Jackson");
		Shooter jerryWayne = new Shooter("Jerry", "Wayne");

		assertThat(jerryJackson, is(equalTo(jerryJackson)));
		assertThat(lukeJackson, is(not(equalTo(jerryJackson))));
		assertThat(jerryWayne, is(not(equalTo(jerryJackson))));
	}
}
