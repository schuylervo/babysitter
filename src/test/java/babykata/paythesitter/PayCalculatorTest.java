package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class PayCalculatorTest {
	@Test
	public void WhenSittingForFamilyABetween5pmAnd11pmPayIs15PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		LocalTime time5pm = LocalTime.of(17, 0, 0);
		LocalTime time515pm = LocalTime.of(17, 15, 0);
		LocalTime time545pm = LocalTime.of(17, 45, 0);
		LocalTime time6pm = LocalTime.of(18, 0, 0);
		LocalTime time7pm = LocalTime.of(19, 0, 0);
		LocalTime time8pm = LocalTime.of(20, 0, 0);
		LocalTime time10pm = LocalTime.of(22, 0, 0);
		LocalTime time11pm = LocalTime.of(23, 0, 0);
		
		// test to ensure no payment is made if start and end times are the same 
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time5pm, time5pm));
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time7pm, time7pm));
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time545pm, time545pm));
		
		// less than one hour on the job should result in no pay
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time5pm, time515pm));
		
		// test whole hours
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd11pm(time6pm, time8pm));
		assertEquals(45, payCalculator.payFromFamilyABetween5pmAnd11pm(time7pm, time10pm));
		
		// test that fractional hours round down to nearest whole hour
		assertEquals(15, payCalculator.payFromFamilyABetween5pmAnd11pm(time545pm, time7pm));
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd11pm(time515pm, time11pm));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHourTestingStartTimesAfterMidnight () {
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime midnight = LocalTime.of(0, 0, 0);
		LocalTime time1am = LocalTime.of(1, 0, 0);
		LocalTime time156am = LocalTime.of(1, 56, 0);
		
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, midnight));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1am, time156am));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, time1am));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, time156am));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHourTestingStartTimesBeforeMidnight () {
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime time11pm = LocalTime.of(23, 0, 0);
		LocalTime time1120pm = LocalTime.of(23, 20, 0);
		LocalTime time1159pm = LocalTime.of(23, 59, 0);
		LocalTime midnight = LocalTime.of(0, 0, 0);
		LocalTime time1am = LocalTime.of(1, 0, 0);
		LocalTime time156am = LocalTime.of(1, 56, 0);
		LocalTime time4am = LocalTime.of(4, 0, 0);
		
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(time11pm, midnight));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time1159pm));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, midnight));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time1am));
		assertEquals(40, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time156am));
		assertEquals(80, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time4am));
		assertEquals(100, payCalculator.payFromFamilyABetween11pmAnd4am(time11pm, time4am));
		
	}
	
	
	@Test
	public void WhenSittingForFamilyABetween5pmAnd4amPayIs15PerHourUntil11pmAnd20PerHourThereafterTestTimesStartingAfter5pmAndFinishingBeforeMidnight () {
		
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime time515pm = LocalTime.of(17, 15, 0);
		LocalTime time845pm = LocalTime.of(20, 45, 0);
		LocalTime time1059pm = LocalTime.of(22, 59, 0);
		LocalTime time11pm = LocalTime.of(23, 0, 0);
		LocalTime time1120pm = LocalTime.of(23, 20, 0);
		LocalTime time1159pm = LocalTime.of(23, 59, 0);
		
		// test times before starting after 5pm and finishing before midnight
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd4am(time1059pm, time1120pm));
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd4am(time1120pm, time1159pm));
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd4am(time845pm, time1059pm));
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time11pm));
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time1120pm));
		
	}
	
	@Test
	public void WhenSittingForFamilyABetween5pmAnd4amPayIs15PerHourUntil11pmAnd20PerHourThereafterTestTimesStartingAfter5pmAndFinishingAfterMidnight () {
		// test times starting on or after 5pm and finishing after midnight
		
		PayCalculator payCalculator = new PayCalculator();
		LocalTime time515pm = LocalTime.of(17, 15, 0);
		LocalTime time845pm = LocalTime.of(20, 45, 0);
		LocalTime time1042pm = LocalTime.of(22, 42, 0);
		LocalTime time1120pm = LocalTime.of(23, 20, 0);
		LocalTime time1159pm = LocalTime.of(23, 59, 0);
		LocalTime time1am = LocalTime.of(1, 0, 0);
		LocalTime time156am = LocalTime.of(1, 56, 0);
		LocalTime time330am = LocalTime.of(3, 30, 0);
		LocalTime time4am = LocalTime.of(4, 0, 0);
		
		//test start times after 5pm but before 11pm and end times before 11pm
		assertEquals(45, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time845pm));
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time1042pm));
		
		// test start times after 5pm but before and end times between 11pm and midnight
		// scenario where babysitter spends X hours on job, but should only be paid for X-1 hours because only worked a partial hour after 11pm
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time1120pm));
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd4am(time845pm, time1159pm));
		
		// test start times after 5pm and before 11pm but end times after midnight (mixed pay rates of 15 and 20 per hour)
		assertEquals(115, payCalculator.payFromFamilyABetween5pmAnd4am(time515pm, time1am));
		assertEquals(70, payCalculator.payFromFamilyABetween5pmAnd4am(time845pm, time1am));
		assertEquals(70, payCalculator.payFromFamilyABetween5pmAnd4am(time845pm, time156am));
		assertEquals(130, payCalculator.payFromFamilyABetween5pmAnd4am(time845pm, time4am));
		
		// test start times after 11pm but end times after midnight 
		assertEquals(40, payCalculator.payFromFamilyABetween5pmAnd4am(time1120pm, time156am));
		assertEquals(80, payCalculator.payFromFamilyABetween5pmAnd4am(time1159pm, time4am));
		
		// test start times and end times both after midnight
		assertEquals(40, payCalculator.payFromFamilyABetween5pmAnd4am(time156am, time4am));
		assertEquals(40, payCalculator.payFromFamilyABetween5pmAnd4am(time1am, time330am));
	}
	
	@Test
	public void WhenSittingForFamilyBBetween5pmAnd10pmPayIs12PerHour() {
		//test times starting on or after 5pm and finishing on or before 10pm
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime time5pm = LocalTime.of(17, 0, 0);
		LocalTime time515pm = LocalTime.of(17, 15, 0);
		LocalTime time545pm = LocalTime.of(17, 45, 0);
		LocalTime time6pm = LocalTime.of(18, 0, 0);
		LocalTime time615pm = LocalTime.of(18, 15, 0);
		LocalTime time7pm = LocalTime.of(19, 0, 0);
		LocalTime time845pm = LocalTime.of(20, 45, 0);
		LocalTime time10pm = LocalTime.of(22, 0, 0);
		
		// test that same start and end times result in no pay
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time515pm, time515pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time7pm, time7pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time10pm, time10pm));
		
		// test whole hours		
		assertEquals(12, payCalculator.payFromFamilyBBetween5pmAnd4am(time5pm, time6pm));
		assertEquals(12, payCalculator.payFromFamilyBBetween5pmAnd4am(time515pm, time615pm));
		assertEquals(24, payCalculator.payFromFamilyBBetween5pmAnd4am(time5pm, time7pm));
		assertEquals(36, payCalculator.payFromFamilyBBetween5pmAnd4am(time545pm, time845pm));
		assertEquals(60, payCalculator.payFromFamilyBBetween5pmAnd4am(time5pm, time10pm));
		
		// test fractional hours
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time5pm, time515pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time5pm, time545pm));
		assertEquals(12, payCalculator.payFromFamilyBBetween5pmAnd4am(time845pm, time10pm));
		assertEquals(24, payCalculator.payFromFamilyBBetween5pmAnd4am(time6pm, time845pm));
		assertEquals(36, payCalculator.payFromFamilyBBetween5pmAnd4am(time515pm, time845pm));
		
	}
	
	@Test
	public void WhenSittingForFamilyBBetween10pmAndMidnightPayIs8PerHour() {
		
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime time10pm = LocalTime.of(22, 0);
		LocalTime time1015pm = LocalTime.of(22, 15);
		LocalTime time1045pm = LocalTime.of(22, 45);
		LocalTime time11pm = LocalTime.of(23, 0);
		LocalTime time1115pm = LocalTime.of(23, 15);
		LocalTime time1159pm = LocalTime.of(23, 59);
		LocalTime midnight = LocalTime.MIDNIGHT;
		
		// test that same start and end times result in no pay
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time1015pm, time1015pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time11pm, time11pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time1159pm, time1159pm));
		
		// test whole hours, which result in payment of $8 for one hour or $16 if worked between 10pm and midnight	
		assertEquals(8, payCalculator.payFromFamilyBBetween5pmAnd4am(time10pm, time11pm));
		assertEquals(8, payCalculator.payFromFamilyBBetween5pmAnd4am(time11pm, midnight));
		assertEquals(16, payCalculator.payFromFamilyBBetween5pmAnd4am(time10pm, midnight));
		
		// test partial hours
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time10pm, time1045pm));
		assertEquals(0, payCalculator.payFromFamilyBBetween5pmAnd4am(time1045pm, time1115pm));
		assertEquals(8, payCalculator.payFromFamilyBBetween5pmAnd4am(time10pm, time1159pm));
		assertEquals(8, payCalculator.payFromFamilyBBetween5pmAnd4am(time1045pm, midnight));
		
		
	}
	
	
}    
    