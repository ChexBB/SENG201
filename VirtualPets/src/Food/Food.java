package Food;
/**
 * 
 * @author Chuan & Brooke
 *
 */
public class Food {
    
    private String foodName; 
    private int price;
    private int health;
    private int happiness;
    private int energy;
    private double weight;
    private int bladder;
    private String attributesLabel;
    
    /**
     * Food constructor class defining all the attributes each food object will hold
     * @param name - String. name of the food object
     * @param priceValue - int. cost of food to purchase in the store
     * @param healthValue - int. health value of food; how much hunger it fills
     * @param happinessValue - int. happiness value of food; how much happiness the food gives
     * @param energyValue - int. energy value of the food; how much energy it gives the pet
     * @param weightValue - int. weight value ofthe food; how much weight the pet loses when the food is consumed
     * @param bladderValue - int. bladder value of the food; how much bladder the pet loses when the food consumed
     */
    public Food(String name, int priceValue, int healthValue, int happinessValue, int energyValue, double weightValue, int bladderValue) {
        foodName = name;
        price = priceValue;
        health = healthValue;
        happiness = happinessValue;
        energy = energyValue; // how much energy gained
        weight = weightValue;
        bladder = bladderValue;
    }
    
    /**
     * A method to return the attributes of a food object as a string.
     * @return a string of the attributes of a food object.
     */
    public String attributesLabel() {
    	attributesLabel = "<html>Happiness: + " + happiness + " <br>Energy: + " + energy + "<br>Health: + " + health + "<br>Weight: + " + weight + "<br>Bladder + " 
    						+ bladder + "</html>";
    	return attributesLabel;					
    }
    
    /**
     * Getter method to obtain the price of the food object
     * @return int price value of food 
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Getter method to obtain the health value of the food object
     * @return int health value of food
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Getter method to obtain the happiness value of the food object
     * @return int happiness value
     */
    public int getHappiness() {
        return happiness;
    }
    
    /**
     * Getter method to obtain the weight value of the food object
     * @return double weight value
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Getter method to obtain the bladder value of the food object
     *  @return int bladder value
     */
    public int getBladder() {
        return bladder;
    }

    /**
     * Getter method to obtain the name of the food object
     * @return String name value
     */
    public String getName() {
        return foodName;
    }
    
    /**
     * Getter method to obtain the energy of the food object
     * @return int energy value
     */
    public int getEnergy() {
        return energy;
    }
}