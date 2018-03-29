package Pet;

import Food.Sardines;
import Toy.Disc;

public class Penguin extends Pet 
{    //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Penguin(String petName) {
    	super(petName, "Penguin", "Female", 0, "Alive", 20, "Chilled-out", new Sardines(), new Disc(), 2, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/penguin.png");
    } 
}
