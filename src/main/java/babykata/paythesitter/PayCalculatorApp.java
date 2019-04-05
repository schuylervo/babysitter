package babykata.paythesitter;

import java.time.LocalTime;
import java.util.Scanner;

public class PayCalculatorApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		PayCalculator payCalculator = new PayCalculator();
		
		String familyLetter = "";
		String regex = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
		String startString ="";
		String endString ="";
		LocalTime startTime;
		LocalTime endTime;
		boolean timeEntryValid = false;
		
		
		
		
		while (!(familyLetter.equals("A") || familyLetter.equals("B") || familyLetter.equals("C") ||
				familyLetter.equals("a") || familyLetter.equals("b") || familyLetter.equals("c"))) {	
			
			familyLetter = getString( scnr, "Please enter letter of babysitting family that employed you (A, B or C)");	
		}
		
		
		do {
		
			while(!(startString.matches(regex))) {
					startString = getStringMatchingRegex(scnr, "Please enter start time using 12-hour '11:59am' format", regex);
				}
			
			while(!(endString.matches(regex))) {
				endString = getStringMatchingRegex(scnr, "Please enter end time using 12-hour '11:59am' format", regex);
			}
			
			
			String startingTime12hour = startString.substring(0, 5);
			String endingTime12hour = endString.substring(0,5);
			String startingTimeOfDay = startString.substring(5);
			String endingTimeOfDay = endString.substring(5);
			
			
			startTime = LocalTime.parse(startingTime12hour);
			endTime = LocalTime.parse(endingTime12hour);
			
			if (startingTimeOfDay.contains("p")) {
				startTime.plusHours(12);
			}
			
			if (endingTimeOfDay.contains("p")) {
				endTime.plusHours(12);
			}
			
			
			if ((startTime.isAfter(LocalTime.of(4,0))) && (startTime.isBefore(LocalTime.of(17, 0)))) {
				System.out.println("Invalid start time.");
				timeEntryValid = false;
			}
			else if ((endTime.isAfter(LocalTime.of(4,0))) && (endTime.isBefore(LocalTime.of(17, 0)))) {	
				System.out.println("Invalid end time.");
				timeEntryValid = false;
			}
			else if (startTime.isAfter(endTime) && startTime.isAfter(LocalTime.of(16, 59, 59)) && endTime.isAfter(LocalTime.of(16, 59, 59))) {
				System.out.println("Invalid time entries.");
				timeEntryValid = false;
			}
			else if (startTime.isAfter(endTime) && startTime.isBefore(LocalTime.of(4,0,1)) && endTime.isBefore(LocalTime.of(4, 0, 1))) {
				System.out.println("Invalid time entries.");
				timeEntryValid = false;
			}
			else if (startTime.isBefore(LocalTime.of(4,0,1)) && endTime.isAfter(LocalTime.of(16, 59, 59))) {
				System.out.println("Invalid time entries.");
				timeEntryValid = false;	
			} 
			else {
				timeEntryValid = true;
			
			}
		
		} while (timeEntryValid=false);
		
		
		
		String family= familyLetter.toLowerCase();
		
		if (family.equals("a")) {
			payCalculator.calcPayFromFamilyA(startTime, endTime);
		}
		
		else if (family.equals("b")) {
			payCalculator.calcPayFromFamilyB(startTime, endTime);
		}
		
		else { 
			payCalculator.calcPayFromFamilyC(startTime, endTime);
		}
		
		
	}
		
		

	public static String getString(Scanner scnr, String prompt) {
		
		System.out.print(prompt);
		return scnr.nextLine();
	}



	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid;
		String input;
		do {
			input = getString(scnr, prompt);
		
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
		
		} while (!isValid);
		return input;
}

}