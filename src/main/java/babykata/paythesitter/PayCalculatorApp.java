package babykata.paythesitter;

import java.time.LocalTime;
import java.util.Scanner;

public class PayCalculatorApp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		PayCalculatorFamilyA payCalculatorA = new PayCalculatorFamilyA();
		PayCalculatorFamilyB payCalculatorB = new PayCalculatorFamilyB();
		PayCalculatorFamilyC payCalculatorC = new PayCalculatorFamilyC();
		
		String familyLetter = "";
		String regex = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
		String startString ="";
		String endString ="";
		LocalTime startTime;
		LocalTime endTime;
		boolean timeEntryValid = false;
		
		
		while (!(familyLetter.equalsIgnoreCase("A") || familyLetter.equalsIgnoreCase("B") ||
				familyLetter.equalsIgnoreCase("C"))) {	
			
			familyLetter = getString( scnr, "Please enter letter of babysitting family that employed you (A, B or C):");	
		}
		
		
		do {
		
			while(!(startString.matches(regex))) {
					startString = getStringMatchingRegex(scnr, "Please enter start time using 12-hour '11:59am' format", regex);
				}
			
			while(!(endString.matches(regex))) {
				endString = getStringMatchingRegex(scnr, "Please enter end time using 12-hour '11:59am' format", regex);
			}
			
			
			String startingTime12hour = getTimeSubstring(startString);
			String endingTime12hour = getTimeSubstring(endString);
			
			startTime = LocalTime.parse(startingTime12hour);
			endTime = LocalTime.parse(endingTime12hour);
			
			if (startString.contains("p")) {
				startTime = startTime.plusHours(12);
			}
			
			if (endString.contains("p")) {
				endTime = endTime.plusHours(12);
			}
			
			timeEntryValid= isTimeEntryValid(startTime, endTime);
			
			startString = "";
			endString = "";
			
		
		} while (!timeEntryValid);
		
		
		
		String family= familyLetter.toLowerCase();
		
		if (family.equals("a")) {
			payCalculatorA.calcPayFromFamilyA(startTime, endTime);
		}
		else if (family.equals("b")) {
			payCalculatorB.calcPayFromFamilyB(startTime, endTime);
		}
		else { 
			payCalculatorC.calcPayFromFamilyC(startTime, endTime);
		}
		
	}
		
	public static boolean isTimeEntryValid(LocalTime startTime, LocalTime endTime) {
		if ((startTime.isAfter(LocalTime.of(4,0))) && (startTime.isBefore(LocalTime.of(17, 0)))) {
			System.out.println("Invalid start time.");
			return false;
		}
		else if ((endTime.isAfter(LocalTime.of(4,0))) && (endTime.isBefore(LocalTime.of(17, 0)))) {	
			System.out.println("Invalid end time.");
			return false;
		}
		else if (startTime.isAfter(endTime) && startTime.isAfter(LocalTime.of(16, 59, 59)) &&
				endTime.isAfter(LocalTime.of(16, 59, 59))) {
			System.out.println("Invalid time entries.");
			return false;
		}
		else if (startTime.isAfter(endTime) && startTime.isBefore(LocalTime.of(4,0,1)) &&
				endTime.isBefore(LocalTime.of(4, 0, 1))) {
			System.out.println("Invalid time entries.");
			return false;
		}
		else if (startTime.isBefore(LocalTime.of(4,0,1)) && endTime.isAfter(LocalTime.of(16, 59, 59))) {
			System.out.println("Invalid time entries.");
			return false;
		} 
		else {
			return true;
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
	
	public static String getTimeSubstring(String userString) {
		if ((userString.startsWith("10")) || (userString.startsWith("11"))|| (userString.startsWith("12"))) {
			return userString.substring(0, 5);
		} else {
			return "0" + userString.substring(0, 4);
		}
	}

}
