package net.vl0w.isd.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result implements Storable {

	private static final long serialVersionUID = 4125349219545397626L;

	private Map<Position, List<Double>> positionSeries;

	public Result() {
		positionSeries = new HashMap<>();

		for (Position position : Position.values()) {
			positionSeries.put(position, new ArrayList<Double>());
		}
	}

	public void addSeries(double seriesResult) {
		addSeries(Position.UNKNOWN, seriesResult);
	}

	public void addSeries(Position position, double seriesResult) {
		if (seriesResult < 0 || seriesResult > 109) {
			throw new IllegalArgumentException();
		}
		positionSeries.get(position).add(seriesResult);
	}

	public double series(int seriesIndex) {
		return series(Position.UNKNOWN, seriesIndex);
	}

	public double series(Position position, int seriesIndex) {
		try {
			return positionSeries.get(position).get(seriesIndex);
		} catch (IndexOutOfBoundsException e) {
			return 0;
		}
	}

	public double position(Position position) {
		double result = 0;

		for (double seriesResult : positionSeries.get(position)) {
			result += seriesResult;
		}

		return result;
	}

	public double getResult() {
		double result = 0;

		for (Position position : Position.values()) {
			result += position(position);
		}

		return result;
	}
}
