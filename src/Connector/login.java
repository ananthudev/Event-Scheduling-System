package Connector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField textField;
    private JTextField textField_1;

    // MySQL database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ess";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "system";

    public login() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 874, 703);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
        lblNewLabel.setBounds(360, 84, 128, 109);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(360, 204, 135, 79);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(322, 281, 180, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(360, 294, 135, 79);
        getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(322, 353, 180, 20);
        getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("Sign In");
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch data from the database
                String username = textField.getText();
                String password = textField_1.getText();

                if (checkUserExists(username, password)) {
                    // User exists, login and redirect to loginlanding.java
                    loginlanding login = new loginlanding();
                    login.setVisible(true);
                    setVisible(false);
                } else {
                    // User doesn't exist, display a message
                    JOptionPane.showMessageDialog(null, "User doesn't exist.");
                }
            }
        });
        btnNewButton.setBounds(360, 396, 89, 23);
        getContentPane().add(btnNewButton);

        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\anant\\Event Scheduling System\\ESS\\image\\image.jpg"));
        backgroundLabel.setBounds(0, 0, 858, 664);
        getContentPane().add(backgroundLabel);

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
        frame.setVisible(true);
    }
}
