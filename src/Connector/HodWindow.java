package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HodWindow {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodWindow window = new HodWindow();
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
    public HodWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("HOD Panel");
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.getContentPane().setLayout(null);

        JLabel lblHodPanel = new JLabel("HOD Panel");
        lblHodPanel.setForeground(Color.WHITE);
        lblHodPanel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblHodPanel.setBounds(301, 102, 214, 43);
        frame.getContentPane().add(lblHodPanel);

        JButton btnCreateRequest = new JButton("Create Request");
        btnCreateRequest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Open the HodRequest window
                HodRequest hodRequest = new HodRequest();
                hodRequest.frame.setVisible(true);
                frame.dispose(); // Close the current window
        	}
        });
        btnCreateRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCreateRequest.setBounds(118, 312, 181, 86);
        frame.getContentPane().add(btnCreateRequest);

        JButton btnViewAllEvents = new JButton("View All Events");
        btnViewAllEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewAllEvents.setBounds(497, 312, 181, 86);
        frame.getContentPane().add(btnViewAllEvents);

        JButton btnNewButton_1 = new JButton("Log Out");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	login login = new login();
                login.setVisible(true);
                frame.dispose(); 
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(638, 516, 135, 58);
        frame.getContentPane().add(btnNewButton_1);
        frame.setBounds(100, 100, 874, 703);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

}
