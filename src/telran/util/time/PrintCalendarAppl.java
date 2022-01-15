package telran.util.time;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendarAppl {
	public static final int DATE_WIDTH = 4;

	public static void main(String[] args) {
		int[] monthYear = args.length<2?getCurrentMonthYear()
			:getMonthYear(args);
		if(monthYear==null)
		{
			System.out.println("Wrong input!!! Use: <month number> <year number>");
			return;
		}
		int month = monthYear[0];
		int year = monthYear[1];
		int dayOfWeek = args.length==3?monthYear[2]:1;
		printMonthYear(month,year,dayOfWeek);

	}

	private static void printMonthYear(int month, int year, int dayOfWeek) {
		printTitle(month,year);
		printWeekDayNames(dayOfWeek);
		printDates(month,year,dayOfWeek);
		System.out.println();
		
	}

	private static void printDates(int month, int year, int dayOfWeek) {
		int firstColumn = getFirstColumn(month,year,dayOfWeek);
		printOffset(firstColumn);
		printNumberFromOffset(firstColumn,month,year);
		
	}

	private static void printNumberFromOffset(int firstColumn, int month, int year) {
		int nDays = getNumberOfDays(month,year);
		for(int i = 1;i<=nDays;i++)
		{
			System.out.printf("%4d",i);
			if(firstColumn==7)
			{
				firstColumn=1;
				System.out.println();
			}else{
				firstColumn++;
			}
		}
		
	}

	private static int getNumberOfDays(int month, int year) {
		YearMonth ym = YearMonth.of(year, month);
		return ym.lengthOfMonth();
	}

	private static void printOffset(int firstColumn) {
		for(int i = DATE_WIDTH+1;i<=firstColumn*DATE_WIDTH;i++)
		{
			System.out.print(" ");
		}
		
	}

	private static int getFirstColumn(int month, int year, int dayOfWeek) {
		LocalDate firstDate = LocalDate.of(year, month, 1);
		int day = firstDate.getDayOfWeek().getValue();
		if(day!=1)
		{
			int delta = day - dayOfWeek;
			day = delta >=0?delta+1:delta+8;
		}
		return day;
	}

	private static void printWeekDayNames(int dayOfWeek) {
		System.out.print("   ");
		for(int i = dayOfWeek;i<=7;i++)
		{
			System.out.print(getDayName(i)+" ");
		}
		for(int i = 1;i<dayOfWeek;i++)
		{
			System.out.println(getDayName(i)+" ");
		}
		System.out.println();
		
	}

	private static String getDayName(int i) {
		 DayOfWeek dayOfWeek = DayOfWeek.of(i);
		 
		return dayOfWeek.getDisplayName(TextStyle.SHORT, 
				Locale.forLanguageTag("en"));
	}

	private static void printTitle(int month, int year) {
		String monthName = getMonthName(month);
		System.out.printf("%6s%s %d\n"," ",monthName,year);
	}

	private static String getMonthName(int month) {
		Month monthEnum = Month.of(month);
		
		return monthEnum.getDisplayName(TextStyle.FULL, 
				Locale.forLanguageTag("en"));
	}

	private static int[] getCurrentMonthYear() {
		LocalDate ld = LocalDate.now();
		
		return new int[] {ld.getMonthValue(),ld.getYear()};
	}

	private static int[] getMonthYear(String[] args) {
		int[] res = new int[3];
		try {
			res[0] = Integer.parseInt(args[0]);
			res[1] = Integer.parseInt(args[1]);
			if(args.length==3)
				res[2] = Integer.parseInt(args[2]);
			else
				res[2] = 1;
			if(res[0]<1||res[0]>12) return null;
			if(res[1]<0) return null;
			if(res[2]<1||res[2]>7) return null;
		} catch (NumberFormatException e) {
			return null;
		}
		return res;
	}

}