package Connector;

import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class AdminWindow {

    private JFrame frame;

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

    public AdminWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.setBounds(100, 100, 992, 757);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnOpenAdminEvents = new JButton("Open Admin Events");
        btnOpenAdminEvents.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOpenAdminEvents.setBounds(248, 362, 189, 83);
        btnOpenAdminEvents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminEvents.main(null);
                frame.dispose(); 
            }
        });
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Admin Control Window");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(363, 137, 335, 106);
        frame.getContentPane().add(lblNewLabel);
        frame.getContentPane().add(btnOpenAdminEvents);
        
        JButton btnNewButton = new JButton(" View All Requests");
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AdminAllReq adminAllReq = new AdminAllReq();
                adminAllReq.setVisible(true);
                frame.dispose(); 
        		
        	}
        	
        	
          
        	
        });
        btnNewButton.setBounds(571, 362, 189, 83);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Log Out");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Login login = new Login();
                login.setVisible(true);
                frame.dispose();
        	}
        });
        btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_1.setBounds(726, 576, 103, 42);
        frame.getContentPane().add(btnNewButton_1);
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
