package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorTestFamilyC {

PayCalculatorFamilyC payCalculatorC = new PayCalculatorFamilyC();
	
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
	public void sameStartAndEndTimeBetween5pmAnd9pm() {
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(time5pm, time5pm));
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(time615pm, time615pm));
	}
	
	@Test
	public void wholeHoursWorkedBetween5pmAnd9pm() {
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(time5pm, time6pm));
		assertEquals(84, payCalculatorC.calcPayFromFamilyC(time5pm, time9pm));
	}
	
	@Test
	public void partialHoursWorkedBetween5pmAnd9pm() {
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(time5pm, time515pm));
		assertEquals(21, payCalculatorC.calcPayFromFamilyC(time515pm, time6pm));
		assertEquals(42, payCalculatorC.calcPayFromFamilyC(time545pm, time7pm));
		assertEquals(63, payCalculatorC.calcPayFromFamilyC(time615pm, time9pm));
	}
	
	@Test
	public void wholeHoursBetween9pmAndMidnight() {
		assertEquals(0, payCalculatorC.calcPayFromFamilyC(time915pm, time915pm));
		assertEquals(15, payCalculatorC.calcPayFromFamilyC(time9pm, time10pm));
		assertEquals(30, payCalculatorC.calcPayFromFamilyC(time915pm, time1115pm));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time9pm, midnight));
	}
	
	@Test
	public void partialHoursBetween9pmAndMidnight() {
		assertEquals(15, payCalculatorC.calcPayFromFamilyC(time9pm, time915pm));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time945pm, midnight));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time915pm, time1159pm));
	}
	
	
	@Test
	public void startTimesAfter9pmAndEndTimesBetweenMidnightAnd4am() {
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time915pm, time1207am));
		assertEquals(60, payCalculatorC.calcPayFromFamilyC(time9pm, time1207am));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time10pm, time1207am));
		assertEquals(45, payCalculatorC.calcPayFromFamilyC(time10pm, time1am));
		assertEquals(105, payCalculatorC.calcPayFromFamilyC(time915pm, time330am));
		assertEquals(75, payCalculatorC.calcPayFromFamilyC(time915pm, time2am));
		assertEquals(105, payCalculatorC.calcPayFromFamilyC(time9pm, time4am));
	}	
	@Test
	public void startTimesBetween5pmAnd9pmAndEndTimesBetweenMidnightAnd4am() {
		assertEquals(144, payCalculatorC.calcPayFromFamilyC(time5pm, time1207am));
		assertEquals(144, payCalculatorC.calcPayFromFamilyC(time515pm, time1207am));
		assertEquals(81, payCalculatorC.calcPayFromFamilyC(time845pm, time1207am));
		assertEquals(102, payCalculatorC.calcPayFromFamilyC(time7pm, time1am));
		assertEquals(168, payCalculatorC.calcPayFromFamilyC(time615pm, time330am));
		assertEquals(159, payCalculatorC.calcPayFromFamilyC(time547pm, time2am));
		assertEquals(189, payCalculatorC.calcPayFromFamilyC(time5pm, time4am));	
	}
	
}
