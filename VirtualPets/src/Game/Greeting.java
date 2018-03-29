package Game;
import java.util.Scanner;

public class Greeting {

	private static Scanner reader;

	// Setting Up the Game
	public static int GreetAns() {
		
		reader = new Scanner(System.in);  
		int greetingAns = 0;
		boolean expBool = true;
		
		while (expBool) {
			System.out.println("Welcome to the Pet game!" + "\n" + "1. Start the game" + "\n" + "2. Help Info");
			
			if (reader.hasNextInt())
				greetingAns = reader.nextInt();
			
			else {
				System.out.println("Invalid input! Please re-enter." + "\n");
				reader.next();
				continue;
			}
			expBool = false;
		}
		return greetingAns;
	}
}
