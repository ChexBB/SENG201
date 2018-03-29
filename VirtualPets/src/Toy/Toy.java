package Toy;
/**
 * 
 * @author Chuan & Brooke
 *
 */
public class Toy {
    
    private String toyName; 
    private int price;
    private int uses;
    private int happinessRate;
    private int energyRate;
    private double weight; //weight loss
    private int bladder; // bladder loss
    private String attributesLabel;
    
    /**
     * Constructor class for Toy objects. Holds the attributes of all types of toys
     * @param name - String. name of the toy object
     * @param priceValue - int. cost of toy to purchase in the pet store
     * @param useValue - int. strength of the toy; how much the toy can be used without breaking
     * @param happinessValue - int. how much happiness value the toy gives
     * @param energyValue - int. how much energy value the toy gives
     * @param weightValue - double. how much weight a pet loses when the toy is played with
     * @param bladderValue - int. how much bladder is gained when toy is played with
     */
    public Toy(String name, int priceValue, int useValue, int happinessValue, int energyValue, double weightValue, int bladderValue) {
        toyName = name;
        price = priceValue;
        uses = useValue;
        happinessRate = happinessValue;
        energyRate = energyValue;
        weight = weightValue; //how much weight is lost when toy is used
        bladder = bladderValue;
    }
    
    /**
     * A method to return the attributes of a toy object as a string.
     * @return a string of the attributes of a toy object.
     */
    public String attributesLabel() {
    	attributesLabel = "<html>Happiness: + " + happinessRate + " <br>Energy: + " + energyRate + "<br>Weight: + " + weight + "<br>Bladder + " 
    						+ bladder + "<br>Uses: " + uses + "</html>";
    	return attributesLabel;					
    }
    
    /**
     * Getter method to obtain the price of the toy
     * @return int price
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Getter method to obtain the amount of uses a toy has
     * @return int uses
     */
    public int getUses() {
        return uses;
    }
    
    /**
     * Setter method that assigns the new use value of a toy after a pet has played with it
     * @param value ??
     */
    public void setUses(int value) {
        uses = value;
    }
    
    /**
     * Getter method that obtains the happiness rate the toy gives
     * @return int default happiness rate of the toy
     */
    public int getHappinessRate() {
        return happinessRate;
    }
    
    /**
     * Getter method that obtains the energy rate the toy depletes from the pet upon use
     * @return int energy rate of the toy
     */
    public int getEnergyRate() {
        return energyRate;
    }
    
    /**
     * Getter method to retrieve the name of the toy
     * @return String of toyname 
     */
    public String getName() {
        return toyName;
    }
    
    /**
     * Getter method to retrieve the weight the toy makes the pet lose when used
     * @return double weight value
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Getter method to retrieve the bladder value the toy makes the pet lose whenused
     * @return int bladder value
     */
    public int getBladder() {
        return bladder;
    }
    
    
}