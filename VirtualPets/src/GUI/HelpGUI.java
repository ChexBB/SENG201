package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;

public class HelpGUI {
	
	int flag;

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpGUI window = new HelpGUI();
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
	public HelpGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 740, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("-----------------------------------OBJECTIVE-----------------------------------");
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(0, 16, 738, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("--------------------------------------PETS----------------------------------------");
		lblNewLabel_1.setBackground(SystemColor.control);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 111, 738, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>To look after your pets of course! In this game your main "
				+ "goal is to care for and play with your pets. Make them happy! The player with the best kept pets wins! </html>");
		lblNewLabel_2.setBackground(SystemColor.control);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(25, 45, 678, 65);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Each player can have up to 3 pets. You get to chose what species of "
				+ "pet you want and get to name it as well! Different species have different preferences. "
				+ "Look over them carefully. Each pet has a health, happiness, bladder and energy attribute. "
				+ "Bad things can happen your pet if certain attributes are neglected, so "
				+ "watch their stats and look after them appropriately in order to prevent these. </html>");
		lblNewLabel_3.setBackground(SystemColor.control);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(21, 148, 697, 125);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("------------------------------------ACTIONS-------------------------------------");
		lblNewLabel_4.setBackground(SystemColor.control);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(0, 278, 738, 41);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>You can perform 2 actions per day per pet. Feeding fills their health "
				+ "while playing with toys helps their happiness. Naps and toilets restore their energy and bladder respectively. "
				+ "Cuddles help them restore a little bit of happiness. This is a free alternatives if "
				+ "you can't afford to buy anything for them to play with!  </html>");
		lblNewLabel_5.setBackground(SystemColor.control);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(28, 320, 690, 110);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.setBounds(511, 453, 192, 53);
		frame.getContentPane().add(btnMainMenu);	
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 0, 704, 430);
		frame.getContentPane().add(panel);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 572);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StartGUI.main(null);
			}
		});
	}
	
	public int getFlag() {
		return flag;
	}
}
