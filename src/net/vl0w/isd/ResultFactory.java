package net.vl0w.isd;

public class ResultFactory {

	public static Result createCrossbowMatch() throws DataException {
		Result result = new Result();
		result.setDecimalsAllowed(false);

		result.addSegment(new Segment(Position.KNEELING, 30));
		result.addSegment(new Segment(Position.STANDING, 30));

		return result;
	}

	public static Result createAirRifle(int shotCount) throws DataException {
		Result result = new Result();
		result.setDecimalsAllowed(true);

		result.addSegment(new Segment(Position.STANDING, shotCount));

		return result;
	}
}
