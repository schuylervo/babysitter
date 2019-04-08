package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculatorFamilyB {

	public static int wageEarnedBetween5pmAnd10pm(LocalTime startTime, LocalTime endTime) {
		int hoursWorked = (int) ChronoUnit.HOURS.between(startTime, endTime);
		int payRate = 12;
		return payRate * hoursWorked;
	}
	
	public static int wageEarnedBetween10pmAndMidnight(LocalTime startTime, LocalTime endTime) {
		int hoursWorked = (int) ChronoUnit.HOURS.between(startTime, endTime);
		int payRate = 8;
		return payRate * hoursWorked;
	}
	
	public static int wageEarnedBetweenMidnightAnd4am(LocalTime startTime, LocalTime endTime) {
		int hoursWorked = (int) ChronoUnit.HOURS.between(startTime, endTime);
		int payRate = 16;
		return payRate * hoursWorked;
	}
	
	
	public int calcPayFromFamilyB(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) &&
				(endTime.isAfter(LocalTime.of(16,59,59)) && endTime.isBefore(LocalTime.of(22, 0)) ||
				endTime.equals(LocalTime.of(22, 0)) )) {
			
			return wageEarnedBetween5pmAnd10pm(startTime, endTime);
		}
		
		else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) &&
				(endTime.isAfter(LocalTime.of(16,59,59)) && endTime.isBefore(LocalTime.of(23, 59, 59)) ||
				endTime.equals(LocalTime.MIDNIGHT))) {
			
			
			if(endTime.equals(LocalTime.MIDNIGHT)) {
				
				LocalTime tenOClockAtNight = LocalTime.of(22, 0);
				int wageEarnedBefore10pm = wageEarnedBetween5pmAnd10pm(startTime, tenOClockAtNight);
				int wageEarnedBetween10pmAndMidnight = 16;
				return wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight;
				
			} else {
			
				LocalTime tenOClockAtNight = LocalTime.of(22, 0);
				int wageEarnedBefore10pm = wageEarnedBetween5pmAnd10pm(startTime, tenOClockAtNight);
				int wageEarnedBetween10pmAndMidnight = wageEarnedBetween10pmAndMidnight(tenOClockAtNight, endTime);
				return wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight;
				
			}
		}
		
		else if (startTime.isAfter(LocalTime.of(21, 59, 59)) && (endTime.isAfter(LocalTime.of(21, 59, 59)) &&
				(endTime.isBefore(LocalTime.of(23, 59, 59)) || endTime.equals(LocalTime.MIDNIGHT)))) {
			
			if(endTime.equals(LocalTime.MIDNIGHT)) {
				startTime = startTime.minusHours(12);
				endTime = endTime.plusHours(12);
			}
			
			return wageEarnedBetween10pmAndMidnight(startTime, endTime);
			
		} else if ((startTime.equals(LocalTime.MIDNIGHT) || (startTime.isAfter(LocalTime.MIDNIGHT)) &&
				startTime.isBefore(LocalTime.of(4, 0,1))) && (endTime.isBefore(LocalTime.of(4, 0)) ||
				endTime.equals(LocalTime.of(4, 0)) )){
			
			return wageEarnedBetweenMidnightAnd4am(startTime, endTime);
			
		}
		
		
		else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && startTime.isBefore(LocalTime.of(22, 0)) &&
				(endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4, 0)))) {
			
			LocalTime tenOClockAtNight = LocalTime.of(22, 0);
			int wageEarnedBefore10pm = wageEarnedBetween5pmAnd10pm(startTime, tenOClockAtNight);
			// two hours worked between 10pm and midnight at $8 per hour equals $16
			int wageEarnedBetween10pmAndMidnight = 16;
			int wageEarnedBetweenMidnightAndEndTime = wageEarnedBetweenMidnightAnd4am(LocalTime.MIDNIGHT, endTime);
			return wageEarnedBefore10pm + wageEarnedBetween10pmAndMidnight + wageEarnedBetweenMidnightAndEndTime;
			
		}
		
		else if ((startTime.equals(LocalTime.of(22, 0)) || startTime.isAfter(LocalTime.of(22, 0))) && (endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4, 0)))) {
				
			// calculate time worked between start time and midnight
			// change start time from PM and end time from midnight to noon so it is easier to do 24-hour clock math
			startTime = startTime.minusHours(12);

			int wageEarnedBetween10pmAndMidnight =  wageEarnedBetween10pmAndMidnight(startTime, LocalTime.NOON);
			int wageEarnedBetweenMidnightAndEndTime = wageEarnedBetweenMidnightAnd4am(LocalTime.MIDNIGHT, endTime);
			return wageEarnedBetween10pmAndMidnight + wageEarnedBetweenMidnightAndEndTime;
				
		}
		
		else {
			
			return 0;	
		}
		
	}
	
}
