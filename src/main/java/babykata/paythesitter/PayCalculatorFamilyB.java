package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculatorFamilyB {

	public int calcPayFromFamilyB(LocalTime startTime, LocalTime endTime) {
		
		
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
	
}
