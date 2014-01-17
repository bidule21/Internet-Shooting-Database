package net.vl0w.isd.model.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.vl0w.isd.model.Shooter;
import net.vl0w.isd.model.result.Result;

public class ShooterResultContainer implements Serializable {

	private static final long serialVersionUID = 8179549201220350227L;
	protected Map<Shooter, Result> shooterResults;

	public ShooterResultContainer() {
		shooterResults = new HashMap<>();
	}

	public void setResult(Shooter shooter, Result result) {
		shooterResults.put(shooter, result);
	}

	public Result result(Shooter shooter) {
		if (!shooterResults.containsKey(shooter)) {
			setResult(shooter, new Result());
		}
		return shooterResults.get(shooter);
	}

	public boolean isParticipating(Shooter shooter) {
		return shooterResults.keySet().contains(shooter);
	}
}