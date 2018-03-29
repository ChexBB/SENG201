package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StartGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGUI window = new StartGUI();
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
	public StartGUI() {
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
		frame.setResizable(false);
		
		JLabel lblWelcomeToVirtual = new JLabel("Welcome to Petville!");
		lblWelcomeToVirtual.setFont(new Font("EB Garamond 08", Font.BOLD, 55));
		lblWelcomeToVirtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToVirtual.setBounds(70, 177, 580, 107);
		frame.getContentPane().add(lblWelcomeToVirtual);
		
		JButton btnHelpInfo = new JButton("HELP INFO");
		btnHelpInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHelpInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpGUI.main(null);
				frame.dispose();
			}
		});
		btnHelpInfo.setBounds(434, 406, 192, 53);
		frame.getContentPane().add(btnHelpInfo);
		
		JButton btnStartGame = new JButton("START GAME");
		btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStartGame.setBounds(94, 406, 192, 53);
		frame.getContentPane().add(btnStartGame);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
		
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PopUpGUI.main(null);
			}
		});
	}
}
