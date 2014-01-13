package net.vl0w.isd;

import static net.vl0w.isd.Position.KNEELING;
import static net.vl0w.isd.Position.STANDING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SegmentTest {

	@Test
	public void testEquality() {
		assertThat(segment(KNEELING, 10), is(equalTo(segment(KNEELING, 10))));
		assertThat(segment(KNEELING, 10), not(segment(STANDING, 10)));
		assertThat(segment(KNEELING, 10), not(segment(KNEELING, 20)));
		assertThat(segment(KNEELING, 10), not(new Object()));
	}

	private Segment segment(Position position, int shotCount) {
		return new Segment(position, shotCount);
	}
}
