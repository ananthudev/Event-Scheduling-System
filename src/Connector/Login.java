package Connector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField textField;
    private JTextField textField_1;

    public Login() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1109, 815);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
        lblNewLabel.setBounds(494, 86, 128, 109);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(497, 225, 135, 79);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(452, 292, 180, 20);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(494, 312, 135, 79);
        getContentPane().add(lblNewLabel_1_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(452, 381, 180, 20);
        getContentPane().add(textField_1);

        JButton btnNewButton = new JButton("Sign In");
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your sign-in functionality here
            }
        });
        btnNewButton.setBounds(494, 426, 89, 23);
        getContentPane().add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel("OR");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(524, 479, 49, 14);
        getContentPane().add(lblNewLabel_2);

        JButton btnNewButton_1 = new JButton("CREATE ACCOUNT");
        btnNewButton_1.setBackground(new Color(0, 128, 255));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create an instance of the Reg1 class
                Reg1 reg1 = new Reg1();
                // Make the Reg1 window visible
                reg1.setVisible(true);
                // Hide the Login window (optional)
                setVisible(false);
            }
        });
        btnNewButton_1.setBounds(452, 504, 180, 23);
        getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("H:\\Equinox\\equinox2023.github.io\\images\\edward-unsplash-blur.jpg"));
        lblNewLabel_3.setBounds(10, 11, 1085, 767);
        getContentPane().add(lblNewLabel_3);
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
