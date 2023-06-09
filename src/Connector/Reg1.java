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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        JButton btnReset = new JButton("Reset");
        btnReset.setForeground(new Color(255, 255, 255));
        btnReset.setBackground(new Color(0, 128, 255));
        btnReset.setBounds(421, 567, 111, 23);
        contentPane.add(btnReset);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirect to the Login.java page
                Login login = new Login();
                login.setVisible(true);
                dispose(); // Close the current registration frame
            }
        });
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBackground(new Color(0, 128, 255));
        btnLogin.setBounds(203, 567, 111, 23);
        contentPane.add(btnLogin);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("HOD");
        rdbtnNewRadioButton_1.setBounds(421, 191, 111, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radioButtonGroup.add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        contentPane.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(165, 280, 84, 34);

        textField = new JTextField();
        contentPane.add(textField);
        textField.setBounds(336, 289, 196, 20);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
        contentPane.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(165, 325, 84, 34);

        passwordField = new JPasswordField();
        contentPane.add(passwordField);
        passwordField.setBounds(336, 334, 196, 20);

        JLabel lblNewLabel_1_1_1 = new JLabel("CONFIRM PASSWORD");
        contentPane.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(165, 364, 180, 34);

        passwordField_1 = new JPasswordField();
        contentPane.add(passwordField_1);
        passwordField_1.setBounds(336, 373, 196, 20);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL");
        contentPane.add(lblNewLabel_1_1_1_1);
        lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(165, 409, 180, 34);

        textField_1 = new JTextField();
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        textField_1.setBounds(336, 418, 196, 20);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DEPARTMENT");
        contentPane.add(lblNewLabel_1_1_1_1_1);
        lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(165, 454, 180, 34);

        // Dropdown menu for department
        JComboBox<String> departmentComboBox = new JComboBox<String>();
        contentPane.add(departmentComboBox);
        departmentComboBox.addItem("Select a Department");
        departmentComboBox.setBounds(336, 463, 196, 20);

        // Button to perform sign up
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setForeground(new Color(255, 255, 255));
        btnSignUp.setBackground(new Color(0, 128, 255));
        contentPane.add(btnSignUp);
        btnSignUp.setBounds(322, 516, 111, 23);

        JLabel backgroundLabel = new JLabel(
                new ImageIcon("C:\\Users\\anant\\Event Scheduling System\\ESS\\image\\image.jpg"));
        backgroundLabel.setBackground(new Color(240, 240, 240));
        backgroundLabel.setBounds(0, 0, 768, 679);
        contentPane.add(backgroundLabel);

        JLabel lblNewLabel = new JLabel("Registration");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
        lblNewLabel.setBounds(261, 75, 294, 68);
        backgroundLabel.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("ADMIN");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(242, 192, 111, 23);
        backgroundLabel.add(rdbtnNewRadioButton);
        radioButtonGroup.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("HOD");
        rdbtnNewRadioButton_11.setBounds(421, 191, 111, 23);
        contentPane.add(rdbtnNewRadioButton_11);
        rdbtnNewRadioButton_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        radioButtonGroup.add(rdbtnNewRadioButton_11);
        
     // Add ActionListener to the admin radio button
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Disable the department drop-down menu
                departmentComboBox.setEnabled(false);
            }
        });

        // Add ActionListener to the HOD radio button
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Enable the department drop-down menu
                departmentComboBox.setEnabled(true);
            }
        });




        
        
        btnSignUp.addActionListener(e -> {
            // Retrieve the values from the fields
            String username = textField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(passwordField_1.getPassword());
            String email = textField_1.getText();
            String department = departmentComboBox.getSelectedItem().toString();
            String userType = rdbtnNewRadioButton.isSelected() ? "ADMIN" : "HOD"; // Determine the selected user type

            // Validate the data
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
            } else {
                // Check if username or email already exists
                if (checkExistingUser(username, email)) {
                    JOptionPane.showMessageDialog(null, "Username or email already exists!");
                } else {
                    // Save the data to the database
                    saveToDatabase(username, password, email, department, userType);
                }
            }
        });



        departmentComboBox.addItem("Civil");
        departmentComboBox.addItem("ECE");
        departmentComboBox.addItem("EEE");
        departmentComboBox.addItem("CSE");
        departmentComboBox.addItem("MCA");
        departmentComboBox.addItem("Mech");

        // Action listener for reset button
        btnReset.addActionListener(e -> {
            // Clear the fields
            textField.setText("");
            passwordField.setText("");
            passwordField_1.setText("");
            textField_1.setText("");
            departmentComboBox.setSelectedIndex(0);
        });
    }

    private boolean checkExistingUser(String username, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Save the registration data to the database.
     */
    private void saveToDatabase(String username, String password, String email, String department, String userType) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Create a prepared statement with an SQL query
            String query;
            PreparedStatement statement;

            if (userType.equals("ADMIN")) {
                // If Admin, exclude department information
                query = "INSERT INTO reg (username, password, email, userType) VALUES (?, ?, ?, ?)";
                statement = conn.prepareStatement(query);

                // Set the parameter values in the prepared statement
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.setString(4, userType);
            } else {
                // If HOD, include department information
                query = "INSERT INTO reg (username, password, email, department, userType) VALUES (?, ?, ?, ?, ?)";
                statement = conn.prepareStatement(query);

                // Set the parameter values in the prepared statement
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.setString(4, department);
                statement.setString(5, userType);
            }

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
