package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class AdminEvents {

	private JFrame frmAdminEvents;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable table;

	private Connection connection;
	private DefaultTableModel tableModel;
	private JComboBox<Object> comboBox;

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

		JLabel lblAdminEvents = new JLabel("Admin Events");
		lblAdminEvents.setForeground(Color.WHITE);
		lblAdminEvents.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblAdminEvents.setBounds(303, 129, 283, 43);
		frmAdminEvents.getContentPane().add(lblAdminEvents);
		tableModel = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Department", "Event Name", "Start Time", "End Time"
			}
		);

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

		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStartTime.setBounds(30, 306, 165, 60);
		frmAdminEvents.getContentPane().add(lblStartTime);

		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setForeground(Color.WHITE);
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndTime.setBounds(30, 349, 165, 60);
		frmAdminEvents.getContentPane().add(lblEndTime);

		JLabel lblRequestedHall = new JLabel("Allocate Hall");
		lblRequestedHall.setBounds(30, 387, 144, 60);
		frmAdminEvents.getContentPane().add(lblRequestedHall);
		lblRequestedHall.setForeground(Color.WHITE);
		lblRequestedHall.setFont(new Font("Tahoma", Font.PLAIN, 18));

		textField = new JTextField();
		textField.setBounds(158, 241, 205, 23);
		frmAdminEvents.getContentPane().add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(158, 287, 205, 23);
		frmAdminEvents.getContentPane().add(textField_2);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(158, 326, 205, 23);
		frmAdminEvents.getContentPane().add(textField_4);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(158, 369, 205, 23);
		frmAdminEvents.getContentPane().add(textField_6);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Select Hall", "MINI HALL", "LOMA HALL", "DHWANI HALL", "MAIN HALL", "CONFERENCE HALL"}));
		comboBox.setBounds(158, 409, 205, 22);
		frmAdminEvents.getContentPane().add(comboBox);

		// Assign the comboBox object to the class member variable
		this.comboBox = comboBox;

		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        // Check if any field is empty
			        if (textField.getText().isEmpty() || textField_2.getText().isEmpty() ||
			            textField_4.getText().isEmpty() || textField_6.getText().isEmpty() ||
			            comboBox.getSelectedItem().toString().equals("Select Hall")) {
			            JOptionPane.showMessageDialog(frmAdminEvents, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
			        } else {
			            // Update hall and status in the events table
			            updateHallAndStatus("Approved");

			            // Refresh the JTable
			            populateTable();

			            JOptionPane.showMessageDialog(frmAdminEvents, "Event approved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			            clearFields();
			        }
			    }

			    private void updateHallAndStatus(String status) {
			        int selectedRow = table.getSelectedRow();
			        if (selectedRow != -1) {
			            String department = table.getValueAt(selectedRow, 0).toString();
			            String eventName = table.getValueAt(selectedRow, 1).toString();
			            String eventStart = table.getValueAt(selectedRow, 2).toString();
			            String eventEnd = table.getValueAt(selectedRow, 3).toString();
			            String hall = comboBox.getSelectedItem().toString();
			            
			            try {
			                PreparedStatement stmt = connection.prepareStatement("UPDATE events SET status = ?, hall = ? WHERE department = ? AND eventname = ? AND eventstart = ? AND eventend = ?");
			                stmt.setString(1, status);
			                stmt.setString(2, hall);
			                stmt.setString(3, department);
			                stmt.setString(4, eventName);
			                stmt.setString(5, eventStart);
			                stmt.setString(6, eventEnd);
			                
			                int rowsUpdated = stmt.executeUpdate();
			                if (rowsUpdated > 0) {
			                    JOptionPane.showMessageDialog(frmAdminEvents, "Hall and status updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			                } else {
			                    JOptionPane.showMessageDialog(frmAdminEvents, "Failed to update hall and status", "Error", JOptionPane.ERROR_MESSAGE);
			                }
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(frmAdminEvents, "An error occurred while updating hall and status", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    }

			    private void clearFields() {
			        textField.setText("");
			        textField_2.setText("");
			        textField_4.setText("");
			        textField_6.setText("");
			        comboBox.setSelectedIndex(0);
			    }
			});

		btnApprove.setForeground(new Color(0, 0, 0));
		btnApprove.setBackground(new Color(255, 255, 255));
		btnApprove.setBounds(92, 478, 100, 32);
		frmAdminEvents.getContentPane().add(btnApprove);

		JButton btnDeny = new JButton("Deny");
		btnDeny.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Check if any of the fields are empty
		        if (textField.getText().isEmpty() || textField_2.getText().isEmpty()
		                || textField_4.getText().isEmpty() || textField_6.getText().isEmpty()
		                || comboBox.getSelectedItem() == null) {
		            JOptionPane.showMessageDialog(frmAdminEvents, "Please fill in all fields", "Error",
		                    JOptionPane.ERROR_MESSAGE);
		        } else {
		            // Update status in the events table
		            updateStatus("Denied");

		            // Refresh the JTable
		            populateTable();

		            JOptionPane.showMessageDialog(frmAdminEvents, "Event denied successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		            clearFields();
		        }
		    }

		    private void updateStatus(String status) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            String department = table.getValueAt(selectedRow, 0).toString();
		            String eventName = table.getValueAt(selectedRow, 1).toString();
		            String eventStart = table.getValueAt(selectedRow, 2).toString();
		            String eventEnd = table.getValueAt(selectedRow, 3).toString();
		            String hall = "";

		            if (status.equals("Approved")) {
		                hall = comboBox.getSelectedItem().toString();
		            }

		            try {
		                PreparedStatement stmt = connection.prepareStatement("UPDATE events SET status = ?, hall = ? WHERE department = ? AND eventname = ? AND eventstart = ? AND eventend = ?");
		                stmt.setString(1, status);
		                stmt.setString(2, hall);
		                stmt.setString(3, department);
		                stmt.setString(4, eventName);
		                stmt.setString(5, eventStart);
		                stmt.setString(6, eventEnd);

		                int rowsUpdated = stmt.executeUpdate();
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(frmAdminEvents, "Status updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(frmAdminEvents, "Failed to update status", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(frmAdminEvents, "An error occurred while updating status", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        }
		    }




			private void clearFields() {
				// TODO Auto-generated method stub
				
			}
		});



		btnDeny.setForeground(new Color(0, 0, 0));
		btnDeny.setBackground(new Color(255, 255, 255));
		btnDeny.setBounds(204, 478, 100, 32);
		frmAdminEvents.getContentPane().add(btnDeny);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\refresh.png"));
		btnRefresh.setBounds(618, 439, 81, 57);
		frmAdminEvents.getContentPane().add(btnRefresh);

		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				populateTable();
			}
		});
		
		

		

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Department", "Event Name", "Start Time", "End Time"
			}
		);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(127);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setBounds(398, 244, 494, 162);
		frmAdminEvents.getContentPane().add(scrollPane1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		btnNewButton.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\home.png"));
		btnNewButton.setBounds(55, 69, 105, 81);
		frmAdminEvents.getContentPane().add(btnNewButton);

		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				String department = table.getValueAt(selectedRow, 0) != null ? table.getValueAt(selectedRow, 0).toString() : "";
				String eventName = table.getValueAt(selectedRow, 1) != null ? table.getValueAt(selectedRow, 1).toString() : "";
				String eventStart = table.getValueAt(selectedRow, 2) != null ? table.getValueAt(selectedRow, 2).toString() : "";
				String eventEnd = table.getValueAt(selectedRow, 3) != null ? table.getValueAt(selectedRow, 3).toString() : "";

				textField.setText(department);
				textField_2.setText(eventName);
				textField_4.setText(eventStart);
				textField_6.setText(eventEnd);
				comboBox.setSelectedIndex(0);
			}
		});

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

			String query = "SELECT department, eventname, eventstart, eventend FROM events";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String department = resultSet.getString("department");
				String eventName = resultSet.getString("eventname");
				String eventStart = resultSet.getString("eventstart");
				String eventEnd = resultSet.getString("eventend");

				Object[] row = { department, eventName, eventStart, eventEnd };
				tableModel.addRow(row);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	}



