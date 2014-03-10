package net.vl0w.isd.integration;

import net.vl0w.isd.event.Event;
import net.vl0w.isd.shooter.Shooter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DocumentUniquenessTest extends IntegrationTest {

	@Test
	public void uniqueEvents() {
		eventRepository.save(new Event("MyEvent"));
		eventRepository.save(new Event("MyEvent"));
		assertEquals(1, eventRepository.count());
	}

	@Test
	public void uniqueShooters() {
		shooterRepository.save(new Shooter("Jerry", "Jackson"));
		shooterRepository.save(new Shooter("Jerry", "Jackson"));
		shooterRepository.save(new Shooter("John", "Jackson"));
		shooterRepository.save(new Shooter("John", "Jackson"));
		shooterRepository.save(new Shooter("Jerry", "Doe"));
		shooterRepository.save(new Shooter("Jerry", "Doe"));
		assertEquals(3, shooterRepository.count());
	}

}
