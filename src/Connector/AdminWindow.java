package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class AdminWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminWindow window = new AdminWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Admin Panel");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblNewLabel.setBounds(306, 43, 214, 43);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("View Events");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(133, 279, 181, 86);
        frame.getContentPane().add(btnNewButton);

        JButton btnAllEvents = new JButton("All Events");
        btnAllEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAllEvents.setBounds(518, 279, 181, 86);
        frame.getContentPane().add(btnAllEvents);

        JButton btnNewButton_1 = new JButton("Return");
        btnNewButton_1.setBounds(622, 506, 135, 58);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
        lblWelcomeAdmin.setForeground(Color.WHITE);
        lblWelcomeAdmin.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblWelcomeAdmin.setBounds(279, 139, 533, 43);
        frame.getContentPane().add(lblWelcomeAdmin);
        frame.setBounds(100, 100, 874, 704);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
