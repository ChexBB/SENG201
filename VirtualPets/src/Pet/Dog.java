package Pet;

import Food.Cheese;
import Toy.Ball;

public class Dog extends Pet 
{    //name, species, gender, age, status, weight, personality, favFood, favToy, toyDamage, 
	// energy, health, happiness, bladder, trained, isSick, isJealous, isMisbehaving, actions.
    public Dog(String petName) {
    	super(petName, "Dog", "Male", 0, "Alive", 7, "Hyperactive", new Cheese(), new Ball(), 2, 100, 50, 50, 50, 0, false, false, false, false, 2, "/Images/dog.png");
    } 
}
