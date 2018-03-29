package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import Game.Player;
import Pet.Pet;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class PetStatsGUI {

	private static int petCount;
	private static int playerIndex;
	private static ArrayList<Player> playerList;
	private static Pet petOption;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(int holdPetCount, int holdPlayerIndex, Pet holdPetOption) {
		petCount = holdPetCount;
		playerIndex = holdPlayerIndex;
		playerList = PlayerGUI.getPlayerList();
		petOption = holdPetOption;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetStatsGUI window = new PetStatsGUI();
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
	public PetStatsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGoBack.setBounds(86, 435, 148, 51);
		frame.getContentPane().add(btnGoBack);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetOptionsGUI.main(playerIndex, petCount);
				frame.dispose();
			}
		});

		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirm.setBounds(478, 435, 148, 51);
		frame.getContentPane().add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				petCount += 1;
				playerList.get(playerIndex).getPetArray().add(petOption);
				frame.dispose();
				PetNameGUI.main(playerIndex, petCount);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(86, 31, 540, 315);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblPicture = new JLabel();
		lblPicture.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(petOption.getIcon())).getImage().getScaledInstance(150, 250, java.awt.Image.SCALE_SMOOTH)));
		lblPicture.setBounds(338, 63, 202, 208);
		panel.add(lblPicture);
		lblPicture.setOpaque(true);
		lblPicture.setText("");
		lblPicture.setBackground(SystemColor.control);
		
		JLabel lblHeader = new JLabel("Would you like to purchase this pet?");
		lblHeader.setBounds(0, 16, 540, 30);
		panel.add(lblHeader);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblspecies = new JLabel("<html>Species: " + petOption.getSpecies() + "<br>Gender: " + petOption.getPetGender() 
							+  "<br> Age: " + petOption.getAge() + " day(s)" + "<br> Weight: " + petOption.getWeight() + " kg" 
							+ "<br> Personality: " + petOption.getPersonality() + "<br> Favourite Food: " + petOption.getFavFood() 
							+ "<br> Favourtie Toy: " + petOption.getFavToy() + "<br> Toy Damage: " + petOption.getToyDamage() + "<br></html>");
		lblspecies.setBounds(15, 55, 346, 239);
		panel.add(lblspecies);
		lblspecies.setHorizontalAlignment(SwingConstants.LEFT);
		lblspecies.setOpaque(true);
		lblspecies.setBackground(SystemColor.control);
		lblspecies.setFont(new Font("Dialog", Font.BOLD, 19));
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
	
	}
}
