package GameWindow;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class PlayerInfoPanel extends JPanel{
    private JLabel ageLabel;
    private JLabel timeLabel;
    private GameTimer gameTimer;

    //gets the instance fields from the Player class and calls it as ageReference(since we're using this to only calculate the age in this class)
    private Player ageReference;

    public PlayerInfoPanel(GameTimer timer, Player ageReference){
        this.gameTimer = timer;
        this.ageReference = ageReference;

        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        //creates the label to display age, please feel free to change style as mine is just a placeholder and it's bland
        ageLabel = new JLabel("Age: 18", SwingConstants.CENTER);
        ageLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        ageLabel.setForeground(Color.WHITE);
        this.add(ageLabel, BorderLayout.CENTER);

        //creates the label to display time, please feel free to change style as mine is just a placeholder and it's bland
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        timeLabel.setForeground(Color.WHITE);
        this.add(timeLabel, BorderLayout.AFTER_LAST_LINE);

        //this calls the updateClock function that keeps track of the time
        Timer gameTime = new Timer(1000, e -> updateClock());
        gameTime.start();



    }

    private void updateClock() {
        long totalSeconds = gameTimer.getCurrentTime();

        //after a certain number of seconds, increase the age by 1
        if (totalSeconds % 5 == 0){
            ageReference.age += 1;
            ageLabel.setText("Age: " + (this.ageReference.age));
        }

        //calculate minutes and seconds
        long minutes = (totalSeconds / 60) % 60;
        long seconds = totalSeconds % 60;

        //stores and displays the timer to the label(yes the syntax for String.format is so weird)
        String timeString = String.format("%02d:%02d", minutes, seconds);
        timeLabel.setText(timeString);

        //testing purposes
        System.out.println("AGE: " + this.ageReference.age);

    }
}
