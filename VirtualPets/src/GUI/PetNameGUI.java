package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.SwingConstants;
import Game.Player;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PetNameGUI {
	
	private JFrame frame;
	private JTextField textField;
	private static String petName;
	private static ArrayList<Player> playerList;
	private static int playerIndex;
	private static int petCount;
	private static Player currentPlayer;
	private int petMax = 3;
	private ArrayList<Player> finishedPlayers = new ArrayList<Player>();
	private ArrayList<String> usedNames = PlayerGUI.getUsedNames();

	/**
	 * Launch the application.
	 */
	public static void main(int holdPlayerIndex, int holdPetCount) {
		playerList = PlayerGUI.getPlayerList();
		playerIndex = holdPlayerIndex;
		petCount = holdPetCount;
		currentPlayer = playerList.get(playerIndex);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetNameGUI window = new PetNameGUI();
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
	public PetNameGUI() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(139, 80, 444, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose a name for your pet....");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 52, 325, 37);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(105, 105, 237, 48);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(154, 188, 140, 48);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petName = textField.getText();
				boolean isWord = true;
			    char[] chars = petName.toCharArray();
			    for (char c : chars) {
			        if (!Character.isLetter(c)) {
			            isWord = false;
			        }
			    }
			    
				if ((isWord == false) || (petName.length() == 0)) {
					final JOptionPane errorPane = new JOptionPane("Please enter a valid pet name (letters only).");
				    final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
				    errorFrame.setLocation(370, 345);
				    errorFrame.setVisible(true);
				    PetNameGUI.main(playerIndex, petCount);
					frame.dispose();
				}
				else {
					petName = petName.substring(0, 1).toUpperCase() + petName.substring(1).toLowerCase();
					if (usedNames.contains(petName)) {
						final JOptionPane errorPane = new JOptionPane("This name is taken, please enter another name.");
						final JDialog errorFrame = errorPane.createDialog((JFrame)frame, "");
						errorFrame.setLocation(370, 345);
						errorFrame.setVisible(true);
				    	PetNameGUI.main(playerIndex, petCount);
						frame.dispose();
					}
				
					else {
						usedNames.add(petName);
						currentPlayer.getPetArray().get(petCount - 1).setName(petName);
						if (petCount == petMax) {
							playerIndex++;
							petCount = 0;
						}
						if (playerIndex == playerList.size()) {
							playerIndex = 0;
							PlayerGUI.setUsedNames(new ArrayList<String>());
							MainGUI.main(playerIndex, 0, 1, 0, finishedPlayers);
							frame.dispose();
						}
						else {
							PetOptionsGUI.main(playerIndex, petCount);
							frame.dispose();
						}
					}
				}
			}
		});
	}
}
