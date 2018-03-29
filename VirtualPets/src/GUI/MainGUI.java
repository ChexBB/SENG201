package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Game.Player;
import Pet.Pet;
import Toy.Toy;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import Food.Food;


public class MainGUI {
	
	private JFrame frame;
	private static int numberOfDays;
	private static int playerIndex;
	private static ArrayList<Player> allPlayers;
	private static Player currentPlayer;
	private static Pet currentPet;
	private static int tiredPetCounter;
	private static int petCount;
	private static int currentDay;
	private static ArrayList<Player> finishedPlayers; 
	private int toyArrayIndex;
	private int snackArrayIndex;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(int holdPlayerIndex, int holdPetCount, int holdCurrentDay, int holdTiredPetCounter, ArrayList<Player> holdFinishedPlayers) {
		petCount = holdPetCount;
		playerIndex = holdPlayerIndex;
		allPlayers = PlayerGUI.getPlayerList();
		currentPlayer = allPlayers.get(playerIndex);
		currentPet = currentPlayer.getPetArray().get(petCount);
		numberOfDays = PopUpGUI.getNumberOfDays();
		currentDay = holdCurrentDay;
		finishedPlayers = holdFinishedPlayers;
		tiredPetCounter = holdTiredPetCounter;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//nextdaysign moved up here to fix disappearing issue after mainGUI refresh
		
		
		JButton btnNextDay = new JButton();
		btnNextDay.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/nextDaySign.png")).getImage().getScaledInstance(150, 115, java.awt.Image.SCALE_SMOOTH)));
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Player player : allPlayers) {
					for (Pet pet : player.getPetArray()) {
						if (pet.getStatus() == "Alive") {
							pet.defaultActions();
							pet.dailyReduction(currentPet);
							pet.maxMinCheck();
							player.allowance();
						}
					}
				}
				petCount = 0;
				currentDay += 1;
				if (currentDay > numberOfDays) {
					EndGUI.main(null);
					frame.dispose();
				}
				else {
					playerIndex = 0;
					if (currentPet.getStatus() == "Alive") {
						checkPet();
					}
					MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
					frame.dispose();
				}
			}
		});
		btnNextDay.setBorder(null);
		btnNextDay.setOpaque(false);
		btnNextDay.setBackground(SystemColor.control);
		btnNextDay.setBounds(537, 399, 157, 102);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnInventory = new JButton("INVENTORY");
		btnInventory.setBounds(0, 64, 175, 66);
		frame.getContentPane().add(btnInventory);
		
		JPopupMenu inventoryMenu = new JPopupMenu();
		inventoryMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPopup(btnInventory, inventoryMenu, 173, 0);
		
		int objectCounter = (currentPlayer.getToyArray().size() + currentPlayer.getSnackArray().size());
		int width = 180;
		int height = 0;
		
		if ( objectCounter == 0 ) {
			JMenuItem mntmPet = new JMenuItem("empty");
			height = 30;
			mntmPet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmPet.setHorizontalAlignment(SwingConstants.CENTER);
			inventoryMenu.add(mntmPet);
		} 
		else {
			for (Toy toy : currentPlayer.getToyArray() ) {
				JMenuItem mntmToy = new JMenuItem(toy.getName());
				height += 30;
				mntmToy.setFont(new Font("Tahoma", Font.PLAIN, 20));
				mntmToy.setHorizontalAlignment(SwingConstants.CENTER);
				inventoryMenu.add(mntmToy);
			}
			
			for (Food snack : currentPlayer.getSnackArray() ) {
				JMenuItem mntmSnack = new JMenuItem(snack.getName());
				height += 30;
				mntmSnack.setFont(new Font("Tahoma", Font.PLAIN, 20));
				mntmSnack.setHorizontalAlignment(SwingConstants.CENTER);
				inventoryMenu.add(mntmSnack);
			}
		}
		
		inventoryMenu.setPopupSize(width, height);
		
		
		JButton btnEatSnack = new JButton("EAT SNACK");
		btnEatSnack.setBounds(0, 128, 175, 78);
		frame.getContentPane().add(btnEatSnack);
		
		JPopupMenu snackMenu = new JPopupMenu();
		addPopup(btnEatSnack, snackMenu, 173, 0);
		
		int snackCounter = (currentPlayer.getSnackArray().size());
		int snackWidth = 180;
		int snackHeight = 0;
		
		if ( snackCounter < 1 ) {
			JMenuItem mntmSnack = new JMenuItem("empty");
			snackHeight = 30;
			mntmSnack.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmSnack.setHorizontalAlignment(SwingConstants.CENTER);
			snackMenu.add(mntmSnack);
		} 
		else {
			
			for (Food snack : currentPlayer.getSnackArray() ) {
				JMenuItem mntmSnack = new JMenuItem(snack.getName());
				snackHeight += 30;
				mntmSnack.setFont(new Font("Tahoma", Font.PLAIN, 20));
				mntmSnack.setHorizontalAlignment(SwingConstants.CENTER);
				mntmSnack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenuItem snackItem = (JMenuItem)e.getSource();
						JPopupMenu popupMenu =(JPopupMenu) snackItem.getParent();
						snackArrayIndex = popupMenu.getComponentIndex(snackItem);
						if (currentPet.getActions() == 0) {
							checkForEOD();
						}
						else if (currentPet.getStatus() == "Dead") {
					   		final JOptionPane errorPane = new JOptionPane("This pet is dead. Please select another pet.");
				    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
				    		errorFrame.setLocation(370, 345);
				    		errorFrame.setVisible(true);
						}
						else {
							Food currentSnack = currentPlayer.getSnackArray().get(snackArrayIndex);
							currentPet.eatSnack(currentSnack);
	            			final JOptionPane snackMessage = new JOptionPane(currentPet.getName() + " has eaten the "
	            											+ currentSnack.getName().toLowerCase() + "!");
	        			    final JDialog snackWindow = snackMessage.createDialog((JFrame)frame, "");
	        			    snackWindow.setLocation(370, 345);
	        			    snackWindow.setVisible(true);
	        			    currentPlayer.getSnackArray().remove(snackArrayIndex);
	                		currentPet.removeAction();
	                		checkPet();
	                		checkForEOD();
						}
                		//currentPet.check(currentPlayer);
					}
				});
				snackMenu.add(mntmSnack);
			}
		}
		
		snackMenu.setPopupSize(snackWidth, snackHeight);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setBounds(0, 206, 175, 73);
		frame.getContentPane().add(btnPlay);
		
		JPopupMenu playMenu = new JPopupMenu();
		addPopup(btnPlay, playMenu, 173, 0);
		
		int toyCounter = (currentPlayer.getToyArray().size());
		int toyWidth = 180;
		int toyHeight = 0;
		
		if ( toyCounter < 1 ) {
			JMenuItem mntmToy = new JMenuItem("empty");
			toyHeight = 30;
			mntmToy.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmToy.setHorizontalAlignment(SwingConstants.CENTER);
			playMenu.add(mntmToy);
		} 
		else {
			
			for (Toy toy : currentPlayer.getToyArray() ) {
				JMenuItem mntmToy = new JMenuItem(toy.getName());
				toyHeight += 30;
				mntmToy.setFont(new Font("Tahoma", Font.PLAIN, 20));
				mntmToy.setHorizontalAlignment(SwingConstants.CENTER);
				mntmToy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JMenuItem toyItem = (JMenuItem)e.getSource();
						JPopupMenu popupMenu =(JPopupMenu) toyItem.getParent();
						toyArrayIndex = popupMenu.getComponentIndex(toyItem);
						Toy currentToy = currentPlayer.getToyArray().get(toyArrayIndex);
						if (currentPet.getActions() == 0) {
							checkForEOD();
						}
						else if (currentPet.getStatus() == "Dead") {
					   		final JOptionPane errorPane = new JOptionPane("This pet is dead. Please select another pet.");
				    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
				    		errorFrame.setLocation(370, 345);
				    		errorFrame.setVisible(true);
						}
						else {
							currentPet.playWithToy(currentToy);
	            			final JOptionPane playMessage = new JOptionPane(currentPet.getName() + " had fun playing with the "
	            											+ currentToy.getName().toLowerCase() + "!");
	        			    final JDialog playWindow = playMessage.createDialog((JFrame)frame, "");
	        			    playWindow.setLocation(370, 345);
	        			    playWindow.setVisible(true);
	                		int value = (currentToy.getUses() - currentPet.getToyDamage());
	                		currentToy.setUses(value);
	                		if (currentToy.getUses() <= 0) {
	                			currentPlayer.getToyArray().remove(toyArrayIndex);
	                			final JOptionPane errorMessage = new JOptionPane("Oh no! The toy you used has broken!");
	            			    final JDialog errorWindow = errorMessage.createDialog((JFrame)frame, "");
	            			    errorWindow.setLocation(370, 345);
	            			    errorWindow.setVisible(true);
	                		}
	                		currentPet.removeAction();
	                		checkPet();
	                		checkForEOD();
						}
                		//currentPet.check(currentPlayer);
					}
				});
				playMenu.add(mntmToy);
			}
		}
		
		playMenu.setPopupSize(toyWidth, toyHeight);

		
		JButton btnNap = new JButton("NAP");
		btnNap.setBounds(0, 277, 175, 66);
		frame.getContentPane().add(btnNap);
		btnNap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPet.getActions() == 0) {
					checkForEOD();
				}
				else if (currentPet.getStatus() == "Dead") {
			   		final JOptionPane errorPane = new JOptionPane("This pet is dead. Please select another pet.");
		    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
		    		errorFrame.setLocation(370, 345);
		    		errorFrame.setVisible(true);
				}
				else {
					currentPet.takeNap();
					currentPet.removeAction();
					final JOptionPane pane = new JOptionPane(currentPet.getName() + " has taken a nap.");
				    final JDialog d = pane.createDialog((JFrame)frame, "");
				    d.setLocation(370, 345);
				    d.setVisible(true);
				    checkPet();
				    checkForEOD();
				}
			}
		});
		
		JButton btnToilet = new JButton("TOILET");
		btnToilet.setBounds(0, 343, 175, 66);
		frame.getContentPane().add(btnToilet);
		btnToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPet.getActions() == 0) {
					checkForEOD();
				}
				else if (currentPet.getStatus() == "Dead") {
			   		final JOptionPane errorPane = new JOptionPane("This pet is dead. Please select another pet.");
		    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
		    		errorFrame.setLocation(370, 345);
		    		errorFrame.setVisible(true);
				}
				else {
					currentPet.goToilet();
					currentPet.removeAction();
					final JOptionPane pane = new JOptionPane(currentPet.getName() + " has gone to the toilet.");
				    final JDialog d = pane.createDialog((JFrame)frame, "");
				    d.setLocation(370, 345);
				    d.setVisible(true);
				    checkPet();
				    checkForEOD();
				}
			}
		});
	
		JButton btnCuddle = new JButton("CUDDLE");
		btnCuddle.setBounds(0, 409, 175, 66);
		frame.getContentPane().add(btnCuddle);
		btnCuddle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPet.getActions() == 0) {
					checkForEOD();
				}
				else if (currentPet.getStatus() == "Dead") {
			   		final JOptionPane errorPane = new JOptionPane("This pet is dead. Please select another pet.");
		    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
		    		errorFrame.setLocation(370, 345);
		    		errorFrame.setVisible(true);
				}
				else {
					currentPet.cuddle();
					currentPet.removeAction();
					final JOptionPane pane = new JOptionPane(currentPet.getName() + " loved the cuddle!");
				    final JDialog d = pane.createDialog((JFrame)frame, "");
				    d.setLocation(370, 345);
				    d.setVisible(true);
				    checkPet();
				    checkForEOD();
				}
			}
		});
	
		JButton btnPetStore = new JButton("PET STORE");
		btnPetStore.setBounds(0, 475, 175, 86);
		frame.getContentPane().add(btnPetStore);
		btnPetStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PetStoreGUI.main(playerIndex);
			}
		});
		
		JButton btnChangePet = new JButton("CHANGE PET");
		btnChangePet.setBounds(0, 0, 175, 66);
		frame.getContentPane().add(btnChangePet);
		
		JPopupMenu petMenu = new JPopupMenu();
		petMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPopup(btnChangePet, petMenu, 173, 0);
		
		JMenuItem mntmFirstPet = new JMenuItem(currentPlayer.getPetArray().get(0).getName() + " (" 
				+ currentPlayer.getPetArray().get(0).getSpecies() + ")");
		mntmFirstPet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mntmFirstPet.setHorizontalAlignment(SwingConstants.CENTER);
		petMenu.setPopupSize(210, 90);
		petMenu.add(mntmFirstPet);
		mntmFirstPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petCount = 0;
				checkForEOD();
			}
		});
		
		if (currentPlayer.getPetArray().size() > 1) {
			JMenuItem mntmSecondPet = new JMenuItem(currentPlayer.getPetArray().get(1).getName() + " (" 
										+ currentPlayer.getPetArray().get(1).getSpecies() + ")");
			mntmSecondPet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmSecondPet.setHorizontalAlignment(SwingConstants.CENTER);
			petMenu.setPopupSize(210, 180);
			petMenu.add(mntmSecondPet);
			mntmSecondPet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					petCount = 1;
					checkForEOD();

				}
			});
		}
		
		if (currentPlayer.getPetArray().size() > 2) {
			JMenuItem mntmThirdPet = new JMenuItem(currentPlayer.getPetArray().get(2).getName() + " (" 
										+ currentPlayer.getPetArray().get(2).getSpecies() + ")");
			mntmThirdPet.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mntmThirdPet.setHorizontalAlignment(SwingConstants.CENTER);
			petMenu.setPopupSize(210, 270);
			petMenu.add(mntmThirdPet);
			mntmThirdPet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					petCount = 2;
					checkForEOD();
				}
			});	
		}
		
		JLabel lblCurrentDay = new JLabel("Day " + currentDay + " / " +  numberOfDays);
		lblCurrentDay.setBounds(491, 17, 199, 40);
		frame.getContentPane().add(lblCurrentDay);
		lblCurrentDay.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentDay.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel backingPanel = new JPanel();
		backingPanel.setBackground(SystemColor.control);
		backingPanel.setBounds(476, 79, 214, 283);
		frame.getContentPane().add(backingPanel);
		backingPanel.setLayout(null);
		
		JLabel lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(currentPet.getIcon())).getImage().getScaledInstance(200, 340, java.awt.Image.SCALE_SMOOTH)));
		lblIcon.setOpaque(true);
		lblIcon.setText("");
		lblIcon.setBackground(SystemColor.control);
		lblIcon.setBounds(10, 54, 189, 229);
		backingPanel.add(lblIcon);
		
		JLabel lblActionsLeft = new JLabel("  Actions Left: " + currentPet.getActions());
		lblActionsLeft.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblActionsLeft.setBounds(0, 0, 199, 38);
		backingPanel.add(lblActionsLeft);
		
		JLabel lblPlayer = new JLabel(currentPlayer.getName() + "'s turn!");
		lblPlayer.setBounds(215, 15, 233, 40);
		frame.getContentPane().add(lblPlayer);
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblPersonalHeader = new JLabel("-------Personal Stats-------");
		lblPersonalHeader.setBounds(215, 80, 233, 33);
		frame.getContentPane().add(lblPersonalHeader);
		lblPersonalHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(215, 79, 233, 425);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPersonalStats = new JLabel("<html>Name: " + currentPet.getName() + "<br>Species: " + currentPet.getSpecies() 
							+ "<br>Gender: " + currentPet.getPetGender() +  "<br> Age: " + currentPet.getAge() + " days" 
							+ "<br> Weight: " + currentPet.getWeight() + " kg" + "<br> Personality: " + currentPet.getPersonality() 
							+ "<br> Favourite Food: " + currentPet.getFavFood() + "<br> Favourtie Toy: " + currentPet.getFavToy() 
							+ "<br> Toy Damage: " + currentPet.getToyDamage() + "<br> </html>");
		lblPersonalStats.setBounds(10, 27, 223, 199);
		lblPersonalStats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblPersonalStats);
		
		JLabel lblVitalHeader = new JLabel("---------Vital Stats---------");
		lblVitalHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblVitalHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVitalHeader.setBounds(0, 219, 233, 30);
		panel.add(lblVitalHeader);
		
		JLabel lblVitalStats = new JLabel("<html>Status: " + currentPet.getStatus() + "<br>Energy: " + currentPet.getEnergy() + "%" 
								+ "<br>Health: " + currentPet.getHealth() + "%" + "<br>Happiness: " + currentPet.getHappiness() + "%" 
								+  "<br>Bladder: " +  currentPet.getBladder() + "%" + "<br>Trained: " + currentPet.getTrained() + "%" 
								+ "<br>Is sick: " + currentPet.getIsSick() + "<br>Is jealous: " + currentPet.getIsJealous() 
								+ "<br>Is misbahaving: " + currentPet.getIsMisbehaving() + "<br> </html>");
		lblVitalStats.setBounds(10, 238, 206, 180);
		panel.add(lblVitalStats);
		lblVitalStats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		
	}
	/**
	 * Method to create new pop up menu
	 * @param component - the button that the menu is attached to
	 * @param popup - the name of the popup menu
	 * @param xPoint - x coordinate of the popup menu 
	 * @param yPoint - y coordinate of the popup menu
	 */
	private static void addPopup(Component component, final JPopupMenu popup, int xPoint, int yPoint) {
		component.addMouseListener(new MouseAdapter() {
			/**
			 * Method to start an event upon a mouse click
			 */
			public void mouseClicked(MouseEvent e) {
	            if (e.getButton() == MouseEvent.BUTTON1) {
					showMenu(e);
				}
			}
			/**
			 * Method to make the menu visble when called
			 * positions the menu according to the x and y point
			 * @param e - the event
			 */
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), xPoint, yPoint);
			}
		});
	}
	
	/**
	 * Method to check if it is the end of the day. does this by first checking if the 
	 * current pet has no more actions. if pet is out of actions, it checks if all pets
	 * are out of actions. It does so for the other players as well. Once all players 
	 * and their pets have run out of actions for the day it resets all pet actions and 
	 * moves onto the next day. this methodis used to check the actions of each player 
	 * their pets until the last day which it then calls the endgame gui. 
	 */
	public void checkForEOD() {
		if (currentPet.getActions() == 0) {
			tiredPetCounter += currentPlayer.checkActions(currentPet);
			
			if (tiredPetCounter == currentPlayer.getPetArray().size()) {
				finishedPlayers.add(currentPlayer);
				currentPlayer.actionsDefault();
				tiredPetCounter = 0;
				petCount = 0;
				
				if (finishedPlayers.size() == allPlayers.size()){
					finishedPlayers.clear();
					playerIndex = 0;
					currentDay++;

					if (currentDay > numberOfDays) {
						EndGUI.main(null);
						frame.dispose();
					}
					else {
						for (Player player : allPlayers) {
							for (Pet pet : player.getPetArray()) {
								if (pet.getStatus() == "Alive") {
									pet.defaultActions();
									player.allowance();
									pet.dailyReduction(pet);
									pet.addYear();
								}
							}
						}
						frame.dispose();
						MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
					}
				}
				else {
					playerIndex++;
					frame.dispose();
					MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
				}
			}
			else {
    			final JOptionPane pane = new JOptionPane("Your pet is worn out for today, please select another pet.");
			    final JDialog d = pane.createDialog((JFrame)frame, "");
			    petCount++;
			    d.setLocation(370, 345);
			    d.setVisible(true);
			    frame.dispose();
				MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
			}
		}
		else {
			frame.dispose();
			MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
		}
	}
	
	/**
	 * Method to generate a random number or check attributes, either possibly causing the pet to 
	 * get sick, misbehave, be jealous, or die.
	 */
	public void checkPet() {
		Random chanceNumber = new Random();
		int chanceAnswer = chanceNumber.nextInt(10) + 1;
		Random optionNumber = new Random();
		int optionAnswer = optionNumber.nextInt(3) + 1;
		switch (chanceAnswer) {
			case 1: switch (optionAnswer) {
				case 1: currentPet.isMisbehaving(true);
						break;
				case 2: currentPet.isSick(true);
						break;
				case 3: currentPet.isJealous(true);
						break;
			}
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: break;
		}
		
		currentPet.checkGUI(currentPlayer);
		if (currentPet.getIsSick() == true) {
			sickMessage();
		}
		if (currentPet.getIsMisbehaving() == true) {
			misbehavingMessage();
		}
		if (currentPet.getIsJealous() == true) {
			jealousMessage();
		}
		if (currentPet.getStatus() == "Dead") {
			deadMessage();
		}
		
	}
	
	/**
	 * Based on attributes of the current pet, while open a message frame to convey information.
	 */
	public void sickMessage() {
    	int reply = JOptionPane.showConfirmDialog((JFrame)frame, "Oh no! " + currentPet.getName() 
					+ " is sick! Would you like to take " + currentPet.getGender() 
					+ " to the vet for $100?", "", JOptionPane.YES_NO_OPTION);
    	currentPet.sickGUI(currentPlayer, reply);
    	
    	if (reply == JOptionPane.OK_OPTION) {
    		final JOptionPane errorPane = new JOptionPane(currentPet.getName() + "is feeling much better now!");
    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
    		errorFrame.setLocation(370, 345);
    		errorFrame.setVisible(true);
    	}
	}
	
	/**
	 * Based on attributes of the current pet, while open a message frame to convey information.
	 */
	public void misbehavingMessage() {
		int reply = JOptionPane.showConfirmDialog((JFrame)frame, "Oh no! " + currentPet.getName() 
		+ " is misbehaving. Do you wish to discipline " 
		+ currentPet.getGender() + "?", "", JOptionPane.YES_NO_OPTION);
    	currentPet.misbehaveGUI(reply);	
    	
    	if (reply == JOptionPane.OK_OPTION) {
    		final JOptionPane errorPane = new JOptionPane(currentPet.getName() + "has been disciplined.");
    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
    		errorFrame.setLocation(370, 345);
    		errorFrame.setVisible(true);
    	}
	}
	
	/**
	 * Based on attributes of the current pet, while open a message frame to convey information.
	 */
	public void jealousMessage() {
    	int reply = JOptionPane.showConfirmDialog((JFrame)frame, "Oh no! " + currentPet.getName()
		+ " is jealous. Do you wish to take " + currentPet.getGender() 
		+ " to the pet day spa for $120?", "", JOptionPane.YES_NO_OPTION);
    	currentPet.jealousPetGUI(currentPlayer, reply);
    	
    	if (reply == JOptionPane.OK_OPTION) {
    		final JOptionPane errorPane = new JOptionPane(currentPet.getName() + "loved the spa day!");
    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
    		errorFrame.setLocation(370, 345);
    		errorFrame.setVisible(true);
    	}
		
	}
	
	/**
	 * Based on attributes of the current pet, while open a message frame to convey information.
	 */
	public void deadMessage() {
		
		if (currentPet.getBeenRevived() == true) {
			final JOptionPane errorPane = new JOptionPane("Oh no! " + currentPet.getName() 
											+ " has died. Please select another pet.");
			final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
			errorFrame.setLocation(370, 345);
			errorFrame.setVisible(true);
		}
		else {
	    	int reply = JOptionPane.showConfirmDialog((JFrame)frame, "Oh no! " + currentPet.getName() 
			+ " has died. Do you wish to revive " + currentPet.getGender() 
			+ " for $200?", "", JOptionPane.YES_NO_OPTION);
	    	currentPet.jealousPetGUI(currentPlayer, reply);
	    	
	    	if (reply == JOptionPane.YES_OPTION) {
	    		if (currentPlayer.getFunds() < 200) {
	    			final JOptionPane errorPane = new JOptionPane("Sorry, but you can not afford to revive " 
	    											+ currentPet.getName());
	    			final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
	    			errorFrame.setLocation(370, 345);
	    			errorFrame.setVisible(true);	
		    		currentPet.deadPetGUI();	
	    		}
	    		else {
	    			final JOptionPane errorPane = new JOptionPane("It's a miracle! " + currentPet.getName() + " is alive!");
		    		final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
		    		errorFrame.setLocation(370, 345);
		    		errorFrame.setVisible(true);
		    		currentPet.revivePetGUI(currentPlayer);
	    		}
	    	}
	    	else {
	    		currentPet.deadPetGUI();	
	    	}
    	}
	}
	
	/**
	 * Allows the finishedPlayers array to be reached from other classes.
	 * @return the finishedPlayers array that holds finished players for the day.
	 */
	public static ArrayList<Player> getFinishedPlayers() {
		return finishedPlayers;
	}
	
	/**
	 * Allows the petCount to be reached from other classes.
	 * @return the index of the current pet.
	 */
	public static int getPetCount() {
		return petCount;
	}
	
	/**
	 * Allows the tiredPetCounter to be reached from other classes.
	 * @return the count of pets who have used all their actions for that day.
	 */
	public static int getTiredPetCounter() {
		return tiredPetCounter;
	}
	
	/**
	 * Allows the currentDay to be reached from other classes.
	 * @return the current day that the game is on.
	 */
	public static int getCurrentDay() {
		return currentDay;
	}
}
