package net.vl0w.isd.model;

public class Shooter implements Storable {

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

	public Result newResult() {
		return new Result(this);
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}
