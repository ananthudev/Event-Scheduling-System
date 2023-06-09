package Connector;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdminAllReq extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminAllReq frame = new AdminAllReq();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminAllReq() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 757);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Department", "Event Name", "Hall", "Event Start", "Event End", "Status" }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(90);
        table.getColumnModel().getColumn(0).setMinWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(172);
        table.getColumnModel().getColumn(3).setMinWidth(172);
        table.getColumnModel().getColumn(4).setPreferredWidth(172);
        table.getColumnModel().getColumn(4).setMinWidth(172);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setMinWidth(90);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(130, 223, 716, 203);
        contentPane.add(scrollPane);

        JButton btnRefresh = new JButton("");
        btnRefresh.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\refresh.png"));
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRefresh.setBounds(444, 460, 81, 57);
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                populateTable();
            }
        });
        contentPane.add(btnRefresh);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		btnNewButton.addActionListener(new ActionListener() {
        		    private Window frmAdminEvents;

					public void actionPerformed(ActionEvent e) {
        		        AdminWindow adminWindow = new AdminWindow();
        		        adminWindow.setVisible(true);
        		        frmAdminEvents.dispose(); // Dispose the current window
        		    }
        		});
        	}
        });
        btnNewButton.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\home.png"));
        btnNewButton.setBounds(58, 67, 105, 81);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("All Approved and Denied Requests");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(257, 142, 488, 51);
        contentPane.add(lblNewLabel);

        populateTable(); // Populate the table initially
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        // Connect to the database and retrieve data
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
             PreparedStatement stmt = conn.prepareStatement("SELECT department, eventname, hall, eventstart, eventend, status FROM events");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String department = rs.getString("department");
                String eventName = rs.getString("eventname");
                String hall = rs.getString("hall");
                String eventStart = rs.getString("eventstart");
                String eventEnd = rs.getString("eventend");
                String status = rs.getString("status");
                model.addRow(new Object[]{department, eventName, hall, eventStart, eventEnd, status});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
