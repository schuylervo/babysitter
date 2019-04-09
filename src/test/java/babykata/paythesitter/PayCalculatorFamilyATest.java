package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorFamilyATest {
	
	PayCalculatorFamilyA payCalculatorA = new PayCalculatorFamilyA();
	
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
	public void Testing5pmTo11pmWageFunctionSameStartAndEndTimes() {
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time5pm, time5pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time7pm, time7pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time545pm, time545pm));
	}
	
	@Test
	public void Testing5pmTo11pmWageFunctionLessThanOneHourWorkedTotal() {
		assertEquals(15, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time5pm, time515pm));
		assertEquals(15, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time515pm, time545pm));
	}
	
	@Test
	public void Testing5pmTo11pmWageFunctionWholeHoursWorked() {
		assertEquals(30, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time6pm, time8pm));
		assertEquals(45, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time7pm, time10pm));
	}
	
	@Test
	public void Testing5pmto11pmWageFunctionFractionalHoursWorked() {
		assertEquals(30, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time545pm, time7pm));
		assertEquals(90, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time515pm, time11pm));
	}
	
	
	@Test
	public void Testing11pmTo4amWageFunctionStartTimesAfterMidnight () {
		
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, midnight));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1am, time156am));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, time1am));
		assertEquals(40, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, time156am));	
	}
	
	@Test
	public void Testing11pmTo4amWageFunctionStartTimesBeforeMidnight () {
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time11pm, midnight));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time1159pm));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, midnight));
		assertEquals(40, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time1am));
		assertEquals(60, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time156am));
		assertEquals(100, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time4am));
		assertEquals(100, payCalculatorA.payFromFamilyABetween11pmAnd4am(time11pm, time4am));
	}
	
	
	@Test
	public void StartingTimesAfter5pmAndEndTimesBeforeMidnight() {
		assertEquals(35, payCalculatorA.calcPayFromFamilyA(time1059pm, time1120pm));
		assertEquals(35, payCalculatorA.calcPayFromFamilyA(time1045pm, time1115pm));
		assertEquals(20, payCalculatorA.calcPayFromFamilyA(time1120pm, time1159pm));
		assertEquals(45, payCalculatorA.calcPayFromFamilyA(time845pm, time1059pm));
		assertEquals(90, payCalculatorA.calcPayFromFamilyA(time515pm, time11pm));
		assertEquals(110, payCalculatorA.calcPayFromFamilyA(time515pm, time1120pm));
		assertEquals(65, payCalculatorA.calcPayFromFamilyA(time845pm, time1159pm));
		
	}
	
	@Test
	public void StartTimesAfter5pmButBefore11pmAndEndTimesBefore11pm() {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(time515pm, time845pm));
		assertEquals(90, payCalculatorA.calcPayFromFamilyA(time515pm, time1042pm));
	}
	
	
	@Test
	public void StartTimesAfter5pmButBefore11pmAndEndTimesBetweenBetweenMidnightAnd4am() {
		assertEquals(130, payCalculatorA.calcPayFromFamilyA(time515pm, time1am));
		assertEquals(85, payCalculatorA.calcPayFromFamilyA(time845pm, time1am));
		assertEquals(105, payCalculatorA.calcPayFromFamilyA(time845pm, time156am));
		assertEquals(145, payCalculatorA.calcPayFromFamilyA(time845pm, time4am));
	}
	@Test
	public void StartTimesAfter11pmAndEndTimesBetweenBetweenMidnightAnd4am () {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(time1120pm, time156am));
		assertEquals(100, payCalculatorA.calcPayFromFamilyA(time1159pm, time4am));
	}
	@Test
	public void StartTimesAndEndTimesBetweenMidnightAnd4am () {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(time156am, time4am));
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(time1am, time330am));
	}
	
	
	
	
	
}    
    