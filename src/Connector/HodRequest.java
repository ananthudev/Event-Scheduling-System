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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class HodRequest {

    private JFrame frame;
    private JTextField textField;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "system";
    private static final String INSERT_QUERY = "INSERT INTO events (department, eventname, eventstart, eventend, ampm) VALUES (?, ?, ?, ?, ?)";

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
        lblNewLabel.setBounds(349, 114, 375, 56);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Department");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(350, 226, 116, 60);
        frame.getContentPane().add(lblNewLabel_1);

        JComboBox<String> departmentComboBox = new JComboBox<String>();
        departmentComboBox.setBounds(574, 249, 123, 20);
        frame.getContentPane().add(departmentComboBox);

        // Add dropdown options
        departmentComboBox.addItem("Civil");
        departmentComboBox.addItem("ECE");
        departmentComboBox.addItem("EEE");
        departmentComboBox.addItem("CSE");
        departmentComboBox.addItem("MCA");
        departmentComboBox.addItem("Mech");

        JLabel lblNewLabel_1_1 = new JLabel("Event Name");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(350, 265, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(574, 280, 123, 20);
        frame.getContentPane().add(textField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Event Start Date & Time");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(350, 308, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(1685989800000L), new Date(1685989800000L),
                new Date(1685989800000L), Calendar.HOUR_OF_DAY));
        spinner.setBounds(574, 331, 123, 20);
        frame.getContentPane().add(spinner);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("AM or PM");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(350, 391, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("AM");
        rdbtnNewRadioButton.setBounds(574, 413, 49, 38);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnPm = new JRadioButton("PM");
        rdbtnPm.setBounds(640, 413, 57, 38);
        frame.getContentPane().add(rdbtnPm);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Event End Date & Time");
        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_2.setBounds(350, 346, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_2);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerDateModel(new Date(1685989800000L), new Date(1685989800000L),
                new Date(1685989800000L), Calendar.DAY_OF_YEAR));
        spinner_1.setBounds(574, 373, 123, 20);
        frame.getContentPane().add(spinner_1);

        JButton btnNewButton_1 = new JButton("Home");
        btnNewButton_1.setBounds(105, 96, 135, 58);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Request");
        btnNewButton_1_1.setBounds(374, 480, 135, 58);
        frame.getContentPane().add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Reset");
        btnNewButton_1_2.setBounds(559, 480, 135, 58);
        frame.getContentPane().add(btnNewButton_1_2);

        frame.setBounds(100, 100, 992, 757);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ActionListener for the Request button
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected values from the UI components
                String department = departmentComboBox.getSelectedItem().toString();
                String eventName = textField.getText();
                Date eventStartDate = (Date) spinner.getValue();
                Date eventEndDate = (Date) spinner_1.getValue();
                String ampm = rdbtnNewRadioButton.isSelected() ? "AM" : "PM";

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
                     PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
                    // Set the parameter values in the prepared statement
                    statement.setString(1, department);
                    statement.setString(2, eventName);
                    statement.setTimestamp(3, new java.sql.Timestamp(eventStartDate.getTime()));
                    statement.setTimestamp(4, new java.sql.Timestamp(eventEndDate.getTime()));
                    statement.setString(5, ampm);

                    // Execute the query
                    statement.executeUpdate();

                    // Display a success message
                    JOptionPane.showMessageDialog(frame, "Request sent successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error occurred while sending the request.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
