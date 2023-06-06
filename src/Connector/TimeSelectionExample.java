package Connector;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;

public class TimeSelectionExample {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TimeSelectionExample window = new TimeSelectionExample();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TimeSelectionExample() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1302, 756);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 414, 239);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Create the SpinnerDateModel with current time as the initial value
        SpinnerDateModel spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
        
        // Create the JSpinner with the SpinnerDateModel
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setBounds(10, 11, 150, 20);
        panel.add(spinner);
    }
}
