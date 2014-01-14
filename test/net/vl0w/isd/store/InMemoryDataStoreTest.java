package net.vl0w.isd.store;

import static org.junit.Assert.assertEquals;
import net.vl0w.isd.model.Result;
import net.vl0w.isd.model.Shooter;
import net.vl0w.isd.store.InMemoryDataStore;

import org.junit.Before;
import org.junit.Test;

public class InMemoryDataStoreTest {

	private InMemoryDataStore dataProvider;

	@Before
	public void createDataProvider() {
		dataProvider = new InMemoryDataStore();
	}

	@Test
	public void testPutResult() {
		Result result = new Shooter("Jerry", "Jackson").newResult();
		dataProvider.put(result);
		assertEquals(1, dataProvider.getResults().size());
		assertEquals(result, dataProvider.getResults().get(0));
	}

	@Test
	public void testPutShooter() {
		Shooter shooter = new Shooter("Jerry", "Jackson");
		dataProvider.put(shooter);
		assertEquals(1, dataProvider.getShooters().size());
		assertEquals(shooter, dataProvider.getShooters().get(0));
	}

	@Test
	public void testGetShooters_EmptyByDefault() {
		assertEquals(0, dataProvider.getResults().size());
	}
}
