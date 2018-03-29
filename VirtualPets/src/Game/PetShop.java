package Game;

import Food.*;
import Toy.*;


public class PetShop {
    
	//toys
	private static Toy ball = new Ball();
	private static Toy disc = new Disc();
	private static Toy rope = new Rope();
	private static Toy rubberDucky = new RubberDucky();
	private static Toy stick = new Stick();
	private static Toy teddyBear = new TeddyBear();

	//snacks
	private static Food bacon = new Bacon();
	private static Food berries = new Berries();
	private static Food cheese = new Cheese();
	private static Food honey = new Honey();
	private static Food sardines = new Sardines();
	private static Food tuna = new Tuna();
	
    public static void printCategories() {
        System.out.println("Please select what you would like to purchase:");
        System.out.println("1. Toys");
        System.out.println("2. Snacks");
        System.out.println("3. Exit");
    }
    
    public static void printToyOptions() {
        System.out.println("Please select what toy you would like to purchase:");
        System.out.println("1. Ball " + "$" + ball.getPrice());
        System.out.println("2. Disc "+ "$" + disc.getPrice());
        System.out.println("3. Rope "+ "$" + rope.getPrice());
        System.out.println("4. Rubber Ducky "+ "$" + rubberDucky.getPrice());
        System.out.println("5. Stick "+ "$" + stick.getPrice());
        System.out.println("6. Teddy Bear "+ "$" + teddyBear.getPrice());
        System.out.println("7. Go back");
    }
        
    public static void printSnackOptions() {
        System.out.println("Please select what snack you would like to purchase:");
        System.out.println("1. Bacon " + "$" + bacon.getPrice());
        System.out.println("2. Berries " + "$" + berries.getPrice());
        System.out.println("3. Cheese " + "$" + cheese.getPrice());
        System.out.println("4. Honey " + "$" + honey.getPrice());
        System.out.println("5. Sardines " + "$" + sardines.getPrice());
        System.out.println("6. Tuna " + "$" + tuna.getPrice());
        System.out.println("7. Go back ");
    }
}