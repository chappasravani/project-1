import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StopwatchClockApp extends JFrame implements ActionListener {

    // Clock
    private JLabel clockLabel;

    // Stopwatch
    private JLabel stopwatchLabel;
    private JButton startButton, stopButton, resetButton;

    private Timer clockTimer, stopwatchTimer;
    private int elapsedSeconds = 0;
    private boolean isRunning = false;

    public StopwatchClockApp() {
        setTitle("Stopwatch and Clock");
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Clock Section
        clockLabel = new JLabel("Clock: ", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(clockLabel);

        // Stopwatch Section
        stopwatchLabel = new JLabel("Stopwatch: 00:00:00", SwingConstants.CENTER);
        stopwatchLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(stopwatchLabel);

        // Buttons
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel);

        // Footer
        JLabel credit = new JLabel("© StopwatchClockApp", SwingConstants.CENTER);
        credit.setFont(new Font("SansSerif", Font.PLAIN, 12));
        add(credit);

        // Button Listeners
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Clock Timer (updates every second)
        clockTimer = new Timer(1000, e -> updateClock());
        clockTimer.start();

        // Stopwatch Timer (updates every second)
        stopwatchTimer = new Timer(1000, e -> updateStopwatch());

        setVisible(true);
    }

    private void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        clockLabel.setText("Clock: " + sdf.format(new Date()));
    }

    private void updateStopwatch() {
        elapsedSeconds++;
        int hours = elapsedSeconds / 3600;
        int minutes = (elapsedSeconds % 3600) / 60;
        int seconds = elapsedSeconds % 60;

        stopwatchLabel.setText(String.format("Stopwatch: %02d:%02d:%02d", hours, minutes, seconds));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == startButton) {
            if (!isRunning) {
                stopwatchTimer.start();
                isRunning = true;
            }
        } else if (src == stopButton) {
            stopwatchTimer.stop();
            isRunning = false;
        } else if (src == resetButton) {
            stopwatchTimer.stop();
            elapsedSeconds = 0;
            stopwatchLabel.setText("Stopwatch: 00:00:00");
            isRunning = false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopwatchClockApp::new);
    }
}
