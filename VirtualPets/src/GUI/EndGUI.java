package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Game.Player;
import Pet.Pet;

import java.awt.Font;
import java.util.ArrayList;



public class EndGUI {
	
	private JFrame frame;
	private ArrayList<Player> playerList = PlayerGUI.getPlayerList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndGUI window = new EndGUI();
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
	public EndGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int numberOfPlayers = playerList.size();
		
		int total = 0;
		int index = 0;
		for (Player player : playerList) {
			for (Pet pet : playerList.get(index).getPetArray()) {
				total += pet.getScore();
			}
			player.setScore(total);
			index++;
	    }
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(103, 57, 510, 336);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Player winnerPlayer = playerList.get(0);
		for (Player player : playerList) {
			if(player.getScore() > winnerPlayer.getScore()) {
				winnerPlayer = player;
			}
		}
		playerList.remove(winnerPlayer);
		
		JLabel lblWinnerName = new JLabel(winnerPlayer.getName() + " (" + winnerPlayer.getScore() + " points)");
		lblWinnerName.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblWinnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerName.setBounds(0, 124, 510, 63);
		panel.add(lblWinnerName);
		
		if (numberOfPlayers > 1) {
			Player secondPlayer = playerList.get(0);
			for (Player player : playerList) {
				if(player.getScore() > secondPlayer.getScore()) {
					secondPlayer = player;
				}
			}
			playerList.remove(secondPlayer);
			JLabel lblSecondPlace = new JLabel("2. " + secondPlayer.getName() + " (" + secondPlayer.getScore() + " points)");
			lblSecondPlace.setHorizontalAlignment(SwingConstants.CENTER);
			lblSecondPlace.setBounds(0, 179, 510, 63);
			panel.add(lblSecondPlace);
		}
		
		if (numberOfPlayers > 2) {
			Player thirdPlayer = playerList.get(0);
			playerList.remove(0);
			JLabel lblThirdPlace = new JLabel("3. " + thirdPlayer.getName() + " (" + thirdPlayer.getScore() + " points)");
			lblThirdPlace.setHorizontalAlignment(SwingConstants.CENTER);
			lblThirdPlace.setBounds(0, 236, 510, 63);
			panel.add(lblThirdPlace);
		}

		JLabel lblWinnerHeader = new JLabel("AND THE WINNER IS....");
		lblWinnerHeader.setForeground(Color.ORANGE);
		lblWinnerHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerHeader.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblWinnerHeader.setBounds(0, 72, 510, 63);
		panel.add(lblWinnerHeader);

		
		JLabel lblGoodGame = new JLabel("GOOD GAME!");
		lblGoodGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoodGame.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblGoodGame.setForeground(new Color(255, 182, 193));
		lblGoodGame.setBounds(0, 0, 510, 82);
		panel.add(lblGoodGame);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));

	}
}