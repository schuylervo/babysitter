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
			
			int wageEarnedAfterEleven = 0;
			
			return wageEarnedBeforeEleven;
			
			
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
	
	public int payFromFamilyBBetween5pmAnd4am(LocalTime startTime, LocalTime endTime) {
		
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) && (endTime.isAfter(LocalTime.of(16,59,59)) && endTime.isBefore(LocalTime.of(22, 0)) || endTime.equals(LocalTime.of(22, 0)) )) {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 12;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
		}
		
		else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) && (endTime.isAfter(LocalTime.of(16,59,59)) && endTime.isBefore(LocalTime.of(23, 59, 59)) || endTime.equals(LocalTime.MIDNIGHT))) {
			
			
			if(endTime.equals(LocalTime.MIDNIGHT)) {
				
				LocalTime tenOClockAtNight = LocalTime.of(22, 0);

				long longHoursWorkedBefore10pm = ChronoUnit.HOURS.between(startTime, tenOClockAtNight);
				int hoursWorkedBefore10pm = (int)longHoursWorkedBefore10pm;
				int payRateBetween5pmAnd10pm = 12;
				int wageEarnedBefore10pm = payRateBetween5pmAnd10pm * hoursWorkedBefore10pm;
				
				final int wageEarnedBetween10pmAndMidnight = 16;
				
				int wageEarned = wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight;
				
				return wageEarned;
				
			} else {
			
				LocalTime tenOClockAtNight = LocalTime.of(22, 0);
				
				long longHoursWorkedBefore10pm = ChronoUnit.HOURS.between(startTime, tenOClockAtNight);
				int hoursWorkedBefore10pm = (int)longHoursWorkedBefore10pm;
				int payRateBetween5pmAnd10pm = 12;
				int wageEarnedBefore10pm = payRateBetween5pmAnd10pm * hoursWorkedBefore10pm;
				
				
				long longHoursWorkedBetween10pmAndMidnight = ChronoUnit.HOURS.between(tenOClockAtNight, endTime);
				int hoursWorkedBetween10pmAndMidnight = (int)longHoursWorkedBetween10pmAndMidnight;
				int payRateBetween10pmAndMidnight = 8;
				int wageEarnedBetween10pmAndMidnight = payRateBetween10pmAndMidnight * hoursWorkedBetween10pmAndMidnight;
				
				int wageEarned = wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight;
				
				return wageEarned;
			}
		}
		
		else if (startTime.isAfter(LocalTime.of(21, 59, 59)) && (endTime.isAfter(LocalTime.of(21, 59, 59)) && (endTime.isBefore(LocalTime.of(23, 59, 59)) || endTime.equals(LocalTime.MIDNIGHT)))) {
			
			if(endTime.equals(LocalTime.MIDNIGHT)) {
				startTime = startTime.minusHours(12);
				endTime = endTime.plusHours(12);
			}
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 8;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		} else if ((startTime.equals(LocalTime.MIDNIGHT) || (startTime.isAfter(LocalTime.MIDNIGHT)) && startTime.isBefore(LocalTime.of(4, 0,1))) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4, 0)) )){
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 16;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		}
		
		
		else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4, 0)))) {
			
				
			LocalTime tenOClockAtNight = LocalTime.of(22, 0);
				
			long longHoursWorkedBefore10pm = ChronoUnit.HOURS.between(startTime, tenOClockAtNight);
			int hoursWorkedBefore10pm = (int)longHoursWorkedBefore10pm;
			int payRateBetween5pmAnd10pm = 12;
			int wageEarnedBefore10pm = payRateBetween5pmAnd10pm * hoursWorkedBefore10pm;
				
			final int wageEarnedBetween10pmAndMidnight = 16;
				
			long longHoursWorkedBetweenMidnightAndEndTime = ChronoUnit.HOURS.between(LocalTime.MIDNIGHT, endTime);
			int hoursWorkedBetweenMidnightAndEndTime = (int)longHoursWorkedBetweenMidnightAndEndTime;
			int payRateBetweenMidnightAndEndTime = 16;
			int wageEarnedBetweenMidnightAndEndTime = payRateBetweenMidnightAndEndTime * hoursWorkedBetweenMidnightAndEndTime;
				
			int wageEarned = wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight + wageEarnedBetweenMidnightAndEndTime;
				
			return wageEarned;
			
		}
		
		else if ((startTime.equals(LocalTime.of(22, 0)) || startTime.isAfter(LocalTime.of(22, 0))) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4, 0)))) {
				
			// calculate time worked between start time and midnight
			// change start time from PM and end time from midnight to noon so it is easier to do 24-hour clock math
			startTime = startTime.minusHours(12);
			
			long longHoursWorkedBetween10pmAndMidnight = ChronoUnit.HOURS.between(startTime, LocalTime.NOON);
			int hoursWorkedBetween10pmAndMidnight = (int)longHoursWorkedBetween10pmAndMidnight;
			int payRateBetween10pmAndMidnight = 8;
			int wageEarnedBetween10pmAndMidnight = payRateBetween10pmAndMidnight * hoursWorkedBetween10pmAndMidnight;
				
				
			long longHoursWorkedBetweenMidnightAndEndTime = ChronoUnit.HOURS.between(LocalTime.MIDNIGHT, endTime);
			int hoursWorkedBetweenMidnightAndEndTime = (int)longHoursWorkedBetweenMidnightAndEndTime;
			int payRateBetweenMidnightAndEndTime = 16;
			int wageEarnedBetweenMidnightAndEndTime = payRateBetweenMidnightAndEndTime * hoursWorkedBetweenMidnightAndEndTime;
				
			int wageEarned = wageEarnedBetween10pmAndMidnight + wageEarnedBetweenMidnightAndEndTime;
				
			return wageEarned;
			
		}
		
		
		else {
			
			long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
			int hoursWorked = (int)longHoursWorked;
			int payRate = 0;
			int wageEarned = payRate * hoursWorked;
			return wageEarned;
			
		}
		
		
	}
	
	public int payFromFamilyCBetween5pmAnd4am(LocalTime startTime, LocalTime endTime) {
		
		long longHoursWorked = ChronoUnit.HOURS.between(startTime, endTime);
		int hoursWorked = (int)longHoursWorked;
		int payRate = 21;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
	
	
	
	
	
}
