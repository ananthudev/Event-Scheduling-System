package Connector;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reg1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField textField_1;

    // MySQL database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "system";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reg1 frame = new Reg1();
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
    public Reg1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 782, 706);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Group the radio buttons
        ButtonGroup radioButtonGroup = new ButtonGroup();
        contentPane.setLayout(null);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("HOD");
        rdbtnNewRadioButton_1.setBounds(421, 191, 111, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radioButtonGroup.add(rdbtnNewRadioButton_1);

        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\anant\\Event Scheduling System\\ESS\\image\\image.jpg"));
        backgroundLabel.setBackground(new Color(240, 240, 240));
        backgroundLabel.setBounds(0, 0, 768, 679);
        contentPane.add(backgroundLabel);

        JLabel lblNewLabel = new JLabel("Registration");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
        lblNewLabel.setBounds(261, 75, 294, 68);
        backgroundLabel.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Admin");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(242, 192, 111, 23);
        backgroundLabel.add(rdbtnNewRadioButton);
        radioButtonGroup.add(rdbtnNewRadioButton);

        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(333, 240, 84, 34);
        backgroundLabel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(277, 285, 196, 20);
        backgroundLabel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(333, 316, 84, 34);
        backgroundLabel.add(lblNewLabel_1_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(277, 353, 196, 20);
        backgroundLabel.add(passwordField);

        JLabel lblNewLabel_1_1_1 = new JLabel("CONFIRM PASSWORD");
        lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(293, 380, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(277, 412, 196, 20);
        backgroundLabel.add(passwordField_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL");
        lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(333, 437, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DEPARTMENT");
        lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(318, 501, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1_1_1);

        // Dropdown menu for department
        JComboBox<String> departmentComboBox = new JComboBox<String>();
        departmentComboBox.addItem("Select a Department");
        departmentComboBox.setBounds(277, 536, 196, 20);
        departmentComboBox.addItem("Civil");
        departmentComboBox.addItem("ECE");
        departmentComboBox.addItem("EEE");
        departmentComboBox.addItem("CSE");
        departmentComboBox.addItem("MCA");
        departmentComboBox.addItem("Mech");
        backgroundLabel.add(departmentComboBox);

        // Button to perform sign up
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(311, 579, 111, 23);
        backgroundLabel.add(btnSignUp);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(277, 469, 196, 20);
        backgroundLabel.add(textField_1);

        // Action listener for sign up button
        btnSignUp.addActionListener(e -> {
            // Retrieve the values from the fields
            String username = textField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(passwordField_1.getPassword());
            String email = textField_1.getText();
            String department = departmentComboBox.getSelectedItem().toString();

            // Validate the data
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()
                    || department.equals("Select a Department")) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            } else {
                // Save the data to the database
                saveToDatabase(username, password, email, department);
            }
        });
    }

    /**
     * Save the registration data to the database.
     */
    private void saveToDatabase(String username, String password, String email, String department) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a prepared statement with an SQL query
            String query = "INSERT INTO ess (username, password, email, department) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            // Set the parameter values in the prepared statement
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, department);

            // Execute the SQL query
            statement.executeUpdate();

            // Close the connection and statement
            statement.close();
            conn.close();

            // Show registration completed message
            JOptionPane.showMessageDialog(null, "Registration completed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Failed to save data to the database!");
        }
    }
}
