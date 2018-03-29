package Pet;
import java.util.ArrayList;
import java.util.Scanner;
import Food.*;
import Game.*;
import Toy.*;

/**
 * 
 * @author Chuan & Brooke
 * Pet class attributes
 */

public class Pet 
{
    private String name;
    private String species;
    private String gender;
    private int age;
    private String status;
    private double weight;
    private String personality;
    private Food favFood;
    private Toy favToy;
    private int toyDamage;
    private int energy;
    private int health;
    private int happiness;
    private int bladder;
    private int trained;
    private boolean isSick;
    private boolean isJealous;
    private boolean isMisbehaving;
    private int petActions;    
    private int score;
    private boolean beenRevived;
    private String petIcon;
    ArrayList<String> bigPets = new ArrayList<String>();
    
    /**
     * Pet constructor class. Holds all the personal and vital statistics of each pet object created
     * @param petName - String. determined by user input. each name is unique across all pets and players
     * @param holdSpecies - String. species of the pet object. each species is inherited from the pet class
     * @param holdGender - String. default gender of the pet
     * @param holdAge - int. starting age of the pet in days
     * @param holdStatus - status determining whether the pet is alive or has been dead
     * @param holdWeight - double. weight value of the pet. effected by food consumption and toilet use
     * @param holdPersonality - string. default personality of the pet
     * @param holdFavFood - obj food. the favourite food of the pet
     * @param holdFavToy - obj toy. the favourite toy of the pet
     * @param holdToyDamage - int. how much damage this pet does to toys upon use. 
     * @param holdEnergy - int. how tired the pet is. changed by pet actions and napping
     * @param holdHealth - int. hunger value. changed by pet actions
     * @param holdHappiness. - int happiness value. changed by pet actions.
     * @param holdBladder - int. bladder value. changed by pet actions
     * @param holdTrained - boolean. true or false value that shows if pet has been trained 
     * @param holdIsSick - boolean. true or false value that shows if pet is sick currently
     * @param holdIsJealous - boolean. true or false value that shows if the current pet is jealous.
     * @param holdIsMisbehaving - boolean. true or false value that shows if pet is mis behaving currently
     * @param actions - int. defaulted to 2. the amount of actions a pet can do per day
     * @param holdIcon - String. used in GUI implementation to hold the image icon location of pet 
     */
    public Pet (String petName, String holdSpecies, String holdGender, int holdAge, String holdStatus, double holdWeight, String holdPersonality,
    Food holdFavFood, Toy holdFavToy, int holdToyDamage, int holdEnergy, int holdHealth, int holdHappiness,
    int holdBladder, int holdTrained, boolean holdIsSick, boolean holdIsJealous, boolean holdIsMisbehaving, boolean holdBeenRevived, int actions, String holdIcon) {
        name = petName;
        species = holdSpecies;
        gender = holdGender;
        age = holdAge;
        weight = holdWeight;
        status = holdStatus;
        personality = holdPersonality;
        favFood = holdFavFood;
        favToy = holdFavToy;
        toyDamage = holdToyDamage;
        energy = holdEnergy;
        health = holdHealth;
        happiness = holdHappiness;
        bladder = holdBladder;
        trained = holdTrained;
        isSick = holdIsSick;
        isJealous = holdIsJealous;
        isMisbehaving = holdIsMisbehaving;
        beenRevived = holdBeenRevived; 
        petActions = actions;
        petIcon = holdIcon;
    }
    
	private static Scanner reader;
	
	public void petCategory(){
        bigPets.add(new Bear(null).getSpecies());
        bigPets.add(new Turtle(null).getSpecies());
        bigPets.add(new Pig(null).getSpecies());
	}
	/**
	 * Method used in command line implementation to print out personal stats of the 
	 * pet selected in the pet store. helps user compare different pets before committing to purchase
	 */
    public void defaultStats() {
        //preview stats to display for the pet store
        System.out.println("Species: " + species + "\n" + "Gender: " + gender + "\n" + "Age: " + age +  "\n" + "Status: " + status + "\n" + "Weight: " + weight + " kg" + "\n" + "Personality: " + personality);
        System.out.println("Favourite Food: " + favFood.getName() + "\n" + "Favourite Toy: " + favToy.getName() + "\n" + "Toy damage: " + toyDamage);
        
    }
    
    /**
     * Method used in command line implementation during the main game. 
     * similar to defalutStats but also prints out the vital statistics for each pet
     */
    public void getStats() {
        //full stats to display in the main game
    	System.out.println("-------Personal Stats-------" + "\n" + "Name: " + name + "\n" + "Status: " + status);
        System.out.println("Species: " + species + "\n" + "Gender: " + gender + "\n" + "Age: " + age + " days" + "\n" + "Weight: " + weight + " kg" + "\n" + "Personality: " + personality);
        System.out.println("Favourite Food: " + favFood.getName() + "\n" + "Favourite Toy: " + favToy.getName() + "\n" + "Toy damage: " + toyDamage);
        System.out.println("-------Vital Stats-------" + "\n" + "Energy: " + energy + "%" + "\n" + "Health: " + health + "%" + "\n" + "Happiness: " + happiness + "%" + "\n" + "Bladder: " +  bladder + "%");
        System.out.println("Trained: " + trained + "%" + "\n" + "Is sick: " + isSick + "\n" + "Is jealous: " + isJealous + "\n" + "Is misbahaving: " + isMisbehaving);
    }
    
    /**
     * Getter method used to obtain a pets name
     * @return a string, name which is the name of the pet given by the user
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter method used to assign a chosen name to the pets' name attribute
     * @param petName a user inputted string that will be set to the pets' name attribute
     */
    public void setName(String petName) {
    	name = petName;
    }
    
    /**
     * Getter method used to obtain the species of the pet
     * @return string, species which is the species of the pet
     */
    public String getSpecies() {
        return species;
    }
    
    /**
     * Getter method ised to obtain the gender of the pet
     * @return string gender. the default gender of the pet
     */
    public String getPetGender() {
    	return gender;
    }
    
    /**
     * Getter method to obtain age of pet
     * @return int age. the current age of the pet
     */
    public int getAge() {
    	return age;
    }
    
    /**
     * Getter method to obtain the current status of the pet
     * @return string "Alive" or "Dead"
     */
    public String getStatus() {
    	return status;
    }
    
    /**
     * Getter method to obtain the current weight of the pet
     * @return double value containing the weight of the pet in kg
     */
    public double getWeight() {
    	return weight;
    }
    
    /**
     * Getter method to obtain the personality of the pet
     * @return string value of the default personality of the pet
     */
    public String getPersonality() {
    	return personality;
    }
    
    /**
     * Getter method to obtain the pets favourite food
     * @return string value containing the name of the food object
     */
    public String getFavFood() {
    	return favFood.getName();
    }
    
    /**
     * getter method to reuturn fav food as an object
     * @return Food favfood of pet
     */
    public Food getFavFoodObj() {
    	return favFood;
    }
    
    /**
     * Getter method to obtain the pets favourite toy
     * @return string value containing the name of the toy object
     */
    public String getFavToy() {
    	return favToy.getName();
    }
    
    /**
     * getter method to reuturn fav toy as an object
     * @return Food favToy of pet
     */
    public Toy getFavToyObj() {
    	return favToy;
    }
    
    /**
     * Getter method used in the command line to the correct string
     * pronoun based on a pets gender
     * @return string "her" if female and "his" is male
     */
    public String getGender() {
    	if (gender == "Female") {
    		return "her";
    	}
    	else {
    		return "him";
    	}
    }
    
    /**
     * Getter method to obtain a pets default toy damage
     * @return int value of the pets toy damage
     */
    public int getToyDamage() {
        return toyDamage;
    }
    
    /**
     * Getter method to retrieve the location of and type of image of the pet.
     * used in the gui implementation to carry over the image of the pet to the 
     * petstatsgui page for the player to purchase 
     * @return string in the format "location/petspecies.png" 
     */
    public String getIcon() {
    	return petIcon;
    }
    
    /**
     * Getter method to retrieve the current energy of the pet
     * @return int value representing the pets energy 
     */
    public int getEnergy() {
    	return energy;
    }
    
    /**
     * Getter method to retrieve the current health of the pet
     * i.e hunger
     * @return int value representing the health of the pet
     */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Getter method to retrieve the current happiness of the pet
	 * @return int value representing the happiness of the pet
	 */
	public int getHappiness() {
		return happiness;
	}
	
	/**
	 * Getter method to retrieve the current bladder of the pet
	 * @return
	 */
	public int getBladder() {
		return bladder;
	}
	
	/**
	 * Getter method to obtain the 
	 * @return
	 */
	public int getTrained() {
		return trained;
	}
	
	/**
	 * Getter method to obtain a boolean value true or false
	 * representing if the pet is sick or not
	 * @return boolean value of "true" or "false"
	 */
	public boolean getIsSick() {
		return isSick;
	}

	/**
	 * Getter method to obtain a boolean value true or false
	 * representing if the pet is jealous or not
	 * @return boolean value of "true" or "false"
	 */
	public boolean getIsJealous() {
		return isJealous;
	}

	/**
	 * Getter method to obtain a boolan value true or false
	 * representing if the pet is misbehaving or not
	 * @return boolean value of "true" or "false"
	 */
	public boolean getIsMisbehaving() {
		return isMisbehaving;
	}
    
	/**
	 * Getter method to obtain boolean value true or false if pet has been revived
	 * @return
	 */
	public boolean getBeenRevived() {
	    	return beenRevived;
	}
	
	/**
	 * Setter Methodto set revived status of pet
	 * @param value boolean revived value
	 */
	public void beenRevived(boolean value) {
    	beenRevived = value;
    }
	
	/**
	 * Method used make the pet take a nape and restore some energy
	 * maxcheck is called in this method to check the pets max energy value
	 * and if it goes over 100 
	 */
    public void takeNap() {
    	
        energy += 15;
        maxMinCheck();
    }
    /**
     * Method used to enable pet to use selected toy
     * stats of the pet are altered depending
     * on the type of toy. If statement used to check if pet is 
     * currently using its favorite toy. if so, happiness gained is
     * boosted by 10 otherwise, happiness is boosted by the toys 
     * normal value
     * @param currentToy - the toy that the user intends
     * to use with the pet
     */
    public void playWithToy(Toy currentToy) {
        weight -= currentToy.getWeight();
        energy -= currentToy.getEnergyRate();
        bladder += currentToy.getBladder();
        if (currentToy == favToy) {
            happiness += (currentToy.getHappinessRate() + 10);
            maxMinCheck();
        }
        else {
            happiness += currentToy.getHappinessRate();
            maxMinCheck();
        }
    }
    
    /**
     * Method to enable a pet to eat selected snack stats 
     * of the pet are altered depending of the type of food eaten
     * weight, energy, health and bladder are all altered based on the food eaten
     * If statement used to check if pet is 
     * currently eating its favorite food. if so, happiness gained is
     * boosted by 10 otherwise, happiness is boosted by the foods normal value
     * @param currentSnack - the snack that the user intends
     * to use with the pet
     */
    public void eatSnack(Food currentSnack) {
        weight += currentSnack.getWeight();
        energy -= currentSnack.getEnergy();
        health += currentSnack.getHealth();
        bladder += currentSnack.getBladder();
        if (currentSnack == favFood) {
            happiness += (currentSnack.getHappiness() + 10);
    		maxMinCheck();
        }
        else {
            happiness += currentSnack.getHappiness();
    		maxMinCheck();
        }
    }
    
    /**
     * Method to enable pet to go to toilet. resets their bladder to 0
     */
    public void goToilet() {
        bladder = 0;
    }
    
    /**
     * Method to cuddle the pet. Free option that boosts happiness of pet by 10
     * maxcheck method called to ensure value does not exceed max value of 100
     */
    public void cuddle() {
        happiness += 10;
		maxMinCheck();
    }
    
    /**
     * Method to enable player to train the pet. boosted trained value by 10
     * maxcheck method called to ensure value does not exceed max value of 100
     */
    public void train() {
        trained += 10; 
		maxMinCheck();
    }
    
    /**
     * Setter method to change the pets is misbahving value to true or false
     * @param value boolean value of "true" or "false" that will be used to set 
     * a pets isMisbehaving value
     */
    public void isMisbehaving(boolean value) {
        isMisbehaving = value;
    }
    
    /**
     * Method used to age up a pet by 1 day. called at the start of each day
     */
    public void addYear() {
        age++;
    }
    
    /**
     * Setter method to change the pets isSick value to true or false
     * @param value boolean value of "true" or "false" that will be used to set 
     * a pets isSick value
     */
    public void isSick(boolean value) {
        isSick = value;
    }
    
    /**
     * Setter method to change the pets isjealous value to true or false
     * @param value boolean value of "true" or "false" that will be used to set
     * a pets isJealous value
     */
    public void isJealous(boolean value) {
        isJealous = value;
    }
    
    /**
     * Setter method to change the pets status value to alive or dead
     * @param value boolean value of "alive" or "dead" that will be used to set
     * a pets status 
     */
    public void setStatus(String value) {
    	status = value;
    }

    /**
     * Method to check all the attributes of a pet and to react accordingly to their
     * status. this method calls other methods defined in the pet class to set the pets new
     * values based on the requirements defined in this class
     * @param currentPlayer player object put in to be used if calling methods isDead, sick
     * and jealousPet.
     */
    public void check(Player currentPlayer) {
    	if (isSick == true) {
    		happiness -= 25;
    		health -= 20;
    		energy -= 20;
    		maxMinCheck();
    		
    		if (happiness < 30) {
    			setStatus("Dead");
    			isDead(currentPlayer);
    		}
    		else if (health < 30) {
    			setStatus("Dead");
    			isDead(currentPlayer);
    		}
    		else {
        		sick(currentPlayer);
    		}
    	}
    	else if (isJealous == true) {
    		isMisbehaving(true);
    		misbehave();
    	}
    	else if (isMisbehaving == true) {
    		happiness -= 30;
    		energy -= 15;
    		trained -= 15;
    		misbehave();
    		maxMinCheck();
    	}
    	else if (happiness < 50) {
    		isJealous(true);
    		jealousPet(currentPlayer);
    	}
    	else if (health < 50) {
    		isSick(true);
    		happiness -= 25;
    		sick(currentPlayer);
    		maxMinCheck();
    	}
    	else if (bladder > 70) {
    		happiness -= 25;
    		isSick(true);
    		maxMinCheck();
    	}
    	else if (energy < 30) {
    		happiness -= 25;
    		health -= 15;
    		isSick(true);
    		sick(currentPlayer);
    		maxMinCheck();
    	}
    }

    /**
     * Method used in the command line implementation only. makes the players
     * current pet sick and prints out a statement notifying the player.
     * Offers the player to ressurect the pet for $100 and edits the players total funds 
     * if they choose to do so. If they refuse, the pets happiness is decreased 
     * @param currentPlayer player obj is brought in to subtract the currentplayers funds 
     */
    public void sick(Player currentPlayer) {
    	reader = new Scanner(System.in);
    	System.out.println("Oh no! " + name + " is sick! Would you like to take " + getGender() + " to the vet for $100?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int option = reader.nextInt();
    	
    	if (option == 1) {
    		currentPlayer.editFunds(100);
    		isSick(false);
    	}
    	else if (option == 2) {
    		happiness -= 10;
    		maxMinCheck();
    	}
    	else {
    		System.out.println("Please enter a valid option...");
    	}
    	
    }
    
    /**
     * Method used in the command line implementation only. makes the players current 
     * pet misbehave and prints out a statement notifying the player.
     * offers the player to discipline the pet. if they do so pet is set to not misbehave
     * anymore and gains trained points but its happiness is reduced. if not, pets energy is reduced
     */
    public void misbehave() {
    	reader = new Scanner(System.in);
    	System.out.println("Oh no! " + name + " is misbehaving. Do you wish to discipline " + getGender() + "?" );
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int option = reader.nextInt();
    	
    	if (option == 1) {
    		happiness -= 20;
    		isMisbehaving(false);
    		trained += 25;
    		maxMinCheck();
    	}
    	else if (option == 2) {
    		energy -= 20;
    		maxMinCheck();
    	}
    	else {
    		System.out.println("Please enter a valid option...");
    	}
    }
    
    /**
     * Method used in the command line implementation only. makes the players current 
     * pet jealous and prints out a statement notifying the player.
     * offers the player to take the pet to the spa for $1290. if they do so pet is set to not jealous
     * anymore and gains happiness, energy and health. if not, pets happiness drops drastically and 
     * remains jealous
     */
    public void jealousPet(Player currentPlayer) {
    	reader = new Scanner(System.in);
    	System.out.println("Oh no! " + name + " is jealous. Do you wish to take " + getGender() + " to the pet day spa for $120?" );
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int option = reader.nextInt();
    	
    	if (option == 1) {
    		happiness += 30;
    		isJealous(false);
    		energy += 5;
    		health += 5;
    		maxMinCheck();
    		currentPlayer.editFunds(120);
    	}
    	else if (option == 2) {
    		happiness -= 40;
    		isMisbehaving(true);
    		maxMinCheck();
    	}
    	else {
    		System.out.println("Please enter a valid option...");
    	}
    }
    
    /**
     * Method used in the command line implementation only. makes the players current 
     * pet die and prints out a statement notifying the player.
     * offers the player to revive the pet for $200. if they do so the comes back to life. 
     * if not the pet remains dead with all its stats defaulted to 0
     */
    public void isDead(Player currentPlayer) {
    	reader = new Scanner(System.in);
    	System.out.println("Oh no! " + name + " has died. Do you wish to revive " + getGender() + " for $200?");
    	System.out.println("1. Yes");
    	System.out.println("2. No");
    	int option = reader.nextInt();
    	
    	if (option == 1) {
    		happiness += 10;
    		setStatus("Alive");
    		energy += 10;
    		health += 10;
    		currentPlayer.editFunds(200);
    		maxMinCheck();
    	}
    	else if (option == 2) {
    		setStatus("Dead");
    		happiness = 0;
    		energy = 0;
    		bladder = 0;
    		health = 0;
    	    trained = 0;
    	    isSick(false);
    	    isJealous(false);
    	    isMisbehaving(false);	
    	}
    	else {
    		System.out.println("Please enter a valid option...");
    	}
    }
    
    /**
     * Setter method to reduce a pets total actions left for the day by 1
     * called after an eat, play, toilet, cuddle or rest action only
     */
    public void removeAction() {
    	petActions -= 1;
    }
    
    /**
     * Setter method to reset a pets total actions for the day back to 2
     * called for each new day for each pet
     */
    public void defaultActions() {
    	petActions = 2;
    }
    
    /**
     * Getter method to obtain the amount of cuurent actions left for the pet
     * @return int value of actions left
     */
    public int getActions() {
    	return petActions;
    }
    
    /**
     * Setter method to decrease a pets stats each day.
     * Checks if the pet is a 'big' pet. if so it needs to
     * eat and sleep more. else it is a 'small' pet and needs
     * to play and go to the toilet more  
     */
    public void dailyReduction(Pet currentPet) {
    	petCategory();
    	if(bigPets.contains(currentPet.getSpecies())) {
    		energy -= 20;
        	happiness -= 10;
        	health -= 20;
        	bladder -= 10;
    	}
    	else {
    		energy -= 10;
        	happiness -= 20;
        	health -= 10;
        	bladder -= 20;
    	}
    	
    }
    
    /**
     * Method used to calculte the individual score of each pet
     * adds the happiness, energy, health, trained and minues the
     * bladder value to generate the score
     * @return int score of the pet sobj selected
     */
    public int getScore() {
    	score = happiness + energy + health + trained - bladder;
    	if (isSick == true) {
    		score -= 30;
    	}
    	else if (isJealous == true) {
    		score -= 30;
    	}
    	else if (isMisbehaving == true) {
    		score -= 30;
    	}
    	else if (status == "Dead") {
    		score = 0;
    	}
    	return score;
    }
    
    /**
     * Method to check and make sure the stats of the pet do not go over
     * the maximum value of 100. if they do, each stat is initialized to 100 (max)
     * checks ALL stats. this method is called after every method that edits a
     * pets stats
     */
    public void maxMinCheck() {
        if (bladder > 100) {
            bladder = 100;
        }
        if (happiness > 100) {
            happiness = 100;
        }
        if (energy > 100) {
            energy = 100;
        }
        if (trained > 100) {
        	trained = 100;
        }
        if (health > 100) {
        	health = 100;
        }
        if (bladder < 0) {
            bladder = 0;
        }
        if (happiness < 0) {
            happiness = 0;
        }
        if (energy < 0) {
            energy = 0;
        }
        if (trained < 0) {
        	trained = 0;
        }
        if (health < 0) {
        	health = 0;
        }
    }
    
    /**
     * Metho for gui to check stats of pet to invoke events
     * @param currentPlayer
     */
    public void checkGUI(Player currentPlayer) {
    	if (isSick == true) {
    		happiness -= 10;
    		health -= 5;
    		energy -= 5;
    		maxMinCheck();
    		
    		if (happiness < 10) {
    			setStatus("Dead");
    		}
    		else if (health < 10) {
    			setStatus("Dead");
    		}
    		else if (energy < 10) {
    			setStatus("Dead");
    		}
    		else if (bladder > 90) {
    			setStatus("Dead");
    		}

    	}
    	else if (isMisbehaving == true) {
    		happiness -= 10;
    		energy -= 5;
    		trained -= 5;
    		maxMinCheck();
    	}
    	else if (happiness < 20) {
    		isJealous(true);
    	}
    	else if (health < 20) {
    		isSick(true);
    		happiness -= 10;
    		maxMinCheck();
    	}
    	else if (bladder > 85) {
    		happiness -= 10;
    		isSick(true);
    		maxMinCheck();
    	}
    	else if (energy < 20) {
    		happiness -= 10;
    		health -= 5;
    		isSick(true);
    		maxMinCheck();
    	}
    }
    
    /**
     * method for gui to take a players anser to for a sick pet to evoke sickness
     * @param currentPlayer
     * @param answer
     */
    public void sickGUI(Player currentPlayer, int answer) {
	    
        if (answer == 0) {
        	currentPlayer.editFunds(100);
    		isSick(false);
        }
        else {
        	happiness -= 10;
    		maxMinCheck();
        }
    }
    
    /**
     * method for gui to take a players anser to for a misbehaving pet to evoke is misbehaving
     * @param answer
     */
    public void misbehaveGUI(int answer) {
    	if (answer == 0) {
    		happiness -= 20;
    		isMisbehaving(false);
    		trained += 25;
    		maxMinCheck();
    	}
    	else {
    		energy -= 20;
    		maxMinCheck();
    	}
    }
    
    /**
     * method for gui to take a players anser to for a jealous pet to evoke is jealous
     * @param currentPlayer
     * @param answer
     */
    public void jealousPetGUI(Player currentPlayer, int answer) {
    	if (answer == 0) {
    		happiness += 30;
    		isJealous(false);
    		energy += 5;
    		health += 5;
    		maxMinCheck();
    		currentPlayer.editFunds(120);
    	}
    	else {
    		happiness -= 40;
    		isMisbehaving(true);
    		maxMinCheck();
    	}
    }
    
    /**
     * Method to set stats of revived pet
     * @param currentPlayer
     */
    public void revivePetGUI(Player currentPlayer) {
		happiness += 10;
		setStatus("Alive");
		energy += 10;
		health += 10;
		currentPlayer.editFunds(200);
		beenRevived(true);
		maxMinCheck();
    }
    
    /**
     * Method to set stats of a dead pet
     */
    public void deadPetGUI() {
		setStatus("Dead");
		happiness = 0;
		energy = 0;
		bladder = 0;
		health = 0;
	    trained = 0;
	    isSick(false);
	    isJealous(false);
	    isMisbehaving(false);	
    }
}