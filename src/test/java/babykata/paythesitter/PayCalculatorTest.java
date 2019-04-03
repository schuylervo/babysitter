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
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time5pm, time5pm));
		// less than one hour on the job should resolve to no pay
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(time5pm, time515pm));
		assertEquals(15, payCalculator.payFromFamilyABetween5pmAnd11pm(time545pm, time7pm));
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd11pm(time6pm, time8pm));
		assertEquals(45, payCalculator.payFromFamilyABetween5pmAnd11pm(time7pm, time10pm));
		// 5 hours and 45 minutes on the job should resolve to 5 hours of pay
		assertEquals(75, payCalculator.payFromFamilyABetween5pmAnd11pm(time515pm, time11pm));
		
	}
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		
		LocalTime time11pm = LocalTime.of(23, 0, 0);
		LocalTime time1120pm = LocalTime.of(23, 20, 0);
		LocalTime time1159pm = LocalTime.of(23, 59, 0);
		LocalTime midnight = LocalTime.of(0, 0, 0);
		LocalTime time1am = LocalTime.of(1, 0, 0);
		LocalTime time156am = LocalTime.of(1, 56, 0);
		LocalTime time4am = LocalTime.of(4, 0, 0);
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, midnight));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time1159pm));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(time11pm, midnight));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, midnight));
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(time1am, time156am));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, time1am));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(midnight, time156am));
		assertEquals(40, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time156am));
		assertEquals(80, payCalculator.payFromFamilyABetween11pmAnd4am(time1120pm, time4am));
		assertEquals(100, payCalculator.payFromFamilyABetween11pmAnd4am(time11pm, time4am));
		
	}
	
	
}    
    