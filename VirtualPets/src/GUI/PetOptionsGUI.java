package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import Game.Player;
import Pet.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PetOptionsGUI {
	
	private static String playerName;
	private static int petCount;
	private static ArrayList<Player> playerList;
	private static Player currentPlayer;
	private static int playerIndex;
	private static Pet turtle;
	private static Pet chicken;
	private static Pet penguin;
	private static Pet bear;
	private static Pet pig;
	private static Pet dog;
	private static ArrayList<Player> finishedPlayers = new ArrayList<Player>(); 
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(int holdPlayerIndex, int holdPetCount) {
		petCount = holdPetCount;
		playerList = PlayerGUI.getPlayerList(); 
		playerIndex = holdPlayerIndex;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetOptionsGUI window = new PetOptionsGUI();
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
	public PetOptionsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		currentPlayer = playerList.get(playerIndex);
		playerName = currentPlayer.getName();
			
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectPet = new JLabel(playerName + " select your pet species!");
		lblSelectPet.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPet.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSelectPet.setBounds(122, 38, 445, 27);
		frame.getContentPane().add(lblSelectPet);
		
		JButton btnBear = new JButton();
		btnBear.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bear.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnBear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bear = new Bear(null);
				PetStatsGUI.main(petCount, playerIndex, bear);
				frame.dispose();
			}
		});
		btnBear.setBackground(new Color(255, 153, 102));
		btnBear.setBounds(78, 272, 160, 160);
		frame.getContentPane().add(btnBear);
		
		JButton btnChicken = new JButton();
		btnChicken.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/chicken.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chicken = new Chicken(null);
				PetStatsGUI.main(petCount, playerIndex, chicken);
				frame.dispose();
			}
		});
		btnChicken.setBackground(new Color(255, 255, 153));
		btnChicken.setBounds(277, 94, 160, 160);
		frame.getContentPane().add(btnChicken);
		
		
		JButton btnPig = new JButton();
		btnPig.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pig.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnPig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pig = new Pig(null);
				PetStatsGUI.main(petCount, playerIndex, pig);
				frame.dispose();
			}
		});
		btnPig.setBackground(new Color(255, 204, 255));
		btnPig.setBounds(277, 272, 160, 160);
		frame.getContentPane().add(btnPig);
		
		
		JButton btnPenguin = new JButton();
		btnPenguin.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/penguin.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnPenguin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				penguin = new Penguin(null);
				PetStatsGUI.main(petCount, playerIndex, penguin);
				frame.dispose();
			}
		});
		btnPenguin.setBackground(new Color(204, 204, 204));
		btnPenguin.setBounds(476, 94, 160, 160);
		frame.getContentPane().add(btnPenguin);
		
		
		JButton btnDog = new JButton();
		btnDog.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/dog.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dog = new Dog(null);
				PetStatsGUI.main(petCount, playerIndex, dog);
				frame.dispose();
			}
		});
		btnDog.setBackground(new Color(204, 204, 255));
		btnDog.setBounds(476, 272, 160, 160);
		frame.getContentPane().add(btnDog);
		
		JButton btnTurtle = new JButton();
		btnTurtle.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/turtle.png")).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		btnTurtle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turtle = new Turtle(null);
				PetStatsGUI.main(petCount, playerIndex, turtle);
				frame.dispose();
			}
		});
		btnTurtle.setBackground(new Color(153, 204, 153));
		btnTurtle.setBounds(78, 94, 160, 160);
		frame.getContentPane().add(btnTurtle);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(542, 454, 148, 50);
		frame.getContentPane().add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer.getPetArray().size() < 1) {
					final JOptionPane pane = new JOptionPane("Please select at least one pet.");
				    final JDialog d = pane.createDialog((JFrame)frame, "");
				    d.setLocation(370, 345);
				    d.setVisible(true);
					PetOptionsGUI.main(playerIndex, petCount);
					frame.dispose();
				}
				else {
					petCount = 0;
					playerIndex += 1;
					if (playerIndex == playerList.size()) {
						playerIndex = 0;
						MainGUI.main(playerIndex, 0, 1, 0, finishedPlayers);
						frame.dispose();
					}
					else {
						PetOptionsGUI.main(playerIndex, petCount);
						frame.dispose();
					}
				}
			}
		});
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		
		
	}
}
