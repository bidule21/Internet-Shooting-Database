package net.vl0w.isd.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private Event event;
	private Shooter jerryJackson;
	private Shooter williamWallace;
	private Shooter franzLudwig;

	@Before
	public void initEventAndAttendees() {
		jerryJackson = new Shooter("Jerry", "Jackson");
		williamWallace = new Shooter("William", "Wallace");
		franzLudwig = new Shooter("Franz", "Ludwig");

		event = new Event();
		event.addAttendee(jerryJackson);
		event.addAttendee(williamWallace);
	}

	@Test
	public void attendingShooters() {
		assertTrue(event.isAttending(jerryJackson));
		assertTrue(event.isAttending(williamWallace));
		assertFalse(event.isAttending(franzLudwig));
	}

	@Test(expected = IllegalArgumentException.class)
	public void addResultForIllegalAttendee() {
		event.result(franzLudwig);
	}

	@Test
	public void addResultForAttendee() {
		event.result(jerryJackson).addSeries(104.9);
		assertEquals(104.9, event.result(jerryJackson).getResult(), 1);
	}
}
