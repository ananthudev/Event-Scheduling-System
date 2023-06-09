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

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField_2;
    private JPasswordField passwordField;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;

    public Login() {
        getContentPane().setForeground(new Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\ESS\\Event-Scheduling-System\\image\\edward-unsplash-blur.jpg"));
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 758);
        getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Login");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 46));
        lblNewLabel_1.setBounds(452, 149, 159, 56);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Username");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(343, 259, 116, 35);
        getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(507, 270, 132, 20);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("Password");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2_1.setBounds(343, 304, 116, 35);
        getContentPane().add(lblNewLabel_2_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(507, 321, 132, 20);
        getContentPane().add(passwordField);

        JLabel lblNewLabel_3 = new JLabel("User Type");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(343, 361, 116, 35);
        getContentPane().add(lblNewLabel_3);

        rdbtnNewRadioButton = new JRadioButton("Admin");
        rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNewRadioButton.setBounds(479, 368, 73, 23);
        getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("HOD");
        rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 0));
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNewRadioButton_1.setBounds(582, 368, 73, 23);
        getContentPane().add(rdbtnNewRadioButton_1);

        ButtonGroup userTypeGroup = new ButtonGroup();
        userTypeGroup.add(rdbtnNewRadioButton);
        userTypeGroup.add(rdbtnNewRadioButton_1);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textField_2.getText();
                String password = new String(passwordField.getPassword());
                String userType = "";

                if (rdbtnNewRadioButton.isSelected()) {
                    userType = "Admin";
                } else if (rdbtnNewRadioButton_1.isSelected()) {
                    userType = "HOD";
                }

                if (username.isEmpty() || password.isEmpty() || userType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
                        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reg WHERE username=? AND password=?");

                        stmt.setString(1, username);
                        stmt.setString(2, password);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Login Successful!");

                            if (userType.equals("Admin")) {
                                AdminWindow adminWindow = new AdminWindow();
                                adminWindow.setVisible(true);
                            } else if (userType.equals("HOD")) {
                                HodWindow hodWindow = new HodWindow(username, userType);
                                hodWindow.setVisible(true);
                            }

                            dispose(); // Close the login window

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username, password, or user type.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnNewButton.setBounds(522, 456, 89, 23);
        getContentPane().add(btnNewButton);

        getContentPane().setBackground(new Color(255, 255, 255));

        JButton btnNewButton_1 = new JButton("Register");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Reg1 reg1 = new Reg1();
				reg1.setVisible(true);
				dispose();


            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(343, 456, 89, 23);
        getContentPane().add(btnNewButton_1);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReset.setBounds(684, 456, 89, 23);
        getContentPane().add(btnReset);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("H:\\ESS\\Event-Scheduling-System\\image\\edward-unsplash-blur.jpg"));
        lblNewLabel.setBounds(0, 0, 978, 721);
        getContentPane().add(lblNewLabel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}