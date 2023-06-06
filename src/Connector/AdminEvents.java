package Connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class AdminEvents {

    private JFrame frmAdminEvents;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_6;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminEvents window = new AdminEvents();
                    window.frmAdminEvents.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AdminEvents() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAdminEvents = new JFrame();
        frmAdminEvents.getContentPane().setForeground(new Color(255, 255, 255));
        frmAdminEvents.setTitle("Admin Events");
        frmAdminEvents.getContentPane().setBackground(new Color(0, 128, 128));
        frmAdminEvents.getContentPane().setLayout(null);

        JLabel lblEndTime_2 = new JLabel("End Time");
        lblEndTime_2.setForeground(Color.WHITE);
        lblEndTime_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEndTime_2.setBounds(73, 406, 165, 60);
        frmAdminEvents.getContentPane().add(lblEndTime_2);

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
            },
            new String[] {
                "Department", "Event Name", "Hall", "Start Time", "End Time"
            }
        );
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Department", "Event Name", "Hall", "Start Time", "End Time"
        	}
        ));
        table.getColumnModel().getColumn(2).setPreferredWidth(73);
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(456, 290, 373, 128);
        frmAdminEvents.getContentPane().add(scrollPane);

        JLabel lblAdminEvents = new JLabel("Admin Events");
        lblAdminEvents.setForeground(Color.WHITE);
        lblAdminEvents.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblAdminEvents.setBounds(299, 95, 283, 43);
        frmAdminEvents.getContentPane().add(lblAdminEvents);

        JLabel lblNewLabel = new JLabel("Department");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(73, 264, 116, 60);
        frmAdminEvents.getContentPane().add(lblNewLabel);

        JLabel lblRequestedHall = new JLabel("Hall Requested");
        lblRequestedHall.setForeground(Color.WHITE);
        lblRequestedHall.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblRequestedHall.setBounds(73, 335, 165, 60);
        frmAdminEvents.getContentPane().add(lblRequestedHall);

        JLabel lblEndTime = new JLabel("Start Time");
        lblEndTime.setForeground(Color.WHITE);
        lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEndTime.setBounds(73, 371, 165, 60);
        frmAdminEvents.getContentPane().add(lblEndTime);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(229, 287, 132, 20);
        frmAdminEvents.getContentPane().add(textField);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(229, 358, 132, 20);
        frmAdminEvents.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(229, 394, 132, 20);
        frmAdminEvents.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(229, 429, 132, 20);
        frmAdminEvents.getContentPane().add(textField_4);

        JButton btnNewButton = new JButton("Approve");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(83, 477, 89, 23);
        frmAdminEvents.getContentPane().add(btnNewButton);

        JButton btnDeny = new JButton("Deny");
        btnDeny.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDeny.setBounds(204, 477, 89, 23);
        frmAdminEvents.getContentPane().add(btnDeny);

        JLabel lblEventName = new JLabel("Event Name");
        lblEventName.setForeground(Color.WHITE);
        lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEventName.setBounds(73, 300, 116, 60);
        frmAdminEvents.getContentPane().add(lblEventName);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(229, 327, 132, 20);
        frmAdminEvents.getContentPane().add(textField_6);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReset.setBounds(319, 479, 89, 23);
        frmAdminEvents.getContentPane().add(btnReset);
        frmAdminEvents.setBounds(100, 100, 919, 703);
        frmAdminEvents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
