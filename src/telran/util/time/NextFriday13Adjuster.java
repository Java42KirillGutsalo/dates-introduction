package telran.util.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextFriday13Adjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		/* V.R. Your code works. But...
		 * The step of circle is 7 days or 1 week.
		 * It is possible to use 1 month as the step. In most
		 * of cases it is much quicker, isn't it?
		 */
		temporal = temporal.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
		while (!isFriday13(temporal)) {
			temporal = temporal.plus(1, ChronoUnit.WEEKS);
		}
		return temporal;
	}

	private boolean isFriday13(Temporal temporal) {
		/* V.R. Casting is redundant here
		 * 1. temporal.get(ChronoField.DAY_OF_MONTH) == 13
		 * 2. DayOfWeek.from(temporal) == DayOfWeek.FRIDAY
		 */
		return ((LocalDate) temporal).getDayOfMonth() == 13 && 
				((LocalDate) temporal).getDayOfWeek() == DayOfWeek.FRIDAY;
	}

}
