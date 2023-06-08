package Connector;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class HodRequest {

    JFrame frmHodEventRequest;
    private JTextField textField;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "system";
    private static final String INSERT_QUERY = "INSERT INTO events (department, eventname, eventstart, eventend) VALUES (?, ?, ?, ?)";

    private String username;
    private String department;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodRequest window = new HodRequest("username", "department");
                    window.frmHodEventRequest.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HodRequest(String username, String department) {
        this.username = username;
        this.department = department;
        initialize();
    }

    private void initialize() {
        frmHodEventRequest = new JFrame();
        frmHodEventRequest.setTitle("HOD Event Request");
        frmHodEventRequest.getContentPane().setBackground(new Color(0, 128, 128));
        frmHodEventRequest.getContentPane().setLayout(null);

        JButton lblNewLabel_2 = new JButton("");
        lblNewLabel_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HodWindow hodWindow = new HodWindow(username, department);
                hodWindow.setVisible(true);
                frmHodEventRequest.dispose();
            }
        });
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 6));
        lblNewLabel_2.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\home.png"));
        lblNewLabel_2.setBounds(163, 121, 96, 96);
        frmHodEventRequest.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel = new JLabel("Create Event Request");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(315, 121, 375, 56);
        frmHodEventRequest.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1_1_1 = new JLabel("Event Name");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(315, 245, 116, 60);
        frmHodEventRequest.getContentPane().add(lblNewLabel_1_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(543, 268, 134, 20);
        frmHodEventRequest.getContentPane().add(textField);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Event Start Date & Time");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(315, 281, 191, 60);
        frmHodEventRequest.getContentPane().add(lblNewLabel_1_1_1_1);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spinner.setBounds(543, 304, 134, 20);
        frmHodEventRequest.getContentPane().add(spinner);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Event End Date & Time");
        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1_1.setBounds(315, 316, 191, 60);
        frmHodEventRequest.getContentPane().add(lblNewLabel_1_1_1_1_1);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spinner_1.setBounds(543, 339, 134, 20);
        frmHodEventRequest.getContentPane().add(spinner_1);

        JButton btnNewButton_1_1 = new JButton("Submit");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1_1.setBounds(382, 393, 120, 40);
        frmHodEventRequest.getContentPane().add(btnNewButton_1_1);

        JButton btnNewButton_1_1_1 = new JButton("Reset");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                spinner.setValue(new Date());
                spinner_1.setValue(new Date());
            }
        });
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1_1_1.setBackground(Color.WHITE);
        btnNewButton_1_1_1.setBounds(542, 393, 120, 40);
        frmHodEventRequest.getContentPane().add(btnNewButton_1_1_1);

        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected values from the form
                String eventName = textField.getText();
                Date eventStart = (Date) spinner.getValue();
                Date eventEnd = (Date) spinner_1.getValue();

                // Validate the input
                if (eventName.equals("")) {
                    JOptionPane.showMessageDialog(frmHodEventRequest, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Save the event in the database
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
                    statement.setString(1, department);
                    statement.setString(2, eventName);
                    statement.setTimestamp(3, new java.sql.Timestamp(eventStart.getTime()));
                    statement.setTimestamp(4, new java.sql.Timestamp(eventEnd.getTime()));
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(frmHodEventRequest, "Event created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frmHodEventRequest, "An error occurred while creating the event.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frmHodEventRequest.setBounds(100, 100, 977, 662);
        frmHodEventRequest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHodEventRequest.setVisible(true);
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
