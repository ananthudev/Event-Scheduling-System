package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

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
					Home frame = new Home();
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
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\ESS\\Event-Scheduling-System\\image\\mini.jpg"));
		setTitle("E - Event Plan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Help");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBackground(new Color(108, 182, 255));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(540, 355, 179, 98);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reg1 reg1 = new Reg1();
				reg1.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(108, 182, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(205, 355, 179, 98);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to E-EVENTPLAN, the ultimate desktop application for event planning and management, approved by administrators.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 147, 1105, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setDisabledIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\v960-ning-11.jpg"));
		lblNewLabel_2.setSize(new Dimension(10, 0));
		lblNewLabel_2.setMinimumSize(new Dimension(5, 5));
		lblNewLabel_2.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\logo.png"));
		lblNewLabel_2.setBounds(10, 0, 200, 136);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("With E-EVENTPLAN, you can seamlessly create, organize, and execute events with ease and efficiency.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(120, 185, 731, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Whether you're a professional event planner or an individual looking to host a gathering, E-EVENTPLAN has got you covered.");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(38, 216, 940, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\v960-ning-11.jpg"));
		lblNewLabel.setBounds(0, 0, 978, 720);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(540, 355, 179, 98);
		contentPane.add(btnNewButton_1);
		
	}
}
