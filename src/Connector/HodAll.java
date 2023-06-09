package Connector;

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

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private String username;
    private String department;

    public HodAll(String username, String department2, String department) {
        this.username = username;
        this.department = department;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 757);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUserInfo = new JLabel("Username: " + this.username);
        lblUserInfo.setForeground(Color.WHITE);
        lblUserInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUserInfo.setBounds(50, 10, 500, 25);
        contentPane.add(lblUserInfo);

        JLabel lblDepartment = new JLabel("Department: " + this.department);
        lblDepartment.setForeground(Color.WHITE);
        lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDepartment.setBounds(50, 50, 500, 25);
        contentPane.add(lblDepartment);

        JLabel lblNewLabel = new JLabel("Pending Requests");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblNewLabel.setBounds(349, 112, 423, 109);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Department", "Event Name", "Event Start", "Event End", "Status" }
        ));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(194, 281, 628, 267);
        contentPane.add(scrollPane);

        // Call the method to load requests
        loadRequests();
    }

    private void loadRequests() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");

            // Fetch all departments from the reg table
            String departmentsQuery = "SELECT DISTINCT department FROM reg";
            PreparedStatement departmentsStmt = conn.prepareStatement(departmentsQuery);
            ResultSet departmentsRs = departmentsStmt.executeQuery();

            // Clear the table model before populating
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // Fetch requests for each department and populate the table
            while (departmentsRs.next()) {
                String department = departmentsRs.getString("department");
                String sql = "SELECT department, eventname, eventstart, eventend, status FROM events WHERE department = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, department);
                ResultSet rs = stmt.executeQuery();

                // Populate the table with the fetched request data for the current department
                while (rs.next()) {
                    String eventName = rs.getString("eventname");
                    String eventStart = rs.getString("eventstart");
                    String eventEnd = rs.getString("eventend");
                    String status = rs.getString("status");
                    model.addRow(new Object[] { department, eventName, eventStart, eventEnd, status });
                }

                // Close the ResultSet and PreparedStatement for the current department
                rs.close();
                stmt.close();
            }

            // Close the ResultSet, PreparedStatement, and Connection for departments
            departmentsRs.close();
            departmentsStmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String username = "your_username"; // Replace with the actual username
        String department = "your_department"; // Replace with the actual department
        HodAll hodAll = new HodAll(username, department, department);
        hodAll.setVisible(true);
    }
}
