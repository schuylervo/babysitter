package babykata.paythesitter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PayCalculatorTest {
	@Test
	public void WhenSittingForFamilyABefore11PayIs15PerHour () {
		PayCalculator payCalculator = new PayCalculator();
		assertEquals(15, payCalculator.pay(1));
	}
}    
    