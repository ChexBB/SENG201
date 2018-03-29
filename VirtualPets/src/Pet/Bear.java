package Pet;

import Food.Honey;
import Toy.TeddyBear;

public class Bear extends Pet 
{    //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Bear(String petName) {
    	super(petName, "Bear", "Male", 0, "Alive", 200, "Wild", new Honey(), new TeddyBear(), 3, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/bear.png");
    } 
}