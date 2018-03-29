package Game;
import java.util.ArrayList;
import java.util.Scanner;

import Pet.Bear;
import Pet.Chicken;
import Pet.Dog;
import Pet.Penguin;
import Pet.Pet;
import Pet.Pig;
import Pet.Turtle;

public class Menu {
	private static Scanner reader;
	
	//initialize an object of each pet to display default statistics below
	static Pet turtle = new Turtle(null);
	static Pet chicken = new Chicken(null);
	static Pet penguin = new Penguin(null);
	static Pet bear = new Bear(null);
	static Pet pig = new Pig(null);
	static Pet dog = new Dog(null);
	
	//create pet arrayList
	static ArrayList<Pet> pet = new ArrayList<Pet>();
	
	//method to get number of players
	public static int getNumPlayers() {
		return GameInfo.numOfPlayers();
	}
	
	//method to get player name
	public static String getPlayerName() {
		reader = new Scanner(System.in);  
		System.out.println("What is your name? ");
		return reader.next();
	}
	
	//method to get number of pets
	public static int getNumPets() {
		System.out.println("How many pets would you like? Please only select between 1-3. ");
		return reader.nextInt();
	}
	
	//Selecting Pets from menu for each player
	public static ArrayList<Pet> playerPets() {
		pet.clear(); //reset for next player
		int numPets = getNumPets();
		for (int num = 1; num <= numPets; num ++) {
			reader = new Scanner(System.in);
			Boolean flag = true;
				while (flag) {
					System.out.println("Choose your species for pet #" + num + " Select a number to see what that species offer.");
					System.out.println("1.  Turtle" + "\n" + "2.  Chicken" + "\n" + "3.  Penguin"
							+ "\n" + "4.  Bear" + "\n" + "5.  Pig" + "\n" + "6.  Dog");

					int option = reader.nextInt();
					//might need to use switches for this section
					//For Turtle 
					if (option == 1) {
						System.out.println("-----Species Statistics-----");
						turtle.defaultStats();
						
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n" );
						if (reader.nextInt() == 1) {
							//ask for pets name and set it
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet turtle = new Turtle(petName);
							pet.add(turtle);
						}
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					
					//For Chicken	
					else if (option == 2) {
						System.out.println("-----Species Statistics-----");
						chicken.defaultStats();
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No");
						if (reader.nextInt() == 1) {
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet chicken = new Chicken(petName);
							pet.add(chicken);
						} 
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					
					//For Penguin	
					else if (option == 3) {
						System.out.println("-----Species Statistics-----");
						penguin.defaultStats();
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No");
						if (reader.nextInt() == 1) {
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet penguin = new Penguin(petName);
							pet.add(penguin);
						} 
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					
					//For Bear 	
					else if (option == 4) {
						System.out.println("-----Species Statistics-----");
						bear.defaultStats();
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No");
						if (reader.nextInt() == 1) {
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet bear = new Bear(petName);
							pet.add(bear);
						} 
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					
					//For Pig 	
					else if (option == 5) {
						System.out.println("-----Species Statistics-----");
						pig.defaultStats();
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No");
						if (reader.nextInt() == 1) {
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet pig = new Pig(petName);
							pet.add(pig);
						} 
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					
					//For Dog 	
					else if (option == 6) {
						System.out.println("-----Species Statistics-----");
						dog.defaultStats();
						System.out.println("\n" + "Would you like to purchase this species?" + "\n" + "1. Yes" + "\n" + "2. No");
						if (reader.nextInt() == 1) {
							System.out.println("Give a name for your new pet: ");
							String petName = reader.next();
							Pet dog = new Dog(petName);
							pet.add(dog);
						} 
						else {
							System.out.println("Returning to main menu...");
							continue;
						}
					}
					flag = false;	
			}
		}	
	//return player pet array
	return pet;
	}
}
