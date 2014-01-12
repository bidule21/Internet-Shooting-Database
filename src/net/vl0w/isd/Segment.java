package net.vl0w.isd;



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
}
