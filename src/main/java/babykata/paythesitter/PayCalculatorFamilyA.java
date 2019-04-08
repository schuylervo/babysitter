package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculatorFamilyA {
		

	
	public int payFromFamilyABetween5pmAnd11pm(LocalTime startTime, LocalTime endTime) {
		int hoursWorked = (int)ChronoUnit.HOURS.between(startTime, endTime);
		int payRate = 15;
		return payRate * hoursWorked;
	}
	
	public int payFromFamilyABetween11pmAnd4am(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(22, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
		}
		int hoursWorked = (int) ChronoUnit.HOURS.between(startTime, endTime);
		int payRate = 20;
		return payRate * hoursWorked;
		
	}
	
	public int calcPayFromFamilyA(LocalTime startTime, LocalTime endTime) {
		
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isBefore(LocalTime.of(23, 0, 1)) &&
				endTime.isAfter(LocalTime.of(16, 59, 59))) {
			
			
			return payFromFamilyABetween5pmAnd11pm(startTime, endTime);
			
		} else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && (endTime.isAfter(LocalTime.of(23, 0, 0)) ||
				endTime.equals(LocalTime.MIDNIGHT))) {	
			
			
			LocalTime elevenOClock = LocalTime.of(23, 0, 0);
			int wageEarnedAfterEleven;
			int wageEarnedBeforeEleven = payFromFamilyABetween5pmAnd11pm(startTime, elevenOClock);
			
			if (endTime.equals(LocalTime.MIDNIGHT)) {
				wageEarnedAfterEleven = 20;
			} else {
				wageEarnedAfterEleven = 0;
			}
			return wageEarnedBeforeEleven + wageEarnedAfterEleven;
			
			
		} else if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			
			LocalTime elevenAtNight = LocalTime.of(23, 0, 0);
			
			if (startTime.isBefore(LocalTime.of(23, 0, 0))) {
			
				int wageEarnedBeforeEleven = payFromFamilyABetween5pmAnd11pm(startTime, elevenAtNight);
				
				LocalTime elevenInMorning = LocalTime.of(11, 0, 0);
				endTime = endTime.plusHours(12);
				
				int wageEarnedBetweenElevenAndEndTime = payFromFamilyABetween11pmAnd4am(elevenInMorning, endTime);	
				return wageEarnedBeforeEleven + wageEarnedBetweenElevenAndEndTime;
			}
			else {
				startTime = startTime.minusHours(12);
				endTime = endTime.plusHours(12);
				return payFromFamilyABetween11pmAnd4am(startTime, endTime);	
			}
			
			
		} else if (startTime.isAfter(LocalTime.of(22, 59, 59)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
			
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
			return payFromFamilyABetween11pmAnd4am (startTime, endTime);
			
		} else if (startTime.isBefore(LocalTime.of(4, 0, 1)) && endTime.isBefore(LocalTime.of(4, 0, 1))) { 
			
			return payFromFamilyABetween11pmAnd4am(startTime, endTime);
		}
		else {
			return 0;
		}
		
	}
	

	

	
	
	
	
	
}
