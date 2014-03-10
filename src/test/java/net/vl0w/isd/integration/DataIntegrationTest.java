package net.vl0w.isd.integration;

import java.util.Arrays;

import net.vl0w.isd.event.Event;
import net.vl0w.isd.shooter.Shooter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataIntegrationTest extends IntegrationTest {

	private Shooter jerryJackson;
	private Shooter johnDoe;

	@Before
	public void injectData() {
		jerryJackson = new Shooter("Jerry", "Jackson");
		johnDoe = new Shooter("John", "Doe");
		shooterRepository.save(Arrays.asList(jerryJackson, johnDoe));

		Event event = new Event("Ultra Competition");
		event.result(jerryJackson, "Kneeling").addSeries(97, 96, 94);
		event.result(jerryJackson, "Standing").addSeries(90, 89, 99);
		event.result(johnDoe, "Kneeling").addSeries(95, 93, 94);
		event.result(johnDoe, "Standing").addSeries(88, 91, 90);
		eventRepository.save(event);
	}

	@Test(timeout = DEFAULT_TEST_TIMEOUT)
	public void testEventData() {
		assertEquals(1, eventRepository.count());

		Event event = eventRepository.getByName("Ultra Competition");
		assertEquals("Ultra Competition", event.getName());
		assertEquals(2, event.stages().size());

		// Stage: Kneeling
		assertEquals(2, event.stage("Kneeling").size());
		assertEquals(97 + 96 + 94, event.result(jerryJackson, "Kneeling")
				.getResult(), 0);
		assertEquals(95 + 93 + 94, event.result(johnDoe, "Kneeling")
				.getResult(), 0);

		// Stage: Standing
		assertEquals(2, event.stage("Standing").size());
		assertEquals(90 + 89 + 99, event.result(jerryJackson, "Standing")
				.getResult(), 0);
		assertEquals(88 + 91 + 90, event.result(johnDoe, "Standing")
				.getResult(), 0);
	}

	@Test(timeout = DEFAULT_TEST_TIMEOUT)
	public void testShooterData() {
		assertEquals(2, shooterRepository.count());
	}
}
