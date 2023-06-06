import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

public class HodRequest {

    private JFrame frame;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HodRequest window = new HodRequest();
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
    public HodRequest() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 128, 128));
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Create Event Request");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(293, 77, 375, 56);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Department");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(68, 226, 116, 60);
        frame.getContentPane().add(lblNewLabel_1);

        JComboBox<String> departmentComboBox = new JComboBox<String>();
        departmentComboBox.setBounds(276, 249, 123, 20);
        frame.getContentPane().add(departmentComboBox);

        JLabel lblNewLabel_1_1 = new JLabel("Event Name");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(68, 265, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(276, 288, 123, 20);
        frame.getContentPane().add(textField);

        JLabel lblNewLabel_1_1_1 = new JLabel("Event Start Date & Time");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(68, 308, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1);

        JSpinner spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(1685989800000L), new Date(1685989800000L), new Date(1685989800000L), Calendar.HOUR_OF_DAY));
        spinner.setBounds(276, 331, 123, 20);
        frame.getContentPane().add(spinner);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("AM or PM");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_1.setBounds(68, 391, 116, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("AM");
        rdbtnNewRadioButton.setBounds(276, 413, 41, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnPm = new JRadioButton("PM");
        rdbtnPm.setBounds(348, 413, 41, 23);
        frame.getContentPane().add(rdbtnPm);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Event End Date & Time");
        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1_2.setBounds(68, 350, 191, 60);
        frame.getContentPane().add(lblNewLabel_1_1_1_2);

        JSpinner spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerDateModel(new Date(1685989800000L), new Date(1685989800000L), new Date(1685989800000L), Calendar.DAY_OF_YEAR));
        spinner_1.setBounds(276, 373, 123, 20);
        frame.getContentPane().add(spinner_1);

        JButton btnNewButton_1 = new JButton("Return");
        btnNewButton_1.setBounds(417, 503, 135, 58);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("Approve");
        btnNewButton_1_1.setBounds(85, 503, 135, 58);
        frame.getContentPane().add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("Deny");
        btnNewButton_1_2.setBounds(251, 503, 135, 58);
        frame.getContentPane().add(btnNewButton_1_2);

        JLabel lblNewLabel_2 = new JLabel("Pending Requests");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(592, 176, 156, 20);
        frame.getContentPane().add(lblNewLabel_2);

        table = new JTable();
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", "", null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        		{null, null, null, null, null},
        	},
        	new String[] {
        		"Department", "Event Name", "Event Start Date and Time", "Event End Date and Time", "AM or PM"
        	}
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(72);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(142);
        table.getColumnModel().getColumn(3).setPreferredWidth(137);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(427, 249, 527, 166);
        frame.getContentPane().add(scrollPane);

        frame.setBounds(100, 100, 992, 757);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
