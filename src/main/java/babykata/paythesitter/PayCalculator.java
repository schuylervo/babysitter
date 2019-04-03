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
	
	public int payFromFamilyABetween11pmAnd4am(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
		}
		long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
		
		int hoursWorked = (int)longHoursWorked;
		int payRate = 20;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
}
