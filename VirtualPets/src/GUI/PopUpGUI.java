package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class PopUpGUI {
	
	private int count = 1;
	private int numberOfPlayers = 2;
	private static int numberOfDays = 15;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpGUI window = new PopUpGUI();
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
	public PopUpGUI() {
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
		
		JLabel lblNewLabel = new JLabel("How many days do you wish to play for?");
		lblNewLabel.setBounds(78, 67, 458, 53);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(51, 36, 611, 281);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDayDisplay = new JLabel("15");
		lblDayDisplay.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDayDisplay.setBounds(428, 42, 32, 29);
		panel.add(lblDayDisplay);
		
		JLabel lblNewLabel_1 = new JLabel("How many players are there?");
		lblNewLabel_1.setBounds(27, 131, 285, 38);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JSlider numPlayersSlider = new JSlider(1, 3);
		numPlayersSlider.setBounds(27, 168, 242, 54);
		panel.add(numPlayersSlider);
		numPlayersSlider.setMinorTickSpacing(1);
		numPlayersSlider.setForeground(Color.LIGHT_GRAY);
		numPlayersSlider.setMajorTickSpacing(1);
		numPlayersSlider.setMinimum(1);
		numPlayersSlider.setMaximum(3);
		numPlayersSlider.setBackground(SystemColor.control);
		numPlayersSlider.setSnapToTicks(true);
		
		
		JSlider numDaysSlider = new JSlider(1, 30);
		numDaysSlider.setSnapToTicks(true);
		numDaysSlider.setMinorTickSpacing(1);
		numDaysSlider.setMinimum(1);
		numDaysSlider.setMaximum(30);
		numDaysSlider.setMajorTickSpacing(1);
		numDaysSlider.setForeground(Color.LIGHT_GRAY);
		numDaysSlider.setBackground(SystemColor.control);
		numDaysSlider.setBounds(27, 73, 540, 61);
		panel.add(numDaysSlider);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setBounds(444, 217, 123, 41);
		panel.add(btnConfirm);
		btnConfirm.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		JLabel numPlayerslabel = new JLabel("2");
		numPlayerslabel.setHorizontalAlignment(SwingConstants.CENTER);
		numPlayerslabel.setFont(new Font("Dialog", Font.BOLD, 18));
		numPlayerslabel.setBounds(324, 139, 32, 22);
		panel.add(numPlayerslabel);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerGUI.main(count, numberOfPlayers);
				frame.dispose();
			}
		});
		numPlayersSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent move) {
				JSlider movement =  (JSlider) move.getSource();
				numberOfPlayers = movement.getValue();
				numPlayerslabel.setText("" + movement.getValue());
				
			}
		});
		
		numDaysSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent move) {
				JSlider movement =  (JSlider) move.getSource();
				lblDayDisplay.setText("" + movement.getValue());
				numberOfDays = movement.getValue();
			}
		});
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 738, 561);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png")));
	}	
	
	/**
	 * Getter method to obtain number of days as chosen by the user
	 * used to control how many main gui menus are run for each pet and player
	 * @return int numberofdays 
	 */
	public static int getNumberOfDays() {
		return numberOfDays;
	}
}