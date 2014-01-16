package net.vl0w.isd.store;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

import net.vl0w.isd.DataStoreException;
import net.vl0w.isd.model.Storable;

import org.apache.commons.io.FileUtils;

public class FileDataStore extends InMemoryDataStore {

	private File storeFile;

	public FileDataStore(File storeFile) throws DataStoreException {
		this.storeFile = storeFile;

		if (!storeFile.exists()) {
			createStoreFile();
		}

		try {
			loadCacheFromScoreFile();
		} catch (ClassNotFoundException | IOException e) {
			throw new DataStoreException(
					"Error while reading saved data store file", e);
		}
	}

	@Override
	public void put(Storable storable) throws DataStoreException {
		super.put(storable);

		try {
			writeCacheToStoreFile();
		} catch (IOException e) {
			throw new DataStoreException("Error while writing data store file",
					e);
		}
	}

	private void loadCacheFromScoreFile() throws IOException,
			ClassNotFoundException {
		byte[] fileByteData = FileUtils.readFileToByteArray(storeFile);
		if (fileByteData.length > 0) {
			ObjectInputStream inStream = new ObjectInputStream(
					new ByteArrayInputStream(fileByteData));
			Object object = inStream.readObject();

			@SuppressWarnings("unchecked")
			Class<Map<Class<? extends Storable>, List<Storable>>> cacheMapClass = (Class<Map<Class<? extends Storable>, List<Storable>>>) getCacheMap()
					.getClass();

			if (cacheMapClass.isAssignableFrom(object.getClass())) {
				setCacheMap(cacheMapClass.cast(object));
			}
		}
	}

	private void writeCacheToStoreFile() throws IOException {
		ObjectOutputStream outStream = new ObjectOutputStream(
				FileUtils.openOutputStream(storeFile));
		outStream.writeObject(getCacheMap());
	}

	private void createStoreFile() throws DataStoreException {
		try {
			storeFile.createNewFile();
		} catch (IOException e) {
			throw new DataStoreException(
					"Error while creating data store file", e);
		}
	}
}
