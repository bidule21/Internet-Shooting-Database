package net.vl0w.isd.model;

import net.vl0w.isd.DataException;

public class Shot {
	private double value;

	public Shot(double value) throws DataException {
		setValue(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) throws DataException {
		if ((value != 0 && value < 1.0) || value > 10.9) {
			throw new DataException(
					"Onlay values between 1.0 and 10.9 are allowed");
		}
		this.value = value;
	}

	public void setValue(Shot shot) {
		this.value = shot.getValue();
	}

	public boolean hasDecimals() {
		return value - (int) value != 0;
	}
}
