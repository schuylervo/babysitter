package babykata.paythesitter;


public class PayCalculator {
	
	
	public int pay(int hoursWorked) {
		int payRate = 15;
		int wageEarned = payRate * hoursWorked;
		return wageEarned;
	}
    
}
