package telran.util.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextFriday13Adjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		temporal = temporal.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		while (temporal.get(ChronoField.DAY_OF_MONTH) != 13) {
			temporal = temporal.plus(1, ChronoUnit.WEEKS);
		}
		return temporal;
	}

}