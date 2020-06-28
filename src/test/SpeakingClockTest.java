package test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;
import main.SpeakingClock;

public class SpeakingClockTest {
	
	@Test
	public void test_isTime_ok() throws ParseException {
		DateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		dateFormatter.parse("20:20");
	}

	@Test(expected = ParseException.class)
	public void test_isTime_wrongFormat() throws ParseException {
		DateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		dateFormatter.parse("20::20");
	}
	
	@Test(expected = ParseException.class)
	public void test_isTime_notNumbers() throws ParseException {
		DateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		dateFormatter.parse("aa:bb");
	}
	
	@Test
	public void test_convertHoursAndMinutes_ok() {
		assertEquals("It's twenty past eight p.m.", SpeakingClock.convertHoursAndMinutes(20, 20));
		assertEquals("It's Midnight", SpeakingClock.convertHoursAndMinutes(0, 0));
		assertEquals("It's Midday", SpeakingClock.convertHoursAndMinutes(12, 0));
		// TODO: check more cases
	}
	
	@Test
	public void test_convertTimeIntoWords_ok() throws Exception {
		assertEquals("It's twenty past eight p.m.", SpeakingClock.convertTimeIntoWords("20:20"));
		// TODO: check more cases
	}
	
	// Run out of time
	@Ignore
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test_convertTimeIntoWords_outOfBounds() throws Exception {
		
	}
	
	// Run out of time	
	@Ignore
	@Test(expected = NumberFormatException.class)
	public void test_convertTimeIntoWords_wrongNumberFormat() throws Exception {
		
	}
	
	// TODO: more test cases?
}
