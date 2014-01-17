package net.vl0w.isd.model.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.vl0w.isd.model.Result;
import net.vl0w.isd.model.Shooter;

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
	}

	@Test
	public void participatingShooters() {
		event.result(jerryJackson);
		event.result(jamesBond);
		assertTrue(event.isParticipating(jerryJackson));
		assertTrue(event.isParticipating(jamesBond));
		assertFalse(event.isParticipating(williamWallace));
	}

	@Test
	public void addResult() {
		event.result(jerryJackson).addSeries(104.9);
		assertEquals(104.9, event.result(jerryJackson).getResult(), 1);
	}

	@Test
	public void addProgrammes() {
		Programme kneeling = event.programme("Kneeling");
		Programme standing = event.programme("Standing");
		assertEquals(kneeling, event.programme("Kneeling"));
		assertEquals(standing, event.programme("Standing"));
	}

	@Test
	public void addMultipleProgrammes() {
		event.programme("1");
		event.programme("2");
		event.programme("3");
		assertEquals(3, event.programmes().size());
		assertTrue(event.programmes().contains(event.programme("1")));
		assertTrue(event.programmes().contains(event.programme("2")));
		assertTrue(event.programmes().contains(event.programme("2")));
	}

	@Test
	public void addExistingResultToProgramme() {
		Result result = new Result();
		result.addSeries(102.9);
		event.programme("Kneeling").setResult(jerryJackson, result);
		assertEquals(result, event.programme("Kneeling").result(jerryJackson));
	}

	@Test
	public void addNewResultDirectlyToProgramme() {
		event.programme("Kneeling").result(jerryJackson).addSeries(103.4);
		event.programme("Kneeling").result(jerryJackson).addSeries(102.1);
		assertEquals(103.4 + 102.1,
				event.programme("Kneeling").result(jerryJackson).getResult(), 1);
	}
}
