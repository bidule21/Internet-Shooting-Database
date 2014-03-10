package net.vl0w.isd.persistence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ADocumentTest {

	@Test
	public void generatedId() {
		ConcreteImplementation document = new ConcreteImplementation();
		assertEquals("ConcreteImplementation/1337", document.getId());
	}

	private class ConcreteImplementation extends ADocument {
		@Override
		public int hashCode() {
			return 1337;
		}
	}
}
