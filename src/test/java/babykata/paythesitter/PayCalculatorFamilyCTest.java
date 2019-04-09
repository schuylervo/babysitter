package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorFamilyCTest {

PayCalculatorFamilyC payCalculatorC = new PayCalculatorFamilyC();
	
	
	@Test
	public void sameStartAndEndTimeBetween5pmAnd9pm() {
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time5pm));
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time615pm, LocalTimeConstants.time615pm));
	}
	
	@Test
	public void wholeHoursWorkedBetween5pmAnd9pm() {
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time6pm));
		assertEquals(84, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time9pm));
	}
	
	@Test
	public void partialHoursWorkedBetween5pmAnd9pm() {
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time515pm));
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time515pm, LocalTimeConstants.time6pm));
		assertEquals(42, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time545pm, LocalTimeConstants.time7pm));
		assertEquals(63, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time615pm, LocalTimeConstants.time9pm));
	}
	
	@Test
	public void wholeHoursBetween9pmAndMidnight() {
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time915pm));
		assertEquals(15, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time9pm, LocalTimeConstants.time10pm));
		assertEquals(30, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time1115pm));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time9pm, LocalTime.MIDNIGHT));
	}
	
	@Test
	public void partialHoursBetween9pmAndMidnight() {
		assertEquals(15, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time9pm, LocalTimeConstants.time915pm));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time945pm, LocalTime.MIDNIGHT));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time1159pm));
	}
	
	
	@Test
	public void startTimesAfter9pmAndEndTimesBetweenMidnightAnd4am() {
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time1207am));
		assertEquals(60, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time9pm, LocalTimeConstants.time1207am));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time10pm, LocalTimeConstants.time1207am));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time10pm, LocalTimeConstants.time1am));
		assertEquals(105, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time330am));
		assertEquals(75, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time915pm, LocalTimeConstants.time2am));
		assertEquals(105, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time9pm, LocalTimeConstants.time4am));
	}	
	
	@Test
	public void startTimesBetween5pmAnd9pmAndEndTimesBetweenMidnightAnd4am() {
		assertEquals(144, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time1207am));
		assertEquals(144, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time515pm, LocalTimeConstants.time1207am));
		assertEquals(81, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time845pm, LocalTimeConstants.time1207am));
		assertEquals(102, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time7pm, LocalTimeConstants.time1am));
		assertEquals(168, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time615pm, LocalTimeConstants.time330am));
		assertEquals(159, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time547pm, LocalTimeConstants.time2am));
		assertEquals(189, payCalculatorC.calcPayFromFamilyC(LocalTimeConstants.time5pm, LocalTimeConstants.time4am));	
	}
	
}
