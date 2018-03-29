package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import Food.*;
import Toy.*;
import Game.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetStoreGUI {

	private static int playerIndex;
	private static ArrayList<Player> allPlayers;
	private static Player currentPlayer;
	private static int funds;
	
	private static Food bacon;
	private static Food berries;
	private static Food cheese;
	private static Food honey;
	private static Food tuna;
	private static Food sardines;
	
	private static Toy ball;
	private static Toy disc;
	private static Toy rope;
	private static Toy rubberDucky;
	private static Toy stick;
	private static Toy teddyBear;
	private static ArrayList<Player> finishedPlayers;
	private static int tiredPetCounter;
	private static int currentDay;
	private static int petCount;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(int holdPlayerIndex) {
		finishedPlayers = MainGUI.getFinishedPlayers();
		tiredPetCounter =  MainGUI.getTiredPetCounter();
		currentDay = MainGUI.getCurrentDay();
		petCount = MainGUI.getPetCount();
		playerIndex = holdPlayerIndex;
		allPlayers = PlayerGUI.getPlayerList();
		currentPlayer = allPlayers.get(playerIndex);
		funds = currentPlayer.getFunds();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PetStoreGUI window = new PetStoreGUI();
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
	public PetStoreGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(null);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		int objectCounter = (currentPlayer.getToyArray().size() + currentPlayer.getSnackArray().size());
		DefaultListModel<String> dlmInventory = new DefaultListModel<String>();
		
		String inventoryHeader = "Inventory: \n";
		dlmInventory.addElement(inventoryHeader);
		
		if ( objectCounter == 0 ) {
			String listItem = "empty";
			dlmInventory.addElement(listItem);
		} 
		else {
			if (currentPlayer.getToyArray().size() > 0) {
				String toyHeader = "-----------Toys-----------";
				dlmInventory.addElement(toyHeader);
			}
			
			for (Toy toy : currentPlayer.getToyArray() ) {
				String toyItem = toy.getName();
				dlmInventory.addElement(toyItem);
			}
			
			if (currentPlayer.getSnackArray().size() > 0) {
				String snackHeader = "----------Snacks----------";
				dlmInventory.addElement(snackHeader);
			}
			
			for (Food snack : currentPlayer.getSnackArray() ) {
				String snackItem = snack.getName();
				dlmInventory.addElement(snackItem);
			}
		}
		
		JList<String> inventoryList = new JList<String>(dlmInventory);
		inventoryList.setBounds(488, 133, 203, 305);
		inventoryList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(inventoryList);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(488, 133, 205, 307);
		panel.add(scrollPane);
		scrollPane.setVisible(true);
		
		JLabel lblTitle = new JLabel("Welcome to the Petville Pet Store!");
		lblTitle.setBounds(151, 17, 453, 33);
		panel.add(lblTitle);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 22));
		
		JLabel lblFunds = new JLabel("FUNDS: $" + funds);
		lblFunds.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFunds.setBounds(512, 91, 152, 33);
		panel.add(lblFunds);
		
		JLabel lblFood = new JLabel("FOOD");
		lblFood.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFood.setBounds(107, 94, 69, 27);
		panel.add(lblFood);
		
		JLabel lblToys = new JLabel("TOYS");
		lblToys.setFont(new Font("Dialog", Font.BOLD, 18));
		lblToys.setBounds(330, 94, 63, 27);
		panel.add(lblToys);
		
		JButton btnBacon = new JButton();
		btnBacon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bacon.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnBacon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bacon = new Bacon();
				SnackPurchaseGUI.main(playerIndex, bacon);
				frame.dispose();
			}
		});
		btnBacon.setBounds(29, 133, 100, 100);
		panel.add(btnBacon);
		
		JButton btnBerries = new JButton();
		btnBerries.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/berries.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnBerries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berries = new Berries();
				SnackPurchaseGUI.main(playerIndex, berries);
				frame.dispose();
			}
		});
		btnBerries.setBounds(136, 133, 100, 100);
		panel.add(btnBerries);
		
		JButton btnCheese = new JButton();
		btnCheese.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cheese.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheese = new Cheese();
				SnackPurchaseGUI.main(playerIndex, cheese);
				frame.dispose();
			}
		});
		btnCheese.setBounds(29, 237, 100, 100);
		panel.add(btnCheese);
		
		JButton btnHoney = new JButton();
		btnHoney.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/honey.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnHoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				honey = new Honey();
				SnackPurchaseGUI.main(playerIndex, honey);
				frame.dispose();
			}
		});
		btnHoney.setBounds(136, 237, 100, 100);
		panel.add(btnHoney);
		
		JButton btnTuna = new JButton();
		btnTuna.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tuna.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnTuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tuna = new Tuna();
				SnackPurchaseGUI.main(playerIndex, tuna);
				frame.dispose();
			}
		});
		btnTuna.setBounds(136, 340, 100, 100);
		panel.add(btnTuna);
		
		JButton btnSardines = new JButton();
		btnSardines.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/sardines.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnSardines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sardines = new Sardines();
				SnackPurchaseGUI.main(playerIndex, sardines);
				frame.dispose();
			}
		});
		btnSardines.setBounds(29, 340, 100, 100);
		panel.add(btnSardines);
		
		JButton btnBall = new JButton();
		btnBall.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ball.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnBall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ball = new Ball();
				ToyPurchaseGUI.main(playerIndex, ball);
				frame.dispose();
			}
		});
		btnBall.setBounds(251, 133, 100, 100);
		panel.add(btnBall);
		
		JButton btnDisc = new JButton();
		btnDisc.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/disc.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disc = new Disc();
				ToyPurchaseGUI.main(playerIndex, disc);
				frame.dispose();
			}
		});
		btnDisc.setBounds(360, 133, 100, 100);
		panel.add(btnDisc);
		
		JButton btnRope = new JButton();
		btnRope.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rope.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnRope.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rope = new Rope();
				ToyPurchaseGUI.main(playerIndex, rope);
				frame.dispose();
			}
		});
		btnRope.setBounds(251, 237, 100, 100);
		panel.add(btnRope);
		
		JButton buttonDuck = new JButton();
		buttonDuck.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rubberDucky.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		buttonDuck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rubberDucky = new RubberDucky();
				ToyPurchaseGUI.main(playerIndex, rubberDucky);
				frame.dispose();
			}
		});
		buttonDuck.setBounds(360, 237, 100, 100);
		panel.add(buttonDuck);
		
		JButton btnStick = new JButton();
		btnStick.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/stick.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnStick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stick = new Stick();
				ToyPurchaseGUI.main(playerIndex, stick);
				frame.dispose();
			}
		});
		btnStick.setBounds(251, 340, 100, 100);
		panel.add(btnStick);
		
		JButton btnTeddyBear = new JButton();
		btnTeddyBear.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teddyBear.png")).getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH)));
		btnTeddyBear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teddyBear = new TeddyBear();
				ToyPurchaseGUI.main(playerIndex, teddyBear);
				frame.dispose();
			}
		});
		btnTeddyBear.setBounds(360, 340, 100, 100);
		panel.add(btnTeddyBear);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI.main(playerIndex, petCount, currentDay, tiredPetCounter, finishedPlayers);
				frame.dispose();
			}
		});
		btnGoBack.setBounds(293, 516, 131, 33);
		panel.add(btnGoBack);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 749, 561);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/storebackground.png")));
		panel.add(lblBackground);
		
	}
}