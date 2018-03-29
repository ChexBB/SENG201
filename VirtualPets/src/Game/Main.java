package Game;

import java.util.ArrayList;
import Food.Food;
import Pet.Pet;
import Toy.Toy;

public class Main {
	
	static ArrayList<Player> playerList = new ArrayList<Player>(); 
	ArrayList<Player> player = new ArrayList<Player>();
	ArrayList<Pet> pet = new ArrayList<Pet>();
	
	public static void main(String[] args) {
		
		int greetAns = Greeting.GreetAns();
		
		while (greetAns != 1 && greetAns != 2) { 
			System.out.println("Please select a valid option." + "\n");
			greetAns = Greeting.GreetAns();
		}
		if (greetAns == 2) {
			GameInfo.helpText();
		}
		
		if ((greetAns == 1) || (greetAns == 2)) {
			// number of rounds
			int numDays = GameInfo.numOfDays();
			// to create pet array for each player
			int numOfPlayers = Menu.getNumPlayers();
			for (int players = 1; players <= numOfPlayers; players ++) {
				
				// getting a player and their chosen pets as an array
				System.out.println("-----Player " + players + "-----");
				
				String playerName = Menu.getPlayerName(); // gets player name
				ArrayList<Pet> pet = Menu.playerPets(); // gets pet array
				
				//creating empty toy and snacks inventory for the player class
				ArrayList<Toy> toyInventory = new ArrayList<Toy>();
				ArrayList<Food> snackInventory = new ArrayList<Food>();
		
				Player player = new Player(playerName, pet, toyInventory, snackInventory, 200, 0);
				playerList.add(player);
			}
			
			for (int rounds = 1; rounds <= numDays; rounds ++) {
				System.out.println("-----DAY " + rounds + " BEGINS-----");
				Play.MainGame();
				}
			//do calculation for pets to generate score
			ArrayList<Player> playerScores = new ArrayList<Player>();
			playerScores.add(playerList.get(0));
			
			for (Player player : playerList) {
				int total = 0;
				for (Pet pet : player.getPetArray()) {
					total += pet.getScore();
				
			    }
				player.setScore(total);	
				
				int place = 0;
				while (player.getScore() < playerList.get(place).getScore()) {
					place += 1;
				}
				playerScores.set(place, player);	
			}
			
			System.out.println("-------Winner-------" + "\n");
			System.out.println(playerScores.get(0).getName() + " (" + playerScores.get(0).getScore() + " points)");
			playerScores.remove(0);
			
			if (playerScores.size() > 0) {
				int number = 2;
				for (Player player : playerScores) {
					System.out.println(number + ". " + player.getName() + " (" + player.getScore() + " points)");
					number += 1;
				}
			}
					
		}
		
	}
	
	public static ArrayList<Player> playerList() {
		return playerList;
	}
}