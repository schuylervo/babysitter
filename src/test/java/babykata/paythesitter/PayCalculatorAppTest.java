package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorAppTest {

	PayCalculatorApp payCalculatorApp = new PayCalculatorApp();
	
	
	LocalTime time4pm = LocalTime.of(16, 0);
	LocalTime time6pm = LocalTime.of(18, 0);
	LocalTime time10pm = LocalTime.of(22, 0);
	LocalTime time1am = LocalTime.of(1, 0);
	LocalTime time4am = LocalTime.of(4, 0);
	LocalTime time5am = LocalTime.of(5, 0);
	
	
	@Test
	public void areTheStartingAndEndingTimeEntriesBetween5pmAnd4am() {
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(time6pm, time10pm));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(time6pm, time4am));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(time6pm, LocalTime.MIDNIGHT));
		assertEquals(true, PayCalculatorApp.isTimeEntryValid(time6pm, time4am));
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(time4pm, time4am)); 
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(time6pm, time5am )); 
		assertEquals(false, PayCalculatorApp.isTimeEntryValid(time4pm, time5am)); 
	}
	
}
