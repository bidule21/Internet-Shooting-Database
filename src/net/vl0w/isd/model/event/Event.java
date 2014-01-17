package net.vl0w.isd.model.event;

import java.util.ArrayList;
import java.util.List;

import net.vl0w.isd.model.Storable;

public class Event extends ShooterResultContainer implements Storable {

	private static final long serialVersionUID = -4664441739967526334L;
	private List<Programme> programmes;

	public Event() {
		programmes = new ArrayList<>();
	}

	public Programme programme(String description) {
		Programme programme = new Programme(description);
		if (!programmes.contains(programme)) {
			programmes.add(programme);
		}
		return programmes.get(programmes.indexOf(programme));
	}

	public List<Programme> programmes() {
		return programmes;
	}

}
