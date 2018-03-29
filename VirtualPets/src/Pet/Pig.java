package Pet;

import Food.Bacon;
import Toy.Rope;

public class Pig extends Pet 
{    //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Pig(String petName) {
    	super(petName, "Pig", "Male", 0, "Alive", 40, "Lazy", new Bacon(), new Rope(), 2, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/pig.png");
    } 
}