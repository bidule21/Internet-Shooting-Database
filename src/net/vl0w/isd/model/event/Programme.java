package net.vl0w.isd.model.event;

import java.util.HashMap;

public class Programme extends ShooterResultContainer {

	private static final long serialVersionUID = 9166990322011378155L;
	private String description;

	public Programme(String description) {
		this.description = description;
		this.shooterResults = new HashMap<>();
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object obj) {
		Programme other = (Programme) obj;
		return description.equals(other.getDescription());
	}
}
