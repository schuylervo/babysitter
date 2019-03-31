package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayCalculatorTest {
	@Test
	public void WhenSittingForFamilyABetween5pmAnd11pmPayIs15PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(5, 5));
		assertEquals(15, payCalculator.payFromFamilyABetween5pmAnd11pm(6, 7));
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd11pm(8, 10));
		assertEquals(45, payCalculator.payFromFamilyABetween5pmAnd11pm(7, 10));
		assertEquals(90, payCalculator.payFromFamilyABetween5pmAnd11pm(5, 11));
	}
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(2, 2));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(11, 12));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(12, 1));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(1, 2));
		assertEquals(40, payCalculator.payFromFamilyABetween11pmAnd4am(12, 2));
		assertEquals(100, payCalculator.payFromFamilyABetween11pmAnd4am(11,4));
	}
	
	
}    
    