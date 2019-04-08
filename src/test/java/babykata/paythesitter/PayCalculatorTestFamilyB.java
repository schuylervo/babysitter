package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorTestFamilyB {

PayCalculatorFamilyB payCalculatorB = new PayCalculatorFamilyB();
	
	LocalTime time10am = LocalTime.of(10, 0);
	LocalTime time5pm = LocalTime.of(17, 0);
	LocalTime time515pm = LocalTime.of(17, 15);
	LocalTime time545pm = LocalTime.of(17, 45);
	LocalTime time547pm = LocalTime.of(17, 45);
	LocalTime time6pm = LocalTime.of(18, 0);
	LocalTime time615pm = LocalTime.of(18, 15);
	LocalTime time7pm = LocalTime.of(19, 0);
	LocalTime time8pm = LocalTime.of(20, 0);
	LocalTime time845pm = LocalTime.of(20, 45);
	LocalTime time9pm = LocalTime.of(21, 0);
	LocalTime time915pm = LocalTime.of(21, 15);
	LocalTime time945pm = LocalTime.of(21, 45);
	LocalTime time953pm = LocalTime.of(21, 53);
	LocalTime time10pm = LocalTime.of(22, 0);
	LocalTime time1015pm = LocalTime.of(22, 15);
	LocalTime time1042pm = LocalTime.of(22, 42);
	LocalTime time1045pm = LocalTime.of(22, 45);
	LocalTime time1059pm = LocalTime.of(22, 59);
	LocalTime time11pm = LocalTime.of(23, 0);
	LocalTime time1115pm = LocalTime.of(23, 15);
	LocalTime time1120pm = LocalTime.of(23, 20);
	LocalTime time1159pm = LocalTime.of(23, 59);
	LocalTime midnight = LocalTime.MIDNIGHT;
	LocalTime time1207am = LocalTime.of(0, 7);
	LocalTime time1am = LocalTime.of(1, 0);
	LocalTime time156am = LocalTime.of(1, 56);
	LocalTime time107am = LocalTime.of(1, 07);
	LocalTime time2am = LocalTime.of(2, 0);
	LocalTime time330am = LocalTime.of(3, 30);
	LocalTime time4am = LocalTime.of(4, 0);
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time515pm, time515pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time7pm, time7pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time10pm, time10pm));
	}	
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmWholeHours() {
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(time5pm, time6pm));
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(time515pm, time615pm));
		assertEquals(24, payCalculatorB.calcPayFromFamilyB(time5pm, time7pm));
		assertEquals(36, payCalculatorB.calcPayFromFamilyB(time545pm, time845pm));
		assertEquals(60, payCalculatorB.calcPayFromFamilyB(time5pm, time10pm));
	}
	
	@Test
	public void startTimesAndEndTimesBetween5pmAnd10pmPartialHours() {
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(time5pm, time515pm));
		assertEquals(12, payCalculatorB.calcPayFromFamilyB(time5pm, time545pm));
		assertEquals(24, payCalculatorB.calcPayFromFamilyB(time845pm, time10pm));
		assertEquals(36, payCalculatorB.calcPayFromFamilyB(time6pm, time845pm));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(time515pm, time845pm));	
	}
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time1015pm, time1015pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time11pm, time11pm));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time1159pm, time1159pm));
	}
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightWholeHours() {	
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(time10pm, time11pm));
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(time11pm, midnight));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time10pm, midnight));
	}	
	
	@Test
	public void startTimesAndEndTimesBetween10pmAndMidnightPartialHours() {
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(time10pm, time1045pm));
		assertEquals(8, payCalculatorB.calcPayFromFamilyB(time1045pm, time1115pm));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time10pm, time1159pm));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time1045pm, midnight));
	}
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amAreTheSame() {
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(midnight, midnight));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time1am, time1am));
		assertEquals(0, payCalculatorB.calcPayFromFamilyB(time330am, time330am));
	}
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amWholeHours() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(midnight, time1am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time1207am, time107am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(midnight, time2am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(midnight, time4am));
	}	
	
	@Test
	public void startTimesAndEndTimesBetweenMidnightAnd4amPartialHours() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(midnight, time1207am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time107am, time2am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(time1207am, time2am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(time1am, time330am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(time1207am, time4am));	
	}
	
	@Test
	public void startTimesBetween5pmAnd10pmAndEndTimesBetween10pmAndMidnight() {
		assertEquals(28, payCalculatorB.calcPayFromFamilyB(time953pm, time1159pm));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(time845pm, time11pm));
		assertEquals(56, payCalculatorB.calcPayFromFamilyB(time615pm, time1045pm));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(time615pm, time1115pm));
		assertEquals(68, payCalculatorB.calcPayFromFamilyB(time545pm, time11pm));
		assertEquals(76, payCalculatorB.calcPayFromFamilyB(time5pm, midnight));	
	}
	
	@Test
	public void startTimesBetween5pmAnd10pmAndEndTimesBetweenMidnightAnd4am() {  
		assertEquals(44, payCalculatorB.calcPayFromFamilyB(time953pm, time1207am));
		assertEquals(56, payCalculatorB.calcPayFromFamilyB(time845pm, time1am));
		assertEquals(96, payCalculatorB.calcPayFromFamilyB(time615pm, time2am));
		assertEquals(128, payCalculatorB.calcPayFromFamilyB(time615pm, time330am));
		assertEquals(140, payCalculatorB.calcPayFromFamilyB(time545pm, time4am));
		assertEquals(140, payCalculatorB.calcPayFromFamilyB(time5pm, time4am));	
	}
	
	@Test
	public void startTimesBetween10pmAndMidnightAndEndTimesBetweenMidnightAnd4am() { 
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(time1045pm, time1207am));
		assertEquals(32, payCalculatorB.calcPayFromFamilyB(time1045pm, time1am));
		assertEquals(40, payCalculatorB.calcPayFromFamilyB(time11pm, time2am));
		assertEquals(80, payCalculatorB.calcPayFromFamilyB(time10pm, time330am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(midnight, time4am));
		assertEquals(80, payCalculatorB.calcPayFromFamilyB(time10pm, time4am));
	}	
	
	@Test
	public void startTimesBetweenMidnightAnd4am() {
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(midnight, time1207am));
		assertEquals(16, payCalculatorB.calcPayFromFamilyB(time1am, time2am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(time1am, time330am));
		assertEquals(48, payCalculatorB.calcPayFromFamilyB(time1am, time4am));
		assertEquals(64, payCalculatorB.calcPayFromFamilyB(midnight, time4am));
	}

	
}
