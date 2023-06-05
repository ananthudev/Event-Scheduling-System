package Connector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class loginlanding {

    private JFrame frame;

    /**
     * Create the application.
     */
    public loginlanding() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 874, 703);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Login Landing, Content to be added");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 47));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(42, 172, 771, 207);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("H:\\Equinox\\equinox2023.github.io\\images\\nainoa-shizuru-unsplash-blur.jpg"));
        lblNewLabel.setBounds(-11, 0, 871, 666);
        frame.getContentPane().add(lblNewLabel);

        // Add your code here to design the login landing window

        // Example: Add a label to the frame
//        JLabel lblWelcome = new JLabel("Welcome to the Login Landing Page");
//        lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
//        lblWelcome.setBounds(50, 50, 350, 30);
//        frame.getContentPane().add(lblWelcome);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

}
