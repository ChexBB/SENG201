package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Game.Player;
import Toy.Toy;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ToyPurchaseGUI {

	private JFrame frame;
	private static int playerIndex;
	private static Toy toy;
	private static ArrayList<Player> allPlayers;
	private static Player currentPlayer;


	/**
	 * Launch the application.
	 */
	public static void main(int holdPlayerIndex, Toy holdItem) {
		playerIndex = holdPlayerIndex;
		allPlayers = PlayerGUI.getPlayerList();
		currentPlayer = allPlayers.get(playerIndex);
		toy = holdItem;


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToyPurchaseGUI window = new ToyPurchaseGUI();
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
	public ToyPurchaseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 595, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThisProductCosts = new JLabel("COST: $" + toy.getPrice());
		lblThisProductCosts.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisProductCosts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblThisProductCosts.setBounds(175, 92, 237, 39);
		frame.getContentPane().add(lblThisProductCosts);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to purchase this?");
		lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblWouldYouLike.setBounds(168, 213, 261, 39);
		frame.getContentPane().add(lblWouldYouLike);
		
		JButton btnYes = new JButton("YES");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPlayer.getFunds() < toy.getPrice()) {
					final JOptionPane pane = new JOptionPane("Sorry, but your funds are too low to purchase this!");
				    final JDialog d = pane.createDialog((JFrame)frame, "");
				    d.setLocation(370, 345);
				    d.setVisible(true);
				}
				else {
					currentPlayer.addToy(toy);
					currentPlayer.editFunds(toy.getPrice());
					frame.dispose();
				}
				PetStoreGUI.main(playerIndex);
				frame.dispose();
			}
		});
		btnYes.setBounds(347, 279, 158, 48);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PetStoreGUI.main(playerIndex);
				frame.dispose();
			}
		});
		btnNo.setBounds(96, 279, 158, 48);
		frame.getContentPane().add(btnNo);
		
		JLabel lblFunds = new JLabel("FUNDS: $" + currentPlayer.getFunds());
		lblFunds.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFunds.setBounds(28, 12, 147, 39);
		frame.getContentPane().add(lblFunds);
		
		JLabel lblToy = new JLabel(toy.getName());
		lblToy.setHorizontalAlignment(SwingConstants.CENTER);
		lblToy.setFont(new Font("Dialog", Font.BOLD, 18));
		lblToy.setBounds(193, 52, 193, 30);
		frame.getContentPane().add(lblToy);
		
		JLabel lblAttributes = new JLabel(toy.attributesLabel());
		lblAttributes.setBounds(25, 76, 119, 191);
		frame.getContentPane().add(lblAttributes);

	}
}