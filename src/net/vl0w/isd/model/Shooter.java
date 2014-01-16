package net.vl0w.isd.model;

public class Shooter implements Storable {

	private static final long serialVersionUID = 2464780528346612896L;

	private String firstName;
	private String lastName;

	public Shooter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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
}
