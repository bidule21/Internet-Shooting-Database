package net.vl0w.isd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Segment {
	private Position position;
	private int shotCount;

	public Segment(Position position, int shotCount) {
		this.position = position;
		this.shotCount = shotCount;
	}

	public Position getPosition() {
		return position;
	}

	public int getShotCount() {
		return shotCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Segment == false) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		Segment other = (Segment) obj;

		EqualsBuilder equalsBuilder = new EqualsBuilder();
		equalsBuilder.append(getPosition(), other.getPosition());
		equalsBuilder.append(getShotCount(), other.getShotCount());

		return equalsBuilder.build();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(getPosition());
		hashCodeBuilder.append(getShotCount());
		return hashCodeBuilder.build();
	}
}
