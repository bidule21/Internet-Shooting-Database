package net.vl0w.isd.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;

import net.vl0w.isd.DataStoreException;
import net.vl0w.isd.model.Shooter;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileDataStoreTest {

	private File storeFile;

	@Before
	public void instantiateTempStoreFile() {
		String tempDirPath = System.getProperty("java.io.tmpdir");
		storeFile = new File(tempDirPath + "/ISD-UnitTesting-TempFile");
		assertFalse(storeFile.exists());
	}

	@After
	public void deleteTempStoreFile() {
		storeFile.delete();
		assertFalse(storeFile.exists());
	}

	@Test
	public void storeFileMustBeCreatedWhenItDoesNotExist()
			throws DataStoreException {
		newStore();
		assertTrue(storeFile.exists());
	}

	@Test
	public void putObjectsThenFileSizeIncreases() throws DataStoreException,
			IOException {
		newStore();
		assertEquals(0, storeFileSize());
		newStore().put(newShooter());
		assertTrue(storeFileSize() > 0);
	}

	@Test
	public void sameStoreInstanceCachesObjects() throws DataStoreException {
		FileDataStore dataStore = newStore();
		dataStore.put(newShooter());
		storeFile.delete();
		assertEquals(1, dataStore.getShooters().size());
	}

	@Test
	public void newStoreInstanceLoadsObjectsFromFile()
			throws DataStoreException {
		newStore().put(newShooter());
		assertEquals(1, newStore().getShooters().size());
	}

	@Test
	public void illegalSavedObjectCausesStoreToBeDeleted()
			throws DataStoreException, IOException {
		newStore().put(newShooter());

		// Write a string (illegal object) to store file
		String illegallySavedString = new String("Hi I'm Jerry Jackson!");
		new ObjectOutputStream(FileUtils.openOutputStream(storeFile))
				.writeObject(illegallySavedString);

		// Store must be empty
		assertEquals(0, newStore().getShooters().size());
	}

	private FileDataStore newStore() throws DataStoreException {
		return new FileDataStore(storeFile);
	}

	private Shooter newShooter() {
		return new Shooter("Jerry", "Jackson");
	}

	private long storeFileSize() throws IOException {
		return FileUtils.readFileToByteArray(storeFile).length;
	}
}
