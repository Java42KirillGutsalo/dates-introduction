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
		Temporal ld;
		do {
			ld = temporal.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
			ld = ld.plus(1, ChronoUnit.WEEKS);
		} while (ld == LocalDate.of(2022, 5, 13));
		
		return ld;
	}

}
