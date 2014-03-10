package net.vl0w.isd.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.vl0w.isd.persistence.ADocument;
import net.vl0w.isd.result.Position;
import net.vl0w.isd.result.Result;
import net.vl0w.isd.shooter.Shooter;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Event extends ADocument {

	private String name;
	private Map<String, List<Result>> stages;

	public Event(String name) {
		this.name = name;
		this.stages = new HashMap<>();
		assignId();
	}

	public String getName() {
		return name;
	}

	public Map<String, List<Result>> stages() {
		return stages;
	}

	public List<Result> stage(String stageName) {
		if (!stages.containsKey(stageName)) {
			stages.put(stageName, new ArrayList<Result>());
		}
		return stages.get(stageName);
	}

	public Result result(Shooter shooter, Position position) {
		return result(shooter, position.name());
	}

	public Result result(Shooter shooter, String stageName) {
		List<Result> stageResults = stage(stageName);

		for (Result result : stageResults) {
			if (result.getShooter().equals(shooter)) {
				return result;
			}
		}
		Result newResult = new Result(shooter);
		stageResults.add(newResult);

		return newResult;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
