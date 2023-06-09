package Connector;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class HodAll extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodAll frame = new HodAll();
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
    public HodAll() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 757);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pending Requests");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNewLabel.setBounds(349, 112, 423, 109);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Event Name", "Event Start", "Event End", "Status" }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(194, 281, 628, 267);
        contentPane.add(scrollPane);

        // Call the method to load requests
        loadRequests();
    }

    private void loadRequests() {
        try {
            // Retrieve user's department based on login credentials
            String username = "username";
            String password = "password";
            String department = getDepartment(username, password);

            // Fetch requests from the events table for the user's department
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
            String sql = "SELECT eventname, eventstart, eventend, status FROM events WHERE department = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();

            // Populate the table with the fetched request data
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            while (rs.next()) {
                String eventName = rs.getString("eventname");
                String eventStart = rs.getString("eventstart");
                String eventEnd = rs.getString("eventend");
                String status = rs.getString("status");
                model.addRow(new Object[] { eventName, eventStart, eventEnd, status });
            }

            // Close the database connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getDepartment(String username, String password) {
        String department = "";
        try {
            // Fetch user's department based on login credentials from the reg table
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
            String sql = "SELECT department FROM reg WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // Retrieve the department
            if (rs.next()) {
                department = rs.getString("department");
            }

            // Close the database connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return department;
    }
}
