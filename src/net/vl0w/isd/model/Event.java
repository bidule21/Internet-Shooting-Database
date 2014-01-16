package net.vl0w.isd.model;

import java.util.HashMap;
import java.util.Map;

public class Event {

	private Map<Shooter, Result> resultsOfShooters;

	public Event() {
		resultsOfShooters = new HashMap<>();
	}

	public void addAttendee(Shooter shooter) {
		resultsOfShooters.put(shooter, new Result());
	}

	public boolean isAttending(Shooter shooter) {
		return resultsOfShooters.keySet().contains(shooter);
	}

	public Result result(Shooter shooter) {
		if (!isAttending(shooter)) {
			throw new IllegalArgumentException(shooter.toString()
					+ " is not attending this event");
		}
		return resultsOfShooters.get(shooter);
	}

}
