package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Toy.*;
import Toy.Toy;

public class ToyTests {
	Toy testToy1;
	Toy testToy2;
	Toy testToy3;
	Toy testToy4;
	Toy testToy5;
	Toy testToy6;
	
	double delta = 0.5;

	@Before
	public void setUp() throws Exception {
		testToy1 = new Ball();
		testToy2 = new Stick();
		testToy3 = new Disc();
		testToy4 = new Rope();
		testToy5 = new RubberDucky();
		testToy6 = new TeddyBear();
	}
	
	@Test
	public void testDecreaseDurability1() {
		testToy1.setUses(testToy1.getUses() - 1); 
		testToy2.setUses(testToy2.getUses() - 1); 
		testToy3.setUses(testToy3.getUses() - 1); 
		testToy4.setUses(testToy4.getUses() - 1); 
		testToy5.setUses(testToy5.getUses() - 1); 
		testToy6.setUses(testToy6.getUses() - 1); 
		
		assertEquals(2, testToy1.getUses(), delta);
		assertEquals(0, testToy2.getUses(), delta);
		assertEquals(1, testToy3.getUses(), delta);
		assertEquals(3, testToy4.getUses(), delta);
		assertEquals(1, testToy5.getUses(), delta);
		assertEquals(5, testToy6.getUses(), delta);
	}
}
