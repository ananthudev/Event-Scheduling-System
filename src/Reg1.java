import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Reg1 extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reg1 frame = new Reg1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Reg1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 782, 706);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Background image
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\anant\\Event Scheduling System\\ESS\\image\\image.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, 782, 706);
        contentPane.add(backgroundLabel);

        JLabel lblNewLabel = new JLabel("Registration");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 42));
        lblNewLabel.setBounds(261, 75, 294, 68);
        backgroundLabel.add(lblNewLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Admin");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(242, 192, 111, 23);
        backgroundLabel.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("HOD");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rdbtnNewRadioButton_1.setBounds(424, 194, 111, 23);
        backgroundLabel.add(rdbtnNewRadioButton_1);

        // Group the radio buttons
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(rdbtnNewRadioButton);
        radioButtonGroup.add(rdbtnNewRadioButton_1);

        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(333, 240, 84, 34);
        backgroundLabel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(277, 285, 196, 20);
        backgroundLabel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(333, 316, 84, 34);
        backgroundLabel.add(lblNewLabel_1_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(277, 353, 196, 20);
        backgroundLabel.add(passwordField);

        JLabel lblNewLabel_1_1_1 = new JLabel("CONFIRM PASSWORD");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(293, 380, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(277, 412, 196, 20);
        backgroundLabel.add(passwordField_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1.setBounds(333, 437, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("DEPARTMENT");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1_1_1_1_1.setBounds(318, 501, 180, 34);
        backgroundLabel.add(lblNewLabel_1_1_1_1_1);

        // Dropdown menu for department
        JComboBox<String> departmentComboBox = new JComboBox<String>();
        departmentComboBox.addItem("Select a Department");
        departmentComboBox.setBounds(277, 536, 196, 20);
        departmentComboBox.addItem("Civil");
        departmentComboBox.addItem("ECE");
        departmentComboBox.addItem("EEE");
        departmentComboBox.addItem("CSE");
        departmentComboBox.addItem("MCA");
        departmentComboBox.addItem("Mech");
        backgroundLabel.add(departmentComboBox);

        // Button to perform sign up
        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(311, 579, 111, 23);
        backgroundLabel.add(btnSignUp);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(277, 469, 196, 20);
        backgroundLabel.add(textField_1);

        // Action listener for sign up button
        btnSignUp.addActionListener(e -> {
            // Show registration completed message
            JOptionPane.showMessageDialog(null, "Registration completed! ");
        });
    }
}
