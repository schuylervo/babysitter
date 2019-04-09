package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorFamilyBTest {

PayCalculatorFamilyB payCalculatorB = new PayCalculatorFamilyB();
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time515pm, LocalTimeConstants.time515pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time7pm, LocalTimeConstants.time7pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time10pm));
	}	
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmWholeHours() {
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time6pm));
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time515pm, LocalTimeConstants.time615pm));
		assertEquals(24, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time7pm));
		assertEquals(36, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time545pm, LocalTimeConstants.time845pm));
		assertEquals(60, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time10pm));
	}
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmPartialHours() {
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time515pm));
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time545pm));
		assertEquals(24, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time845pm, LocalTimeConstants.time10pm));
		assertEquals(36, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time6pm, LocalTimeConstants.time845pm));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time515pm, LocalTimeConstants.time845pm));	
	}
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1015pm, LocalTimeConstants.time1015pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time11pm, LocalTimeConstants.time11pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1159pm, LocalTimeConstants.time1159pm));
	}
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightWholeHours() {	
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time11pm));
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time11pm, LocalTime.MIDNIGHT));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTime.MIDNIGHT));
	}	
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightPartialHours() {
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time1045pm));
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1045pm, LocalTimeConstants.time1115pm));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time1159pm));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1045pm, LocalTime.MIDNIGHT));
	}
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTime.MIDNIGHT));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1am, LocalTimeConstants.time1am));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time330am, LocalTimeConstants.time330am));
	}
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amWholeHours() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time1am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1207am, LocalTimeConstants.time107am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time2am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time4am));
	}	
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amPartialHours() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time1207am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time107am, LocalTimeConstants.time2am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1207am, LocalTimeConstants.time2am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1am, LocalTimeConstants.time330am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1207am, LocalTimeConstants.time4am));	
	}
	
	@Test
	public void startTimesBetween5pmAnd10pmAndEndTimesBetween10pmAndMidnight() {
		assertEquals(28, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time953pm, LocalTimeConstants.time1159pm));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time845pm, LocalTimeConstants.time11pm));
		assertEquals(56, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time615pm, LocalTimeConstants.time1045pm));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time615pm, LocalTimeConstants.time1115pm));
		assertEquals(68, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time545pm, LocalTimeConstants.time11pm));
		assertEquals(76, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTime.MIDNIGHT));	
	}
	
	@Test
	public void startTimesBetween5pmAnd10pmAndEndTimesBetweenMidnightAnd4am() {  
		assertEquals(44, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time953pm, LocalTimeConstants.time1207am));
		assertEquals(56, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time845pm, LocalTimeConstants.time1am));
		assertEquals(96, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time615pm, LocalTimeConstants.time2am));
		assertEquals(128, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time615pm, LocalTimeConstants.time330am));
		assertEquals(140, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time545pm, LocalTimeConstants.time4am));
		assertEquals(140, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time5pm, LocalTimeConstants.time4am));	
	}
	
	@Test
	public void startTimesBetween10pmAndMidnightAndEndTimesBetweenMidnightAnd4am() { 
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1045pm, LocalTimeConstants.time1207am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1045pm, LocalTimeConstants.time1am));
		assertEquals(40, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time11pm, LocalTimeConstants.time2am));
		assertEquals(80, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time330am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time4am));
		assertEquals(80, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time10pm, LocalTimeConstants.time4am));
	}	
	
	@Test
	public void startTimesBetweenMidnightAnd4am() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time1207am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1am, LocalTimeConstants.time2am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1am, LocalTimeConstants.time330am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(LocalTimeConstants.time1am, LocalTimeConstants.time4am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(LocalTime.MIDNIGHT, LocalTimeConstants.time4am));
	}

	
}
