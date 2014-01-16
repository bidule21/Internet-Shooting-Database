package net.vl0w.isd.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private Event event;
	private Shooter jerryJackson;
	private Shooter jamesBond;
	private Shooter williamWallace;

	@Before
	public void initEventAndAttendees() {
		jerryJackson = new Shooter("Jerry", "Jackson");
		jamesBond = new Shooter("James", "Bond");
		williamWallace = new Shooter("William", "Wallace");

		event = new Event();
		event.addAttendee(jerryJackson);
		event.addAttendee(jamesBond);
	}

	@Test
	public void attendingShooters() {
		assertTrue(event.isAttending(jerryJackson));
		assertTrue(event.isAttending(jamesBond));
		assertFalse(event.isAttending(williamWallace));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addResultForIllegalAttendee() {
		event.result(williamWallace);
	}

	@Test
	public void addResultForAttendee() {
		event.result(jerryJackson).addSeries(104.9);
		assertEquals(104.9, event.result(jerryJackson).getResult(), 1);
	}
}
