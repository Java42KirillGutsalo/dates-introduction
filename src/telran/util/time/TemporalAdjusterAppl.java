package telran.util.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterAppl {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2021, 12, 23);
		System.out.println(ld);
		ld = ld.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(ld);
		ld = ld.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(ld);
		ld = ld.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
		System.out.println(ld);
		ld = ld.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(ld);
		ld = ld.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		System.out.println(ld);

	}

}
