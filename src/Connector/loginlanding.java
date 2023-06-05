package Connector;

import javax.swing.JFrame;

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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
