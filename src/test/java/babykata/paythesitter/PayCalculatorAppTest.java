package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorAppTest {

	PayCalculatorApp payCalculatorApp = new PayCalculatorApp();
	
	
	
	@Test
	public void areTheStartingAndEndingTimeEntriesBetween5pmAnd4am() {
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time6pm, LocalTimeConstants.time10pm));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time6pm, LocalTimeConstants.time4am));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time6pm, LocalTime.MIDNIGHT));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time6pm, LocalTimeConstants.time4am));
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time4pm, LocalTimeConstants.time4am)); 
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time6pm, LocalTimeConstants.time5am )); 
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(LocalTimeConstants.time4pm, LocalTimeConstants.time5am)); 
	}
	
	@Test
	public void doesTheSubstringMethodReturnTheUsersTimeStringWithoutAMorPM() {
		assertEquals("6:06", PayCalculatorApp.getTimeSubstring("6:06pm"));
		assertEquals("10:12", PayCalculatorApp.getTimeSubstring("10:12 pm"));
		assertEquals("3:12", PayCalculatorApp.getTimeSubstring("3:12 am"));
		assertEquals("7:48", PayCalculatorApp.getTimeSubstring("7:48am"));
		assertEquals("11:35", PayCalculatorApp.getTimeSubstring("11:35 p"));
		assertEquals("12:56", PayCalculatorApp.getTimeSubstring("12:56a"));
	}
	
	
	
}
