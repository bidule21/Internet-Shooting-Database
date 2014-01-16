package net.vl0w.isd.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.vl0w.isd.DataStoreException;
import net.vl0w.isd.model.Result;
import net.vl0w.isd.model.Shooter;
import net.vl0w.isd.model.Storable;

public class InMemoryDataStore {

	private Map<Class<? extends Storable>, List<Storable>> cacheMap;

	public InMemoryDataStore() {
		this.cacheMap = new HashMap<>();
	}

	public void put(Storable storable) throws DataStoreException {
		Class<? extends Storable> storableClass = storable.getClass();
		get(storableClass).add(storable);
	}

	public List<Result> getResults() {
		return getCasted(Result.class);
	}

	public List<Shooter> getShooters() {
		return getCasted(Shooter.class);
	}

	protected Map<Class<? extends Storable>, List<Storable>> getCacheMap() {
		return cacheMap;
	}

	protected void setCacheMap(
			Map<Class<? extends Storable>, List<Storable>> cacheMap) {
		this.cacheMap = cacheMap;
	}

	private <V extends Storable> List<V> getCasted(Class<V> key) {
		List<V> objects = new ArrayList<>();

		List<Storable> storables = get(key);
		for (Storable storable : storables) {
			objects.add(key.cast(storable));
		}

		return objects;
	}

	private List<Storable> get(Class<? extends Storable> key) {
		if (!cacheMap.containsKey(key)) {
			cacheMap.put(key, new ArrayList<Storable>());
		}
		return cacheMap.get(key);
	}
}
