package Game;
import java.util.Scanner;

public class GameInfo {

	private static Scanner reader;
	
	// Setting Up the Game
	public static int numOfPlayers() {
			
		reader = new Scanner(System.in);  
		System.out.println("How many players? ");
		return reader.nextInt(); 
	}
		
	public static int numOfDays() {
		reader = new Scanner(System.in);
		System.out.println("How many day(s)? (Choose between 1-99)");
		return reader.nextInt();
	}
		
	// Method "helpText" to take user input and determine what help info to print
	public static void helpText() {
		reader = new Scanner(System.in);
		boolean flag = true;
		
		while (flag) {
			System.out.println("---> HELP INFO <---"
			+ "\n" + "1. Objective" + "\n" + "2. Pets" + "\n" + "3. Actions" + "\n" + "4. Exit help" + "\n" + "-------------------" );

			String greetingAns = reader.nextLine();
			int option = 0;
			try {
				option = Integer.parseInt(greetingAns);
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid input. Please Re-enter. " + "\n");
				continue;
			}
			
			if (option == 1) {
				System.out.println("-----OBJECTIVE-----" + "\n" + "To look after your pets of course! " 
						+ "In this game your main goal is to manage and play with your pets. "
						+ "Make them happy! "
						+	 "\n");
			}
	
			else if (option == 2) {
				System.out.println("-----Pets-----" + "\n" + "You can have up to 3 pets. You get to chose "
						+ "what species of pet you want and get to name it as well!"
						+"\n" + "Different species have different attributes. Look over them carefully. "
						+ "Pets have hunger, boredom and energy attributes."
						+ "\n" + "They will die if not fed enough, so watch their hunger and feed them appropriately. "
						+ "\n");
			}
		
			else if (option == 3) {
				System.out.println("-----Actions-----" + "\n" + "You can perform 2 actions per day per pet. Feeding fills their hunger "
						+ "while playing with toys helps their boredom."
						+"\n" + "Sleeping helps them regain some energy. "
						+ "Pets have hunger, boredom and energy attributes."
						+ "\n");
			}
			
			else if (option == 4) {
				flag = false;
			}
			
			else {
				System.out.println("Invalid selection. Please select a valid option. " + "\n");
			}
		
			
		}
	}
}