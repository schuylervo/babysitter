package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Test;

public class PayCalculatorTestFamilyA {
	
	PayCalculatorFamilyA payCalculatorA = new PayCalculatorFamilyA();
	PayCalculatorFamilyB payCalculatorB = new PayCalculatorFamilyB();
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
	public void WhenSittingForFamilyABetween5pmAnd11pmPayIs15PerHour () {
		
		// test to ensure no payment is made if start and end times are the same 
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time5pm, time5pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time7pm, time7pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time545pm, time545pm));
		
		// less than one hour on the job should result in no pay
		assertEquals(0, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time5pm, time515pm));
		
		// test whole hours
		assertEquals(30, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time6pm, time8pm));
		assertEquals(45, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time7pm, time10pm));
		
		// test that fractional hours round down to nearest whole hour
		assertEquals(15, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time545pm, time7pm));
		assertEquals(75, payCalculatorA.payFromFamilyABetween5pmAnd11pm(time515pm, time11pm));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHourTestingStartTimesAfterMidnight () {
		
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, midnight));
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1am, time156am));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, time1am));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(midnight, time156am));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHourTestingStartTimesBeforeMidnight () {
		
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time11pm, midnight));
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time1159pm));
		assertEquals(0, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, midnight));
		assertEquals(20, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time1am));
		assertEquals(40, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time156am));
		assertEquals(80, payCalculatorA.payFromFamilyABetween11pmAnd4am(time1120pm, time4am));
		assertEquals(100, payCalculatorA.payFromFamilyABetween11pmAnd4am(time11pm, time4am));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween5pmAnd4amPayIs15PerHourUntil11pmAnd20PerHourThereafterTestTimesStartingAfter5pmAndFinishingBeforeMidnight () {
		
		// test times before starting after 5pm and finishing before midnight
		
		assertEquals("Invalid time entry. Please enter start time between 5pm and 4am.", payCalculatorA.calcPayFromFamilyA(time10am, time1120pm));
		assertEquals("Invalid time entry. Please enter end time between 5pm and 4am.", payCalculatorA.calcPayFromFamilyA(time1059pm, time10am));
		assertEquals(0, payCalculatorA.calcPayFromFamilyA(time1059pm, time1120pm));
		assertEquals(0, payCalculatorA.calcPayFromFamilyA(time1120pm, time1159pm));
		assertEquals(30, payCalculatorA.calcPayFromFamilyA(time845pm, time1059pm));
		assertEquals(75, payCalculatorA.calcPayFromFamilyA(time515pm, time11pm));
		assertEquals(75, payCalculatorA.calcPayFromFamilyA(time515pm, time1120pm));
		
	}
	
	@Test
	public void WhenSittingForFamilyABetween5pmAnd4amPayIs15PerHourUntil11pmAnd20PerHourThereafterTestTimesStartingAfter5pmAndFinishingAfterMidnight () {
		
		
		//test start times after 5pm but before 11pm and end times before 11pm
		assertEquals(45, payCalculatorA.calcPayFromFamilyA(time515pm, time845pm));
		assertEquals(75, payCalculatorA.calcPayFromFamilyA(time515pm, time1042pm));
		
		// test start times after 5pm but before and end times between 11pm and midnight
		// scenario where babysitter spends X hours on job, but should only be paid for X-1 hours because only worked a partial hour after 11pm
		assertEquals(75, payCalculatorA.calcPayFromFamilyA(time515pm, time1120pm));
		assertEquals(30, payCalculatorA.calcPayFromFamilyA(time845pm, time1159pm));
		
		// test start times after 5pm and before 11pm but end times after midnight (mixed pay rates of 15 and 20 per hour)
		assertEquals(115, payCalculatorA.calcPayFromFamilyA(time515pm, time1am));
		assertEquals(70, payCalculatorA.calcPayFromFamilyA(time845pm, time1am));
		assertEquals(70, payCalculatorA.calcPayFromFamilyA(time845pm, time156am));
		assertEquals(130, payCalculatorA.calcPayFromFamilyA(time845pm, time4am));
		
		// test start times after 11pm but end times after midnight 
		assertEquals(40, payCalculatorA.calcPayFromFamilyA(time1120pm, time156am));
		assertEquals(80, payCalculatorA.calcPayFromFamilyA(time1159pm, time4am));
		
		// test start times and end times both after midnight
		assertEquals(40, payCalculatorA.calcPayFromFamilyA(time156am, time4am));
		assertEquals(40, payCalculatorA.calcPayFromFamilyA(time1am, time330am));
	}
	
	
	
	
	
}    
    