package net.vl0w.isd.shooter;

import net.vl0w.isd.persistence.ADocument;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Shooter extends ADocument {

	private String firstName;
	private String lastName;

	public Shooter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		assignId();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Shooter) {
			Shooter other = (Shooter) obj;
			return this.toString().equals(other.toString());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
