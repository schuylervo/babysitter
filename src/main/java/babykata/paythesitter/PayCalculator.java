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
		
		if (startTime.isAfter(LocalTime.of(22, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
		}
		long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
		
		int hoursWorked = (int)longHoursWorked;
		int payRate = 20;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
	
	public int payFromFamilyABetween5pmAnd4am(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isBefore(LocalTime.of(23, 0, 1)) && endTime.isAfter(LocalTime.of(16, 59, 59))) {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 15;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isAfter(LocalTime.of(23, 0, 0))) {	
			
			// note: this method will return wages earned between 5:00 p.m. and 11:00 p.m. in whole number increments
			// wages earned between 11pm and 11:59:59pm will be zero because it would be a fraction of an hour.
			LocalTime elevenOClock = LocalTime.of(23, 0, 0);
			long longHoursWorkedBeforeEleven = ChronoUnit.HOURS.between(startTime, elevenOClock);
			int hoursWorkedBeforeEleven = (int)longHoursWorkedBeforeEleven;
			int payRateBeforeEleven = 15;
			int wageEarnedBeforeEleven = payRateBeforeEleven * hoursWorkedBeforeEleven;
			
			return wageEarnedBeforeEleven;
			/* I wrote the code below, but then realized wages earned between 11pm and just before midnight will equate to zero because sitter worked less than one hr at this wage.
			long longHoursWorkedBetweenElevenAndMidnight = ChronoUnit.HOURS.between(elevenOClock, endTime);
			int hoursWorkedBetweenElevenAndMidnight = (int)longHoursWorkedBetweenElevenAndMidnight;
			int payRateBetweenElevenAndMidnight = 20;
			int wageEarnedBetweenElevenAndMidnight = payRateBetweenElevenAndMidnight * hoursWorkedBetweenElevenAndMidnight;
			
			return wageEarnedBeforeEleven + wageEarnedBetweenElevenAndMidnight;
			*/
			
		} else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			
			LocalTime elevenAtNight = LocalTime.of(23, 0, 0);
			
			if (startTime.isBefore(LocalTime.of(23, 0, 0))) {
			
			long longHoursWorkedBeforeEleven = ChronoUnit.HOURS.between(startTime, elevenAtNight);
			int hoursWorkedBeforeEleven = (int)longHoursWorkedBeforeEleven;
			int payRateBeforeEleven = 15;
			int wageEarnedBeforeEleven = payRateBeforeEleven * hoursWorkedBeforeEleven;
			
			LocalTime elevenInMorning = LocalTime.of(11, 0, 0);
			endTime = endTime.plusHours(12);
			long longHoursWorkedBetweenElevenAndEndTime = ChronoUnit.HOURS.between(elevenInMorning, endTime);
			int hoursWorkedBetweenElevenAndEndTime = (int)longHoursWorkedBetweenElevenAndEndTime;
			int payRateBetweenElevenAndEndTime = 20;
			int wageEarnedBetweenElevenAndEndTime = payRateBetweenElevenAndEndTime * hoursWorkedBetweenElevenAndEndTime;
			
			return wageEarnedBeforeEleven + wageEarnedBetweenElevenAndEndTime;
			}
			
			
			else {
				
				startTime = startTime.minusHours(12);
				endTime = endTime.plusHours(12);
				long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
				int hoursWorked = (int)longHoursWorked;
				int payRate = 20;
				int wageEarned = payRate * hoursWorked;
				
				return wageEarned;
			}
			
			
		} else if (startTime.isAfter(LocalTime.of(22, 59, 59)) && endTime.isBefore(LocalTime.of(23, 59, 59))) {
			// if startTime is after 11pm and endTime is before midnight, wage will be zero because hours worked is less than 1;
			
			return 0;
			
		} else if (startTime.isAfter(LocalTime.of(22, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 20;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 20;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
		}
		
	}
	
	public int payFromFamilyBBetween5pmAnd10pm(LocalTime startTime, LocalTime endTime) {
		
		long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
		int hoursWorked = (int)longHoursWorked;
		int payRate = 12;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
	
	
}
