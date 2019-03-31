package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayCalculatorTest {
	@Test
	public void WhenSittingForFamilyABetween5pmAnd11pmPayIs15PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		assertEquals(0, payCalculator.payFromFamilyABetween5pmAnd11pm(0));
		assertEquals(15, payCalculator.payFromFamilyABetween5pmAnd11pm(1));
		assertEquals(30, payCalculator.payFromFamilyABetween5pmAnd11pm(2));
		assertEquals(45, payCalculator.payFromFamilyABetween5pmAnd11pm(3));
		assertEquals(90, payCalculator.payFromFamilyABetween5pmAnd11pm(6));
	}
	
	@Test
	public void WhenSittingForFamilyABetween11pmAnd4amPayIs20PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		assertEquals(0, payCalculator.payFromFamilyABetween11pmAnd4am(0));
		assertEquals(20, payCalculator.payFromFamilyABetween11pmAnd4am(1));
		assertEquals(40, payCalculator.payFromFamilyABetween11pmAnd4am(2));
		assertEquals(100, payCalculator.payFromFamilyABetween11pmAnd4am(5));
	}
}    
    