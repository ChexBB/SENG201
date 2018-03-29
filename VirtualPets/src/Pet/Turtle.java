package Pet;

import Food.Tuna;
import Toy.RubberDucky;

public class Turtle extends Pet 
{   //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Turtle(String petName) {
    	super(petName, "Turtle", "Female", 0, "Alive", 258.7, "Moody", new Tuna(), new RubberDucky(), 1, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/turtle.png");
    } 
}

