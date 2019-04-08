package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculatorFamilyC {

	public int calcPayFromFamilyC(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isAfter(LocalTime.of(16, 59, 59)) && (endTime.isBefore(LocalTime.of(21, 0)) || endTime.equals(LocalTime.of(21, 0))) ) {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 21;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else if (startTime.isAfter(LocalTime.of(20, 59, 59)) && (endTime.isAfter(LocalTime.of(21, 0)) || endTime.equals(LocalTime.MIDNIGHT))){
			
			if (endTime.equals(LocalTime.MIDNIGHT)) {
				startTime = startTime.minusHours(12);
				endTime = endTime.plusHours(12);
			}
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 15;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else if ((startTime.equals(LocalTime.of(21, 0)) || startTime.isAfter(LocalTime.of(21, 0))) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4,0)))){
			
			
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
			
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 15;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else if ((startTime.equals(LocalTime.of(17, 0)) || startTime.isAfter(LocalTime.of(17, 0))) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4,0)))){
		
			
			endTime = endTime.plusHours(12);
			LocalTime NineAtNight = LocalTime.of(21, 0);
			LocalTime NineInTheMorning = LocalTime.of(9, 0);
			
			long longHoursWorkedBetweenStartTimeAndNineAtNight = ChronoUnit.HOURS.between(startTime, NineAtNight);
			int hoursWorkedBetweenStartTimeAndNineAtNight = (int)longHoursWorkedBetweenStartTimeAndNineAtNight;
			int payRateBetweenStartTimeAndNineAtNight = 21;
			int wageEarnedBetweenStartTimeAndNineAtNight = payRateBetweenStartTimeAndNineAtNight * hoursWorkedBetweenStartTimeAndNineAtNight;
			
			long longHoursWorkedBetweenNineAtNightAndEndTimeAfterMidnight = ChronoUnit.HOURS.between(NineInTheMorning, endTime);
			int hoursWorkedBetweenNineAtNightAndEndTimeAfterMidnight = (int)longHoursWorkedBetweenNineAtNightAndEndTimeAfterMidnight;
			int payRateBetweenNineAtNightAndEndTimeAfterMidnight = 15;
			int wageEarnedBetweenNineAtNightAndEndTimeAfterMidnight = payRateBetweenNineAtNightAndEndTimeAfterMidnight * hoursWorkedBetweenNineAtNightAndEndTimeAfterMidnight;
			
			int wageEarned = wageEarnedBetweenStartTimeAndNineAtNight + wageEarnedBetweenNineAtNightAndEndTimeAfterMidnight; 
			
			
			return wageEarned;
	}
		
		else {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 21;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
		}
	}
	
}
