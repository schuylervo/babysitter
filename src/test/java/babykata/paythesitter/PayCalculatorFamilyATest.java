package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorFamilyATest {
	
	PayCalculatorFamilyA payCalculatorA = new PayCalculatorFamilyA();
	

	
	@Test
	public void Testing5pmTo11pmWageFunctionSameStartAndEndTimes() {
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time5pm, LocalTimeConstants.time5pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time7pm, LocalTimeConstants.time7pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time545pm, LocalTimeConstants.time545pm));
	}
	
	@Test
	public void Testing5pmTo11pmWageFunctionLessThanOneHourWorkedTotal() {
		assertEquals(15, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time5pm, LocalTimeConstants.time515pm));
		assertEquals(15, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time515pm, LocalTimeConstants.time545pm));
	}
	
	@Test
	public void Testing5pmTo11pmWageFunctionWholeHoursWorked() {
		assertEquals(30, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time6pm, LocalTimeConstants.time8pm));
		assertEquals(45, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time7pm, LocalTimeConstants.time10pm));
	}
	
	@Test
	public void Testing5pmto11pmWageFunctionFractionalHoursWorked() {
		assertEquals(30, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time545pm, LocalTimeConstants.time7pm));
		assertEquals(90, payCalculatorA.payFromFamilyABetween5pmAnd11pm(LocalTimeConstants.time515pm, LocalTimeConstants.time11pm));
	}
	
	
	@Test
	public void Testing11pmTo4amWageFunctionStartTimesAfterMidnight () {
		
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTime.MIDNIGHT, LocalTime.MIDNIGHT));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1am, LocalTimeConstants.time156am));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTime.MIDNIGHT, LocalTimeConstants.time1am));
		assertEquals(40, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTime.MIDNIGHT, LocalTimeConstants.time156am));	
	}
	
	@Test
	public void Testing11pmTo4amWageFunctionStartTimesBeforeMidnight () {
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time11pm, LocalTime.MIDNIGHT));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1120pm, LocalTimeConstants.time1159pm));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1120pm, LocalTime.MIDNIGHT));
		assertEquals(40, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1120pm, LocalTimeConstants.time1am));
		assertEquals(60, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1120pm, LocalTimeConstants.time156am));
		assertEquals(100, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time1120pm, LocalTimeConstants.time4am));
		assertEquals(100, payCalculatorA.payFromFamilyABetween11pmAnd4am(LocalTimeConstants.time11pm, LocalTimeConstants.time4am));
	}
	
	
	@Test
	public void StartingTimesAfter5pmAndEndTimesBeforeMidnight() {
		assertEquals(35, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1059pm, LocalTimeConstants.time1120pm));
		assertEquals(35, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1045pm, LocalTimeConstants.time1115pm));
		assertEquals(20, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1120pm, LocalTimeConstants.time1159pm));
		assertEquals(45, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time845pm, LocalTimeConstants.time1059pm));
		assertEquals(90, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time515pm, LocalTimeConstants.time11pm));
		assertEquals(110, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time515pm, LocalTimeConstants.time1120pm));
		assertEquals(65, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time845pm, LocalTimeConstants.time1159pm));
		
	}
	
	@Test
	public void StartTimesAfter5pmButBefore11pmAndEndTimesBefore11pm() {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time515pm, LocalTimeConstants.time845pm));
		assertEquals(90, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time515pm, LocalTimeConstants.time1042pm));
	}
	
	
	@Test
	public void StartTimesAfter5pmButBefore11pmAndEndTimesBetweenBetweenMidnightAnd4am() {
		assertEquals(130, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time515pm, LocalTimeConstants.time1am));
		assertEquals(85, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time845pm, LocalTimeConstants.time1am));
		assertEquals(105, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time845pm, LocalTimeConstants.time156am));
		assertEquals(145, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time845pm, LocalTimeConstants.time4am));
	}
	@Test
	public void StartTimesAfter11pmAndEndTimesBetweenBetweenMidnightAnd4am () {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1120pm, LocalTimeConstants.time156am));
		assertEquals(100, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1159pm, LocalTimeConstants.time4am));
	}
	@Test
	public void StartTimesAndEndTimesBetweenMidnightAnd4am () {
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time156am, LocalTimeConstants.time4am));
		assertEquals(60, payCalculatorA.calcPayFromFamilyA(LocalTimeConstants.time1am, LocalTimeConstants.time330am));
	}
	
	
	
	
	
}    
    