package babykata.paythesitter;


public class PayCalculator {
	
	public int payFromFamilyABetween5pmAnd11pm(int startTime, int endTime) {
		int hoursWorked = endTime - startTime;
		int payRate = 15;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
	
	public int payFromFamilyABetween11pmAnd4am(int startTime, int endTime) {
		if (startTime <=4) {
			startTime += 12;
		}
		if (endTime <=4) {
			endTime += 12;
		}
		int hoursWorked = endTime - startTime;
		int payRate = 20;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
}
