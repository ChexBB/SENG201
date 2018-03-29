package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Pet.Pet;
import Toy.*;
import Food.*;

public class Play {
		
	private static Scanner reader;

	public static void MainGame() {
		ArrayList<Player> allPlayers = Main.playerList();
		int total;
		int counter;
		int selection;
			
		// to iterate each player in game
		for (int i = 0; i < allPlayers.size(); i++) {
			reader = new Scanner(System.in); 
			Player currentPlayer = allPlayers.get(i);
			Pet currentPet = currentPlayer.getPetArray().get(0);
			total = currentPlayer.getPetArray().size();
			counter = 0;
			// turns for player
			while (counter != total) {
				
				if (currentPet.getActions() == 0) {
					counter += currentPlayer.checkActions(currentPet);
				}
				
				if (currentPet.getActions() == 0) {
					System.out.println("Your pet is worn out for today, please select another pet");
					selection = 2;
				}
				else {
					//shows who is active player
					System.out.println("------------------------" + "\n" +currentPlayer.getName() + "'s turn");
					System.out.println("-----------------------" + "\n" + "Actions left today: " + currentPet.getActions());
					System.out.println("\n" + "-------Main Menu-------" + "\n" + "1. View current pets" + "\n" + "2. Change active pet" + "\n" + "3. View Inventory" + "\n" + "4. Visit Pet Store");
					System.out.println("5. Play" + "\n" + "6. Feed" + "\n" + "7. Go to toilet" + "\n" + "8. Take a nap" + "\n" + "9. Cuddle" + "\n" + "10. Next day");
					selection = reader.nextInt(); 
				}
				
				switch (selection) {
					//view pet statistics
				
					case 1: currentPet.getStats();	
							break;
				
					case 2: ArrayList <Pet> pets = currentPlayer.getPetArray();
						int count = 0;
						System.out.println("\n" + "Choose your active pet: ");
						for (Pet pet : pets) {
							count += 1;
							System.out.println(count + ". " + pet.getName() + " (" + pet.getSpecies() + ")");
						}
						int petSelection = reader.nextInt();	
						//selection of active pet
						switch (petSelection) {
							case 1: currentPet = currentPlayer.getPetArray().get(0);
									break;
								
							case 2: currentPet = currentPlayer.getPetArray().get(1);
									break;
									
							case 3: currentPet = currentPlayer.getPetArray().get(2);
									break;
						}
							break;
									
					case 3: currentPlayer.displayInventory();
							break;
							
					case 4: boolean loop = true;
	                		while (loop) {
	                			System.out.println("Available funds: $" + currentPlayer.getFunds());
	                			PetShop.printCategories();
	                			int menuOption = reader.nextInt();
	                    
	                			if (menuOption == 1) {
	                				PetShop.printToyOptions();
	                				int toyOption = reader.nextInt();
	                        
	                				if (toyOption == 1) {
	                					Toy newBall = new Ball();
	                					if (newBall.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newBall); 
	                						currentPlayer.editFunds(newBall.getPrice());
	                						System.out.println(newBall.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                           
	                				}
	                        
	                				if (toyOption == 2) {
	                					Toy newDisc = new Disc();
	                					if (newDisc.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newDisc); 
	                						currentPlayer.editFunds(newDisc.getPrice());
	                						System.out.println(newDisc.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                               
	                				}
				                    
				                    if (toyOption == 3) {
				                        Toy newRope = new Rope();
				                        if (newRope.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newRope); 
	                						currentPlayer.editFunds(newRope.getPrice());
	                						System.out.println(newRope.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                
				                    }
				                    
				                    if (toyOption == 4) {
				                        Toy newRubberDucky = new RubberDucky();
				                        if (newRubberDucky.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newRubberDucky); 
	                						currentPlayer.editFunds(newRubberDucky.getPrice());
	                						System.out.println(newRubberDucky.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                          
				                    }
				                    
				                    if (toyOption == 5) {
				                        Toy newStick = new Stick();
				                        if (newStick.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newStick); 
	                						currentPlayer.editFunds(newStick.getPrice());
	                						System.out.println(newStick.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                
				                    }
				                    
				                    if (toyOption == 6) {
				                        Toy newTeddy = new TeddyBear();
				                        if (newTeddy.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addToy(newTeddy); 
	                						currentPlayer.editFunds(newTeddy.getPrice());
	                						System.out.println(newTeddy.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                
				                    }
				                    
				                    if (toyOption == 7) {
				                    	continue;
				                    }
				                    
				                }
				                
	                			else if (menuOption == 2) {
				                    PetShop.printSnackOptions();
				                    int snackOption = reader.nextInt();
				                    
				                    if (snackOption == 1) {
				                        Food newBacon = new Bacon();
				                        if (newBacon.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newBacon); 
	                						currentPlayer.editFunds(newBacon.getPrice());
	                						System.out.println(newBacon.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                               
				                    }
				                    
				                    if (snackOption == 2) {
				                        Food newBerries = new Berries();
				                        if (newBerries.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newBerries); 
	                						currentPlayer.editFunds(newBerries.getPrice());
	                						System.out.println(newBerries.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                                   
				                    }
				                    
				                    if (snackOption == 3) {
				                        Food newCheese = new Cheese();
				                        if (newCheese.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newCheese); 
	                						currentPlayer.editFunds(newCheese.getPrice());
	                						System.out.println(newCheese.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                                   
				                    }
				                    
				                    if (snackOption == 4) {
				                        Food newHoney = new Honey();
				                        if (newHoney.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newHoney); 
	                						currentPlayer.editFunds(newHoney.getPrice());
	                						System.out.println(newHoney.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                                   
				                    }
				                    
				                    if (snackOption == 5) {
				                        Food newSardines = new Sardines();
				                        if (newSardines.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newSardines); 
	                						currentPlayer.editFunds(newSardines.getPrice());
	                						System.out.println(newSardines.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                                  
				                    }
				                    
				                    if (snackOption == 6) {
				                        Food newTuna = new Tuna();
				                        if (newTuna.getPrice() <= currentPlayer.getFunds()) {
	                						currentPlayer.addSnack(newTuna); 
	                						currentPlayer.editFunds(newTuna.getPrice());
	                						System.out.println(newTuna.getName() + " purchased");
	                					}
	                					else {
	                						System.out.println("You can not afford this! ");
	                						continue;
	                					}                                                   
				                    }
				                    if (snackOption == 7) {
				                    
				                    	continue;
				                    }
				                }				                
	                			else if (menuOption == 3) {
				                	// exit from pet store
				                    loop = false;
	                			}
	                		}
	                		break;
	                		
	                // these onwards take an action		
					case 5: currentPlayer.displayToyInventory();
							ArrayList<Toy> toys = currentPlayer.getToyArray();
							if (toys.size() == 0) {
								System.out.println("No toys available - go buy some! ");
								break;
							}
							else {
								System.out.println("Please select a toy to play with!");
		                		int index = ((reader.nextInt()) - 1);
		                		Toy currentToy = currentPlayer.getToyArray().get(index);
		                		currentPet.playWithToy(currentToy);
		                		System.out.println(currentPet.getName() + " had fun playing with the " + currentToy.getName() + "!");
		                		int value = (currentToy.getUses() - currentPet.getToyDamage());
		                		currentToy.setUses(value);
		                		if (currentToy.getUses() <= 0) {
		                			currentPlayer.getToyArray().remove(index);
		                			System.out.println("Oh no! The toy you used has broken! ");
		                		}
		                		currentPet.removeAction();
		                		currentPet.check(currentPlayer);
		                		break;
							}
  
					case 6: currentPlayer.displaySnackInventory();
							//check if empty
							ArrayList<Food> snacks = currentPlayer.getSnackArray();
							if (snacks.size() == 0) {
								System.out.println("No snacks available - go buy some! ");
								break;
							}
							else {
								System.out.println("Please select a snack for your pet!");
		                		int index = ((reader.nextInt()) - 1);
		                		Food currentSnack = currentPlayer.getSnackArray().get(index);
		                		currentPet.eatSnack(currentSnack);
		                		System.out.println(currentPet.getName() + " has enjoyed the " + currentSnack.getName() + "!");
		                		currentPlayer.getSnackArray().remove(index);
		                		currentPet.removeAction();
		                		currentPet.check(currentPlayer);
		                		break;
							}
	                		

					case 7: System.out.println(currentPet.getName() + " has gone to the toilet");
							currentPet.goToilet();
							currentPet.removeAction();
							currentPet.check(currentPlayer);
							break;
					
					case 8: System.out.println(currentPet.getName() + " has taken a nap");
							currentPet.takeNap();
							currentPet.removeAction();
							currentPet.check(currentPlayer);
							break;
						
					case 9: System.out.println("You have cuddled " + currentPet.getName());
							currentPet.cuddle();
							currentPet.removeAction();
							currentPet.check(currentPlayer);
							break;
							
					case 10: counter = total; //move to next day
							i = allPlayers.size();
	            }
				
				if (currentPet.getActions() == 0) {
					counter += currentPlayer.checkActions(currentPet);
				}
			}	
			//reset current player actions for the next day
			for (Player player : allPlayers) {
				for (Pet pet : player.getPetArray()) {
					pet.defaultActions();
				}
			}
			counter = 0;
			currentPlayer.actionsDefault();
		}
		
		for (Player player : allPlayers) {
			player.allowance();
			
			for (Pet pet : player.getPetArray()) {
				pet.addYear();
			}
		}
	}	
}
