package net.vl0w.isd.result;

import java.util.ArrayList;
import java.util.List;

import net.vl0w.isd.shooter.Shooter;

public class Result {

	private Shooter shooter;
	private List<Double> series;

	public Result(Shooter shooter) {
		this.shooter = shooter;
		this.series = new ArrayList<>();
	}

	public Shooter getShooter() {
		return shooter;
	}

	public List<Double> getSeries() {
		return series;
	}

	public void addSeries(double... seriesResults) {
		for (double seriesResult : seriesResults) {
			if (seriesResult < 0 || seriesResult > 109) {
				throw new IllegalArgumentException();
			}
			series.add(seriesResult);
		}
	}

	public double getResult() {
		double result = 0;

		for (double seriesResult : series) {
			result += seriesResult;
		}

		return result;
	}
}
