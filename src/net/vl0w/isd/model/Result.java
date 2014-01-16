package net.vl0w.isd.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result implements Storable {

	private Map<Position, List<Double>> positionSeries;

	public Result() {
		positionSeries = new HashMap<>();

		for (Position position : Position.values()) {
			positionSeries.put(position, new ArrayList<Double>());
		}
	}

	public double getResult() {
		double result = 0;

		for (Position position : Position.values()) {
			result += getResult(position);
		}

		return result;
	}

	public double getResult(Position position) {
		double result = 0;

		for (double seriesResult : positionSeries.get(position)) {
			result += seriesResult;
		}

		return result;
	}

	public void addSeries(double seriesResult) {
		addSeries(Position.UNKNOWN, seriesResult);
	}

	public void addSeries(Position position, double seriesResult) {
		positionSeries.get(position).add(seriesResult);
	}

	public double series(int seriesIndex) {
		return positionSeries.get(Position.UNKNOWN).get(seriesIndex);
	}

}
