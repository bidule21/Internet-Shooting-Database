package net.vl0w.isd.integration;

import java.util.Set;

import net.vl0w.isd.configuration.MongoIntegrationTestingConfiguration;
import net.vl0w.isd.event.EventRepository;
import net.vl0w.isd.shooter.ShooterRepository;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoIntegrationTestingConfiguration.class })
public abstract class IntegrationTest {
	protected static final int DEFAULT_TEST_TIMEOUT = 5000;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	protected EventRepository eventRepository;
	@Autowired
	protected ShooterRepository shooterRepository;

	@After
	public void clearData() {
		Set<String> collectionNames = mongoTemplate.getCollectionNames();
		collectionNames.remove("system.indexes");
		collectionNames.remove("system.users");

		for (String collectionName : collectionNames) {
			mongoTemplate.dropCollection(collectionName);
		}

		assertEquals(2, mongoTemplate.getCollectionNames().size());
		assertEquals(0, eventRepository.count());
		assertEquals(0, shooterRepository.count());
	}
}
