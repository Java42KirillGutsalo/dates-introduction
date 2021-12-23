package telran.util.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextFriday13Adjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		temporal = temporal.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
		while (!isFriday13(temporal)) {
			temporal = temporal.plus(1, ChronoUnit.WEEKS);
		}
		return temporal;
	}

	private boolean isFriday13(Temporal temporal) {
		
		return ((LocalDate) temporal).getDayOfMonth() == 13 && 
				((LocalDate) temporal).getDayOfWeek() == DayOfWeek.FRIDAY;
	}

}
