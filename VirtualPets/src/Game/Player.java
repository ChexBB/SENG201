package Game;

import java.util.ArrayList;

import Food.Food;
import Pet.Pet;
import Toy.Toy;
/**
 * 
 * @author Chuan& Brooke
 * Player class attributes for each player in the game
 * 
 */
public class Player {
    
    private ArrayList<Pet> petCollection = new ArrayList<Pet>();
    private ArrayList<Toy> toyCollection = new ArrayList<Toy>();
    private ArrayList<Food> snackCollection = new ArrayList<Food>();
    private ArrayList<Pet> finishedPets = new ArrayList<Pet>();
    private String name;
    private int totalMoney;
    private int score;
    /**
     * Constructor for player. When a new player is created, each of the following parameters are what the player will use in the main game
     * @param playerName - user input taken as a string. all names are unique across players and pets
     * @param pet - an array list of pets that the player owns
     * @param toyInventory - an array list of toys that the player owns
     * @param snackInventory - an array list of the snacks and foods that the player owns
     * @param funds - a integer that holds the available funds to a player to be used for purchasing items
     * @param holdScore - an integer that determines who wins the game at the end of all the days
     */
    public Player(String playerName, ArrayList<Pet> pet, ArrayList<Toy> toyInventory, ArrayList<Food> snackInventory, int funds, int holdScore) {
        
        name = playerName; //to add each pet selected to the players pet array
        for (Pet pets : pet) { //for loop needed to precent static pet array being added to all players
        	petCollection.add(pets);
        }
        toyCollection = toyInventory;
        snackCollection = snackInventory;
        totalMoney = funds; // starting funds will be 200. Will add 50 per game day
        score = holdScore;
    }
    /**
     * Getter method to return a players pet array and the pet objects it contains
     * @return the array list of pet objects belonging to the player
     */
    public ArrayList<Pet> getPetArray() {
        return petCollection;
    }
    
    /**
     *  Getter method to return a players toy array and the toy objects it contains
     * @return the array list of toy objects belonging to the player
     */
    public ArrayList<Toy> getToyArray() {
        return toyCollection;
    }
    
    /**
     * Getter method to return a players snack array and the food objects it contains
     * @return the array list of snack objects belonging to the player
     */
    public ArrayList<Food> getSnackArray() {
        return snackCollection;
    }
    
    /**
     * A method to add a selected toy object to a players toy array
     * @param object a user chosen toy object that will be added to his/her toy array
     */
    public void addToy(Toy object) {
        toyCollection.add(object);
    }
    
    /**
     * A method to add a selected snack object to a players snack array
     * @param object a user chosen food object that will be added to his/her snack array
     */
    public void addSnack(Food object) {
        snackCollection.add(object);
    }

    /**
     * A method used to reduce a players total funds after the purchase of a toy or snack
     * @param value this is the cost of the food or toy object. it is called using another method .getPrice from the respective class (food or toy)
     */
    public void editFunds(int value) {
        totalMoney -= value;
    }
    
    /**
     * Getter method to obtain the players current available funds
     * @return the funds value of the player as an integer
     */
    public int getFunds() {
        return totalMoney;
    }
    
    /**
     * Method used at the start of each day that adds 50 dollars to each players total funds
     */
    public void allowance() {
        totalMoney += 50;
    }
    
    /**
     * Method obtain the players name
     * @return a string containing the players name
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Method used only for the command line version of the game. displays all toy and food objects the player currently has.
     * prints a string notifying the user if they have no objecs in their inventory.
     * outputs each object using a for loop to iterate through both the snack and toy array.
     */
    public void displayInventory() {
        System.out.println("Available funds: $" + totalMoney);
        System.out.println("Inventory: ");
        
        if (snackCollection.size() == 0 && toyCollection.size() == 0) {
        	System.out.println("Your inventory is empty!");
        }
        
        else {
        	int count = 1;
        	System.out.println("-----Snacks---");
            for (Food item : snackCollection) {
                System.out.println(count + ". " + item.getName());
                count += 1;
            }
            
            System.out.println("-----Toys-----");
            for (Toy item : toyCollection) {
                System.out.println(count + ". " + item.getName());
                count += 1;
            }
        }
    }
    /**
     * Method used only in the command line version of the game. Displays a print statement showing
     * the names of each toy object in the players toy inventory.
     */
    public void displayToyInventory() {
        System.out.println("Toy Inventory: ");
        
        int count = 1;
        for (Toy item : toyCollection) {
            System.out.println(count + ". " + item.getName());
            count += 1;
        }
    }
    
    /**
     * Method used only in the command line version of the game. Displays a print statement showing
     * the names of each food object in the players snack inventory.
     */
    public void displaySnackInventory() {
        System.out.println("Snack Inventory: ");
        
        int count = 1;
        for (Food item : snackCollection) {
            System.out.println(count + ". " + item.getName());
            count += 1;
        }
    }
    
    /**
     * Method to enumerate the names of toy objects in the players snack array into a single string. Used for display on a label
     * @return an enumerated string containing the names of all the toys in the players toy inventory.
     */
    public void displayToyInventoryGUI() {
        System.out.println("Toy Inventory: ");
        
        int count = 1;
        for (Toy item : toyCollection) {
            System.out.println(count + ". " + item.getName());
            count += 1;
        }
    }
    
    /**
     * Method to enumerate the names of food objects in the players snack array into a single string. Used for display on a label
     * @return an enumerated string containing the names of all the snacks in the players snack inventory.
     */
    public String displaySnackInventoryGUI() {
    	String printString = "";
        for (Food item : snackCollection) {
            printString += item.getName();
            printString += " ";
        }
        return printString;
    }
    
    /**
     * Method to allow a player to check if the pet has been added to the finished pet counter
     *  if true, adds 1 else adds 0
     * @param currentPet the pet the player is current interacting with 
     * @return the int 0 or 1. this integer is then added to the pet counter
     */
    public int checkActions(Pet currentPet) {
    	if (finishedPets.contains(currentPet)) {
    		return 0;
    	}
    	else {
    		finishedPets.add(currentPet);
    		return 1;
    	}
    }
    
    /**
     * Method to clear the array list of finished pets.
     * Used to refresh each players pets back to being active the next day
     */
    public void actionsDefault() {
    	finishedPets.clear();
    }
    
    /**
     * Setter method used to change the score of each player.
     * Called after the calculations are done at the end of the game
     * @param value the int that is calculated from the stats of all pets after the end of the game. 
     */
    public void setScore(int value) {
    	score = value;
    }

    /**
     * Getter method that gets the score of the player. displayed at the end of the game
     * @return the score as an int
     */
    public int getScore() {
    	return score;
    }
}