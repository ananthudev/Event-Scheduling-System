package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Help() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\ESS\\Event-Scheduling-System\\image\\mini.jpg"));
		setTitle("Help");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Main Page");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				Window frame = null;
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(80, 174, 220));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(417, 661, 116, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_1_3_4_1_2 = new JLabel("HOD can create events and show events.");
		lblNewLabel_2_1_1_1_3_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_4_1_2.setBounds(47, 630, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_4_1_2);
		
		JLabel lblNewLabel_2_1_1_1_3_4 = new JLabel("Event Details: Enter the event title, date, time, hall, and any other relevant information");
		lblNewLabel_2_1_1_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_4.setBounds(47, 552, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_4);
		
		JLabel lblNewLabel_2_1_1_1_3_3 = new JLabel("New Event: Click on the \"Create Event\" button or navigate to the \"Events\" section to create a new event.\n");
		lblNewLabel_2_1_1_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_3.setBounds(47, 513, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_3);
		
		JLabel lblNewLabel_2_1_1_1_3_2 = new JLabel("Scheduling an Event:\n");
		lblNewLabel_2_1_1_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_2.setBounds(47, 474, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_2);
		
		JLabel lblNewLabel_2_1_1_1_3_1 = new JLabel("It provides an overview of your scheduled events");
		lblNewLabel_2_1_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_1.setBounds(47, 435, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_1);
		
		JLabel lblNewLabel_2_1_1_1_3 = new JLabel("Overview: Upon logging in, you will be presented with the application's dashboard");
		lblNewLabel_2_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3.setBounds(47, 396, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Dashboard:");
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_2.setBounds(47, 357, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("User Registration: Create an account or log in if you already have one.\n");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_1.setBounds(47, 329, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Installation: Follow the installation instructions provided to set up the Event Scheduling System on your desktop.\n");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(47, 290, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Getting Started:\n");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(47, 251, 900, 29);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\logo.png"));
		lblNewLabel_1.setBounds(0, 11, 200, 160);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Whether you're new to the system or need assistance with specific features, this resource will provide you with the necessary information.\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(47, 220, 900, 29);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1_1_3_4_1 = new JLabel("Participants: Admin can accept / decline event requests and show events.\n");
		lblNewLabel_2_1_1_1_3_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_3_4_1.setBounds(47, 591, 900, 29);
		contentPane.add(lblNewLabel_2_1_1_1_3_4_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\v960-ning-11.jpg"));
		lblNewLabel.setBounds(0, 0, 978, 720);
		contentPane.add(lblNewLabel);
	}
}
