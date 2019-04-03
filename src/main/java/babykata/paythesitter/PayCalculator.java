package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculator {
	
	
	public int payFromFamilyABetween5pmAnd11pm(LocalTime startTime, LocalTime endTime) {
		long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
		int hoursWorked = (int)longHoursWorked;
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
