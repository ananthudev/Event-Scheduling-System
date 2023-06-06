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

    JFrame frame;
    private JTextField textField;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "system";
    private static final String INSERT_QUERY = "INSERT INTO events (department, eventname, hall, eventstart, eventend) VALUES (?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodRequest window = new HodRequest();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HodRequest() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Create Event Request");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(315, 121, 375, 56);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1_2 = new JLabel("Department");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_2.setBounds(315, 210, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_2);

        JComboBox<String> departmentComboBox = new JComboBox<String>();
        departmentComboBox.setBounds(543, 233, 123, 20);
        frame.getContentPane().add(departmentComboBox);

        // Add dropdown options
        departmentComboBox.addItem("Select Department");
        departmentComboBox.addItem("Civil");
        departmentComboBox.addItem("ECE");
        departmentComboBox.addItem("EEE");
        departmentComboBox.addItem("CSE");
        departmentComboBox.addItem("MCA");
        departmentComboBox.addItem("Mech");
        // Add more departments as needed

        JLabel lblNewLabel_1_1_1 = new JLabel("Event Name");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(315, 245, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(543, 268, 123, 20);
        frame.getContentPane().add(textField);

        JLabel lblNewLabel_1 = new JLabel("Hall Requested");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(315, 281, 156, 60);
        frame.getContentPane().add(lblNewLabel_1);

        JComboBox<String> departmentComboBox_1 = new JComboBox<String>();
        departmentComboBox_1.setBounds(543, 304, 123, 20);
        frame.getContentPane().add(departmentComboBox_1);

        // Add dropdown options
        departmentComboBox_1.addItem("Select Hall");
        departmentComboBox_1.addItem("MINI HALL");
        departmentComboBox_1.addItem("LOOMA HALL");
        departmentComboBox_1.addItem("DHWANI HALL");
        departmentComboBox_1.addItem("MAIN HALL");
        departmentComboBox_1.addItem("CONFERENCE HALL");

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Event Start Date & Time");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(315, 312, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spinner.setBounds(543, 335, 123, 20);
        frame.getContentPane().add(spinner);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Event End Date & Time");
        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1_1.setBounds(315, 352, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_1_1);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spinner_1.setBounds(543, 375, 123, 20);
        frame.getContentPane().add(spinner_1);

        JButton btnNewButton_1_1 = new JButton("Submit");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1_1.setBounds(383, 423, 120, 40);
        frame.getContentPane().add(btnNewButton_1_1);
        
        JButton btnNewButton_1_1_1 = new JButton("Reset");
        btnNewButton_1_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		departmentComboBox.setSelectedIndex(0);
                textField.setText("");
                departmentComboBox_1.setSelectedIndex(0);
                spinner.setValue(new Date());
                spinner_1.setValue(new Date());
        		
        	}
        });
        btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1_1_1.setBackground(Color.WHITE);
        btnNewButton_1_1_1.setBounds(543, 423, 120, 40);
        frame.getContentPane().add(btnNewButton_1_1_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 6));
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		HodWindow hodWindow = new HodWindow();
                hodWindow.setVisible(true);
                frame.dispose(); 
        	}
        });
        lblNewLabel_2.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\Graphicloads-100-Flat-Home.72.png"));
        lblNewLabel_2.setBounds(163, 121, 72, 72);
        frame.getContentPane().add(lblNewLabel_2);

        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected values from the form
                String department = departmentComboBox.getSelectedItem().toString();
                String eventName = textField.getText();
                String hall = departmentComboBox_1.getSelectedItem().toString();
                Date eventStart = (Date) spinner.getValue();
                Date eventEnd = (Date) spinner_1.getValue();

                // Validate the input
                if (department.equals("Select Department") || hall.equals("Select Hall") || eventName.equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Save the event in the database
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
                    statement.setString(1, department);
                    statement.setString(2, eventName);
                    statement.setString(3, hall);
                    statement.setTimestamp(4, new java.sql.Timestamp(eventStart.getTime()));
                    statement.setTimestamp(5, new java.sql.Timestamp(eventEnd.getTime()));
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(frame, "Event created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "An error occurred while creating the event.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setBounds(100, 100, 977, 662);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
