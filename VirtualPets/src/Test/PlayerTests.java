package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Food.Bacon;
import Food.Food;
import Game.Player;
import Pet.Pet;
import Pet.Turtle;
import Toy.Disc;
import Toy.Toy;

public class PlayerTests {
	Food testFood;
	Toy testToy;
	ArrayList<Food> expectedFoodArray;
	ArrayList<Toy> expectedToyArray;
	ArrayList<Pet> expectedPetArray;
	Player testPlayer;
	Turtle testPet;
	
	double delta = 0.5;
	
	@Before
	public void setUp() throws Exception {
		testFood = new Bacon();
		testToy = new Disc();
		expectedFoodArray = new ArrayList<Food>();
		expectedToyArray = new ArrayList<Toy>();
		expectedPetArray = new ArrayList<Pet>();
		testPlayer = new Player("testName", expectedPetArray, expectedToyArray, expectedFoodArray, 200, 0);
		testPet = new Turtle("nameTest");
	
	}
	
	@Test
	public void testPurchaseSnackBalance(){
		testPlayer.editFunds(testFood.getPrice());
		assertEquals(160, testPlayer.getFunds(), delta);
	}
	
	@Test
	public void testPurchaseSnackArray(){
		testPlayer.addSnack(testFood);
		expectedFoodArray.add(testFood);
		assertEquals(expectedFoodArray, testPlayer.getSnackArray());
	}
	
	@Test
	public void testPurchaseToyArray(){
		testPlayer.addToy(testToy);
		expectedToyArray.add(testToy);
		assertEquals(expectedToyArray, testPlayer.getToyArray());
	}
}
