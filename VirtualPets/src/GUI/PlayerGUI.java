package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import Food.Food;
import Game.Player;
import Pet.Pet;
import Toy.Toy;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class PlayerGUI {
	
	private static ArrayList<Player> playerList = new ArrayList<Player>();
	private static String playerName;
	private static int playerNum;
	private static int counter;
	private JFrame frame;
	private JTextField textField;
	private static ArrayList<String> usedNames = new ArrayList<String>();

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(int count, int numberOfPlayers) {
		playerNum = numberOfPlayers;
		counter = count;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerGUI window = new PlayerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public PlayerGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param players 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(231, 143, 262, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPlayerWhatIs = new JLabel("Player #" + counter + " what is your name?");
		lblPlayerWhatIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerWhatIs.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblPlayerWhatIs.setBounds(217, 99, 294, 28);
		frame.getContentPane().add(lblPlayerWhatIs);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnConfirm.setBounds(300, 211, 127, 41);
		frame.getContentPane().add(btnConfirm);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(153, 73, 418, 205);
		frame.getContentPane().add(panel);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = textField.getText();
				boolean isWord = true;
			    char[] chars = playerName.toCharArray();
			    for (char c : chars) {
			        if (!Character.isLetter(c)) {
			            isWord = false;
			        }
			    }
			    
				if ((isWord == false) || (playerName.length() == 0)) {
					final JOptionPane errorPane = new JOptionPane("Please enter a valid player name (letters only).");
				    final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
				    errorFrame.setLocation(370, 345);
				    errorFrame.setVisible(true);
					PlayerGUI.main(counter, playerNum);
					frame.dispose();
				}
				else {
					playerName = playerName.substring(0, 1).toUpperCase() + playerName.substring(1).toLowerCase();
					if (usedNames.contains(playerName)) {
						final JOptionPane errorPane = new JOptionPane("This name is taken, please enter another name.");
					    final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
					    errorFrame.setLocation(370, 345);
					    errorFrame.setVisible(true);
						PlayerGUI.main(counter, playerNum);
						frame.dispose();
					}
					else {
						usedNames.add(playerName);
						counter += 1;
						ArrayList<Toy> toyInventory = new ArrayList<Toy>();
						ArrayList<Food> snackInventory = new ArrayList<Food>();
						ArrayList<Pet> petCollection = new ArrayList<Pet>();
						Player player = new Player(playerName, petCollection, toyInventory, snackInventory, 200, 0);
						playerList.add(player);
						frame.dispose();
						if (counter <= playerNum) {
							PlayerGUI.main(counter, playerNum);
						}
						else {
							PetOptionsGUI.main(0, 0);
						}
					}
				}
			}	
		});
	}
	
	/**
	 * Getter method to obtain the arraylist containing all the players
	 * currently in the game
	 * @return arraylist player
	 */
	public static ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	/**
	 * Getter method to obtain the arraylist containing the players that have
	 * already taken a name. Names are unique so names that are taken are placed here.
	 * this array list is used for testing for duplicate names
	 * @return
	 */
	public static ArrayList<String> getUsedNames() {
		return usedNames;
	} 
	
	/**
	 * Setter method to reset setUsednames for the new game 
	 * @param value arraylist usednames 
	 */
	public static void setUsedNames(ArrayList<String> value) {
		usedNames = value;
	}

}