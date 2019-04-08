package babykata.paythesitter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PayCalculatorFamilyC {

	public static int wageEarnedBetween5pmAnd9pm(LocalTime startTime, LocalTime endTime) {
		int minutesWorked = (int) ChronoUnit.MINUTES.between(startTime, endTime);
		int hoursWorked = minutesWorked/60;
		int partialHoursWorked = minutesWorked%60;
		if (partialHoursWorked>0) {
			hoursWorked++;
		}
		int payRate = 21;
		return payRate * hoursWorked;
	}
	
	public static int wageEarnedBetween9pmAnd4am(LocalTime startTime, LocalTime endTime) {
		if (endTime.isBefore(startTime)) {
			startTime = startTime.minusHours(12);
			endTime = endTime.plusHours(12);
		}
		int minutesWorked = (int) ChronoUnit.MINUTES.between(startTime, endTime);
		int hoursWorked = minutesWorked/60;
		int partialHoursWorked = minutesWorked%60;
		if (partialHoursWorked>0) {
			hoursWorked++;
		}
		int payRate = 15;
		return payRate * hoursWorked;
	}
	
	
	
	public int calcPayFromFamilyC(LocalTime startTime, LocalTime endTime) {
		
		if (startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isAfter(LocalTime.of(16, 59, 59)) &&
				(endTime.isBefore(LocalTime.of(21, 0)) || endTime.equals(LocalTime.of(21, 0))) ) {
			return wageEarnedBetween5pmAnd9pm(startTime, endTime);
			
		} else if (startTime.isAfter(LocalTime.of(20, 59, 59)) && (endTime.isAfter(LocalTime.of(21, 0)) ||
				endTime.equals(LocalTime.MIDNIGHT))){
			return wageEarnedBetween9pmAnd4am(startTime, endTime);
			
		} else if ((startTime.equals(LocalTime.of(21, 0)) || startTime.isAfter(LocalTime.of(21, 0))) &&
				(endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4,0)))){
			return wageEarnedBetween9pmAnd4am(startTime, endTime);
			
		} else if ((startTime.equals(LocalTime.of(17, 0)) || startTime.isAfter(LocalTime.of(17, 0))) &&
				(endTime.isBefore(LocalTime.of(4, 0)) || endTime.equals(LocalTime.of(4,0)))){
		
			LocalTime nineAtNight = LocalTime.of(21, 0);
			int wageEarnedBetweenStartTimeAndNineAtNight = wageEarnedBetween5pmAnd9pm(startTime, nineAtNight);
			int wageEarnedBetweenNineAtNightAndEndTimeAfterMidnight = wageEarnedBetween9pmAnd4am(nineAtNight, endTime);
			return wageEarnedBetweenStartTimeAndNineAtNight + wageEarnedBetweenNineAtNightAndEndTimeAfterMidnight; 
	}
		
		else {
			
			return 0;
		}
	}
	
}
