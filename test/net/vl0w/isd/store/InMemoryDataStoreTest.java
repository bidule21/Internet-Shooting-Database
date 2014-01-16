package net.vl0w.isd.store;

import static org.junit.Assert.assertEquals;
import net.vl0w.isd.DataStoreException;
import net.vl0w.isd.model.Result;
import net.vl0w.isd.model.Shooter;

import org.junit.Before;
import org.junit.Test;

public class InMemoryDataStoreTest {

	private InMemoryDataStore dataStore;

	@Before
	public void createDataProvider() {
		dataStore = new InMemoryDataStore();
	}

	@Test
	public void testPutResult() throws DataStoreException {
		Result result = new Result();
		dataStore.put(result);
		assertEquals(1, dataStore.getResults().size());
		assertEquals(result, dataStore.getResults().get(0));
	}

	@Test
	public void testPutShooter() throws DataStoreException {
		Shooter shooter = new Shooter("Jerry", "Jackson");
		dataStore.put(shooter);
		assertEquals(1, dataStore.getShooters().size());
		assertEquals(shooter, dataStore.getShooters().get(0));
	}

	@Test
	public void testGetShooters_EmptyByDefault() {
		assertEquals(0, dataStore.getResults().size());
	}
}
