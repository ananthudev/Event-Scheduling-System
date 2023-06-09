package Connector;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HodWindow {

    private JFrame frame;
    private String username;
    private static String department;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodWindow window = new HodWindow("username", department);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HodWindow(String username, String department2) {
        this.username = username;
        HodWindow.department = fetchDepartment(username);
        initialize();
    }

    private String fetchDepartment(String username) {
        String department = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ess", "root", "system");
            PreparedStatement statement = conn.prepareStatement("SELECT department FROM reg WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                department = resultSet.getString("department");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return department;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("HOD Panel");
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.getContentPane().setLayout(null);

        JLabel lblDepartment = new JLabel("Department: " + department);
        lblDepartment.setForeground(Color.WHITE);
        lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblDepartment.setBounds(50, 10, 500, 25);
        frame.getContentPane().add(lblDepartment);

        JLabel lblHodPanel = new JLabel("HOD Panel");
        lblHodPanel.setForeground(Color.WHITE);
        lblHodPanel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblHodPanel.setBounds(301, 102, 214, 43);
        frame.getContentPane().add(lblHodPanel);

        JLabel lblUserInfo = new JLabel("Username: " + username);
        lblUserInfo.setForeground(Color.WHITE);
        lblUserInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUserInfo.setBounds(50, 50, 500, 25);
        frame.getContentPane().add(lblUserInfo);

        JButton btnCreateRequest = new JButton("Create Request");
        btnCreateRequest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HodRequest hodRequest = new HodRequest(username, department);
                hodRequest.setVisible(true);
                frame.dispose();
            }
        });
        btnCreateRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCreateRequest.setBounds(118, 312, 223, 86);
        frame.getContentPane().add(btnCreateRequest);

        JButton btnViewAllEvents = new JButton("Pending Requests");
        btnViewAllEvents.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		HodAll hodall = new HodAll(username, username, department);
        		hodall.setVisible(true);
        		dispose();
        	}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
        });
        btnViewAllEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewAllEvents.setBounds(456, 312, 223, 86);
        frame.getContentPane().add(btnViewAllEvents);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                frame.dispose();
            }
        });
        btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLogOut.setBounds(638, 516, 135, 58);
        frame.getContentPane().add(btnLogOut);

        frame.setBounds(100, 100, 874, 703);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
