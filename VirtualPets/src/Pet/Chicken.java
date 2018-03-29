package Pet;

import Food.Berries;
import Toy.Stick;

public class Chicken extends Pet 
{   //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Chicken(String petName) {
    	super(petName, "Chicken", "Female", 0, "Alive", 5, "Absent-minded", new Berries(), new Stick(), 1, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/chicken.png");
    } 
}