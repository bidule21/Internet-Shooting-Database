package net.vl0w.isd;

public class ResultFactory {

	public static Result createCrossbowMatch() throws DataException {
		Result result = new Result(Weapon.CROSSBOW_30M);
		result.setDescription("30m Crossbow Match");
		result.setDecimalsAllowed(false);

		result.addSegment(new Segment(Position.KNEELING, 30));
		result.addSegment(new Segment(Position.STANDING, 30));

		return result;
	}

	public static Result createAirRifle(int shotCount) throws DataException {
		Result result = new Result(Weapon.AIRRIFLE);
		result.setDescription("Air Rifle (" + shotCount + ")");
		result.setDecimalsAllowed(true);

		result.addSegment(new Segment(Position.STANDING, shotCount));

		return result;
	}
}
