package Connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// MySQL database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "system";
    private JTextField textField_2;
    private JPasswordField passwordField;

    public login() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\Equinox\\equinox2023.github.io\\images\\edward-unsplash-blur.jpg"));
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 874, 703);
        getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Login");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 46));
        lblNewLabel_1.setBounds(335, 126, 159, 56);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(282, 259, 116, 35);
        getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(392, 269, 132, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2_1.setBounds(282, 310, 116, 35);
        getContentPane().add(lblNewLabel_2_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(392, 320, 132, 20);
        getContentPane().add(passwordField);

        // Button to perform login
        JButton btnNewButton = new JButton("Sign In");
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch data from the database
                String username = textField_2.getText();
                String password = new String(passwordField.getPassword());

                if (checkUserExists(username, password)) {
                    // User exists, close the login window
                    setVisible(false);

                    // Open the main window (loginlanding)
                    loginlanding mainWindow = new loginlanding();
                    mainWindow.setVisible(true);
                } else {
                    // User doesn't exist, display a message
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }
        });
        // Set the position and size of the button
        btnNewButton.setBounds(354, 395, 89, 23);
        getContentPane().add(btnNewButton);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("ADMIN");
        rdbtnNewRadioButton.setVerticalAlignment(SwingConstants.TOP);
        rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
        rdbtnNewRadioButton.setBounds(270, 217, 111, 23);
        getContentPane().add(rdbtnNewRadioButton);
                
                JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("HOD");
                rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.TOP);
                rdbtnNewRadioButton_1.setForeground(Color.BLACK);
                rdbtnNewRadioButton_1.setBounds(422, 217, 111, 23);
                getContentPane().add(rdbtnNewRadioButton_1);
                
                        JLabel lblNewLabel = new JLabel("New label");
                        lblNewLabel.setIcon(new ImageIcon("H:\\Equinox\\equinox2023.github.io\\images\\edward-unsplash-blur.jpg"));
                        lblNewLabel.setBounds(-11, 11, 871, 666);
                        getContentPane().add(lblNewLabel);

        // Set the visibility of the login window to true
        setVisible(true);
    }

    private boolean checkUserExists(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM ess WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        login frame = new login();
    }
}
