package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HodWindow {

	private JFrame frmHodPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HodWindow window = new HodWindow();
					window.frmHodPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HodWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHodPanel = new JFrame();
		frmHodPanel.setTitle("HOD Panel");
		frmHodPanel.getContentPane().setBackground(new Color(0, 128, 128));
		frmHodPanel.getContentPane().setLayout(null);
		
		JLabel lblHodPanel = new JLabel("HOD Panel");
		lblHodPanel.setForeground(Color.WHITE);
		lblHodPanel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblHodPanel.setBounds(301, 102, 214, 43);
		frmHodPanel.getContentPane().add(lblHodPanel);
		
		JButton btnCreateRequest = new JButton("Create Request");
		btnCreateRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateRequest.setBounds(118, 312, 181, 86);
		frmHodPanel.getContentPane().add(btnCreateRequest);
		
		JButton btnViewAllEvents = new JButton("View All Events");
		btnViewAllEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewAllEvents.setBounds(497, 312, 181, 86);
		frmHodPanel.getContentPane().add(btnViewAllEvents);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(638, 516, 135, 58);
		frmHodPanel.getContentPane().add(btnNewButton_1);
		frmHodPanel.setBounds(100, 100, 874, 703);
		frmHodPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
