package net.vl0w.isd.event;

import net.vl0w.isd.result.Position;
import net.vl0w.isd.shooter.Shooter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;

public class EventTest {

	@Test
	public void addResult() {
		Shooter shooter = mock(Shooter.class);
		Event event = new Event("MyEvent");

		event.result(shooter, "Kneeling").addSeries(99);
		event.result(shooter, "Kneeling").addSeries(98);
		event.result(shooter, "Kneeling").addSeries(97);

		assertEquals(1, event.stage("Kneeling").size());
		assertEquals(0, event.stage("Standing").size());
	}

	@Test
	public void stageForFixPosition() {
		Shooter shooter = mock(Shooter.class);
		Event event = new Event("MyEvent");
		event.result(shooter, Position.KNEELING).addSeries(99, 98, 97);
		assertTrue(event.stages().containsKey(Position.KNEELING.name()));
	}
}
