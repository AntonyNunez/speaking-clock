package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SpeakingClock {
	
	private static final String IT_IS = "It's ";
	private static final String BLANK_SPACE = " ";
	private static final String PAST = " past ";
	private static final String TO = " to ";
	private static final String AM = " a.m.";
	private static final String PM = " p.m.";
	private static final String MIDNIGHT = "It's Midnight";
	private static final String MIDDAY = "It's Midday";
	private static final String QUARTER = "quarter";

	public static void main(String[] args) {
		System.out.println("Time: " + args[0]);
		String time = args[0];
        try {
			timeIntoWords(time);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
	}
	
	private static String timeIntoWords(String time) throws Exception {
		// Check if the value is actually an hour.
		isTime(time);
		
		return convertTimeIntoWords(time);
	}
	
	public static void isTime(String time) {
		DateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		try {
			dateFormatter.parse(time);
		} catch(ParseException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(time + " is not a time. Introduce the time in hh:mm format with numbers only.");
		}
	}
	
	public static String convertTimeIntoWords(String time) throws Exception {
		String result = null;
		// Split the time into an array of [hours, minutes].
		String[] splittedTime = time.split(":");
		String sHours = null;
		String sMinutes = null;
		Integer hours = null;
		Integer minutes = null;
		
		try {
			// Keep the hours and minutes in separate variables avoiding crashes.
			sHours = splittedTime[0];
			sMinutes = splittedTime[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println(time + " is not complete. Introduce valid hours and minutes.");
		}
		
		try {
			// Parse the String values to Integers to start the calculations.
			hours = Integer.parseInt(sHours);
			minutes = Integer.parseInt(sMinutes);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Could not parse to Integer. Make sure to use numbers.");
		}
		
		// Proceed only if the splitted time has a length of 2 and if hours and minutes have 2 digits -> requested format.
		if (splittedTime.length == 2 && sHours.length() == 2 && sMinutes .length() == 2) {
			// Proceed only if the hours and minutes range is possible (0 <= hours < 24, 0 <= minutes < 60).
			if ((hours >= 0 && hours < 24) && (minutes >= 0 && minutes < 60)) {
				// Once we checked the input is correct, we can convert the time into words.
				result = convertHoursAndMinutes(hours, minutes);
			} else {
				throw new Exception("The range of hours or minutes is wrong.");
			}
		} else {
			throw new Exception(time + " is in the wrong format. Introduce the time in hh:mm format.");
		}
		return result;
	}
	
	public static String convertHoursAndMinutes(Integer hours, Integer minutes) {
		String result = null;
		String sHours = null;
		String sMinutes = null;
		String dayTime = AM;
		// Array of basic numbers. Note that the first position is "twelve": position 12 - 12 = 0 -> "twelve"
		String[] basic = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", 
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		// Array for tens, avoiding first and second positions: position 2 -> 20; position 3 -> 30; ...
		String[] tens = {"void", "void", "twenty", "thirty", "forty", "fifty"};
		
		if (hours == 0 && minutes == 0) {
			// Midnight case
			result = MIDNIGHT;
		} else if (hours == 12 && minutes == 0) {
			// Midday case
			result = MIDDAY;
		} else {
			if (hours >= 12) {
				// Set the day time depending on the hour.
				dayTime = PM;
				// Hours in a range of 1 to 12 with a.m. and p.m.
				if (minutes == 45) {
					sHours = basic[hours - 11];
				} else {
					sHours = basic[hours - 12];
				}
			} else {
				if (minutes == 45) {
					sHours = basic[hours + 1];
				} else {
					sHours = basic[hours];
				}
			}
			
			if (minutes >= 20) {
				// We get the first number of the minutes and we use the tens array only for twenty, thirty, forty and fifty.
				sMinutes = tens[((minutes / 10))];
				if (minutes % 10 != 0) {
					// We use the module of the minutes to get the second number.
					sMinutes = sMinutes.concat(" " + basic[minutes % 10]);
				}
			} else {
				// Basic minutes from 1 to 19.
				sMinutes = basic[minutes];
			}
			
			// Different messages depending on the minutes.
			if (minutes < 30) {
				if (minutes == 15) {
					sMinutes = QUARTER;
				}
				result = IT_IS + sMinutes + PAST + sHours + dayTime;
			} else if (minutes == 45) {
				result = IT_IS + QUARTER + TO + sHours + dayTime;
			} else {
				result = IT_IS + sHours + BLANK_SPACE + sMinutes + dayTime;
			}
		}
		
		System.out.println(result);
		return result;
	}
}
