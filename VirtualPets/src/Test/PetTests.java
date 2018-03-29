package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Toy.*;
import Food.*;
import Pet.Turtle;

public class PetTests {
	Turtle testPet;
	Food testFood;
	Toy testToy;
	Toy testFavToy; //name of the toy object
	Food testFavFood; //name of the food object
	
	double delta = 0.5;
	
	@Before
	public void setUp() throws Exception {
		testPet = new Turtle("nameTest");
		testFood = new Bacon();
		testToy = new Disc();
		testFavFood = testPet.getFavFoodObj();
		testFavToy = testPet.getFavToyObj();
		
	}
	// for test food
	@Test
	public void testToiletUse() {
		testPet.goToilet();
		assertEquals(0, testPet.getBladder(), delta);
	}
	
	@Test
	public void testActionDecrease1() {
		testPet.removeAction();
		assertEquals(1, testPet.getActions(), delta);
	}
	
	@Test
	public void testStatChangeFood() {
		testPet.eatSnack(testFood);
		assertEquals(75, testPet.getHealth(), delta);
		assertEquals(75, testPet.getHappiness(), delta);
		assertEquals(80, testPet.getBladder(), delta);
		assertEquals(90, testPet.getEnergy(), delta);
		assertEquals(259.7, testPet.getWeight(), delta);
	}
	
	//for test toy
	@Test
	public void testStatChangeToy() {
		testPet.playWithToy(testToy);
		assertEquals(70, testPet.getHappiness(), delta);
		assertEquals(70, testPet.getEnergy(), delta);
		assertEquals(258.5, testPet.getWeight(), delta);
		assertEquals(65, testPet.getBladder(), delta);
	}	
	
	@Test
	//for test fav food
	public void testStatChangeFavFood() {
		testPet.eatSnack(testFavFood);
		assertEquals(80, testPet.getHealth(), delta);
		assertEquals(75, testPet.getHappiness(), delta);
		assertEquals(75, testPet.getBladder(), delta);
		assertEquals(259.7, testPet.getWeight(), delta);
	}
	
	@Test
	//for test fav toy
	public void testStatChangeFavToy() {
		testPet.playWithToy(testFavToy);
		assertEquals(80, testPet.getHappiness(), delta);
		assertEquals(65, testPet.getBladder(), delta);
		assertEquals(80, testPet.getEnergy(), delta);
		assertEquals(258.5, testPet.getWeight(), delta);
	}
	
	@Test
	public void testStatChangeDaily() {
		testPet.dailyReduction(testPet);
		assertEquals(30, testPet.getHealth(), delta);
		assertEquals(40, testPet.getHappiness(), delta);
		assertEquals(60, testPet.getBladder(), delta);
		assertEquals(80, testPet.getEnergy(), delta);
	}
}
