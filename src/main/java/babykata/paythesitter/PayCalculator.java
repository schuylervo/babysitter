package babykata.paythesitter;


public class PayCalculator {
	
	
	public int payFromFamilyABetween5pmAnd11pm(int hoursWorked) {
		int payRate = 15;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
	
	public int payFromFamilyABetween11pmAnd4am(int hoursWorked) {
		int payRate = 20;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
}
