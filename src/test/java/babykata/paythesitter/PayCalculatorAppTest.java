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
	
	
	
}
