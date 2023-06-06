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
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminEvents {

	private JFrame frmAdminEvents;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable table;

	private Connection connection;
	private DefaultTableModel tableModel;
	private JButton btnDelete;

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
		establishConnection();
		populateTable();
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
		lblEndTime_2.setBounds(30, 380, 165, 60);
		frmAdminEvents.getContentPane().add(lblEndTime_2);
		
		table = new JTable();
		tableModel = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Department", "Event Name", "Hall", "Start Time", "End Time"
			}
		);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(137);
		table.getColumnModel().getColumn(4).setPreferredWidth(151);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(398, 244, 494, 162);
		frmAdminEvents.getContentPane().add(scrollPane);

		JLabel lblAdminEvents = new JLabel("Admin Events");
		lblAdminEvents.setForeground(Color.WHITE);
		lblAdminEvents.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblAdminEvents.setBounds(299, 95, 283, 43);
		frmAdminEvents.getContentPane().add(lblAdminEvents);

		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartTime.setBounds(30, 346, 165, 60);
		frmAdminEvents.getContentPane().add(lblStartTime);
		
		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String department = table.getValueAt(selectedRow, 0) != null ? table.getValueAt(selectedRow, 0).toString() : "";
				String eventName = table.getValueAt(selectedRow, 1) != null ? table.getValueAt(selectedRow, 1).toString() : "";
				String hall = table.getValueAt(selectedRow, 2) != null ? table.getValueAt(selectedRow, 2).toString() : "";
				String startTime = table.getValueAt(selectedRow, 3) != null ? table.getValueAt(selectedRow, 3).toString() : "";
				String endTime = table.getValueAt(selectedRow, 4) != null ? table.getValueAt(selectedRow, 4).toString() : "";

				textField.setText(department);
				textField_2.setText(eventName);
				textField_3.setText(hall);
				textField_4.setText(startTime);
				textField_6.setText(endTime);
			}
		});

		JButton btnAdd = new JButton("Approve");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(74, 464, 100, 32);
		frmAdminEvents.getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Deny");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(214, 464, 100, 32);
		frmAdminEvents.getContentPane().add(btnUpdate);
		
	
						
		textField_3 = new JTextField();
		textField_3.setBounds(158, 325, 205, 23);
		frmAdminEvents.getContentPane().add(textField_3);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
								
		textField_4 = new JTextField();
		textField_4.setBounds(158, 362, 205, 23);
		frmAdminEvents.getContentPane().add(textField_4);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
										
		textField_6 = new JTextField();
		textField_6.setBounds(158, 396, 205, 23);
		frmAdminEvents.getContentPane().add(textField_6);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
												
		textField = new JTextField();
		textField.setBounds(158, 241, 205, 23);
		frmAdminEvents.getContentPane().add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
														
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setBounds(30, 225, 116, 60);
		frmAdminEvents.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
																
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(30, 267, 116, 60);
		frmAdminEvents.getContentPane().add(lblEventName);
		lblEventName.setForeground(Color.WHITE);
		lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 18));
																		
		textField_2 = new JTextField();
		textField_2.setBounds(158, 287, 205, 23);
		frmAdminEvents.getContentPane().add(textField_2);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
																				
		JLabel lblRequestedHall = new JLabel("Hall Requested");
		lblRequestedHall.setBounds(30, 309, 144, 60);
		frmAdminEvents.getContentPane().add(lblRequestedHall);
		lblRequestedHall.setForeground(Color.WHITE);
		lblRequestedHall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton lblNewLabel_1 = new JButton("");
		lblNewLabel_1.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\refresh.png"));
		lblNewLabel_1.setBounds(618, 439, 81, 57);
		frmAdminEvents.getContentPane().add(lblNewLabel_1);

		frmAdminEvents.setBounds(100, 100, 914, 720);
		frmAdminEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Establishes the database connection.
	 */
	private void establishConnection() {
		String url = "jdbc:mysql://localhost:3306/ess";
		String username = "root";
		String password = "system";

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Populates the table with data from the database.
	 */
	private void populateTable() {
	    try {
	        // Clear existing data in the table
	        tableModel.setRowCount(0);

	        String query = "SELECT * FROM events";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            String department = resultSet.getString("department");
	            String eventName = resultSet.getString("eventname");
	            String hall = resultSet.getString("hall");
	            String eventStart = resultSet.getString("eventstart");
	            String eventEnd = resultSet.getString("eventend");
	            Object[] row = { department, eventName, hall, eventStart, eventEnd };
	            tableModel.addRow(row);
	        }

	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
}
