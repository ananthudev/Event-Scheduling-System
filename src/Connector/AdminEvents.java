package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JButton;

public class AdminEvents {

	private JFrame frmAdminEvents;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEvents window = new AdminEvents();
					window.frmAdminEvents.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminEvents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminEvents = new JFrame();
		frmAdminEvents.getContentPane().setForeground(new Color(255, 255, 255));
		frmAdminEvents.setTitle("Admin Events");
		frmAdminEvents.getContentPane().setBackground(new Color(0, 128, 128));
		frmAdminEvents.getContentPane().setLayout(null);
		
		JLabel lblEndTime_2 = new JLabel("End Time");
		lblEndTime_2.setForeground(Color.WHITE);
		lblEndTime_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndTime_2.setBounds(73, 422, 165, 60);
		frmAdminEvents.getContentPane().add(lblEndTime_2);
		
		JLabel lblAdminEvents = new JLabel("Admin Events");
		lblAdminEvents.setForeground(Color.WHITE);
		lblAdminEvents.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblAdminEvents.setBounds(299, 95, 283, 43);
		frmAdminEvents.getContentPane().add(lblAdminEvents);
		
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(73, 264, 116, 60);
		frmAdminEvents.getContentPane().add(lblNewLabel);
		
		JLabel lblRequestedHall = new JLabel("Requested Hall");
		lblRequestedHall.setForeground(Color.WHITE);
		lblRequestedHall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequestedHall.setBounds(73, 303, 165, 60);
		frmAdminEvents.getContentPane().add(lblRequestedHall);
		
		JLabel lblStartTime = new JLabel("Date");
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartTime.setBounds(73, 340, 165, 60);
		frmAdminEvents.getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("Start Time");
		lblEndTime.setForeground(Color.WHITE);
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndTime.setBounds(73, 380, 165, 60);
		frmAdminEvents.getContentPane().add(lblEndTime);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(229, 287, 132, 20);
		frmAdminEvents.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 326, 132, 20);
		frmAdminEvents.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 363, 132, 20);
		frmAdminEvents.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(229, 403, 132, 20);
		frmAdminEvents.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(229, 445, 132, 20);
		frmAdminEvents.getContentPane().add(textField_4);
		
		JLabel lblEndTime_2_1 = new JLabel("AM or PM");
		lblEndTime_2_1.setForeground(Color.WHITE);
		lblEndTime_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndTime_2_1.setBounds(73, 463, 165, 60);
		frmAdminEvents.getContentPane().add(lblEndTime_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(229, 486, 132, 20);
		frmAdminEvents.getContentPane().add(textField_5);
		
		JButton btnNewButton = new JButton("Approve");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(94, 546, 89, 23);
		frmAdminEvents.getContentPane().add(btnNewButton);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeny.setBounds(229, 546, 89, 23);
		frmAdminEvents.getContentPane().add(btnDeny);
		frmAdminEvents.setBounds(100, 100, 874, 703);
		frmAdminEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
