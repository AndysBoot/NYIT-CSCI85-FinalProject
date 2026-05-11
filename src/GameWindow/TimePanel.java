package GameWindow;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class TimePanel extends JPanel {
    private JLabel timeLabel;
    private GameTimer gameTimer;

    public TimePanel(GameTimer timer){
        this.gameTimer = timer;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        timeLabel.setForeground(Color.BLUE);
        this.add(timeLabel, BorderLayout.CENTER);

        Timer uiTimer = new Timer(500, e -> updateClock());
        uiTimer.start();

    }

    private void updateClock() {
        long totalSeconds = gameTimer.getCurrentTime();

        long minutes = (totalSeconds / 60) % 60;
        long seconds = totalSeconds % 60;

        String timeString = String.format("%02d:%02d", minutes, seconds);
        timeLabel.setText(timeString);
    }
}
