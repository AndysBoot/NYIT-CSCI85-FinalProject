package GameWindow;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class PlayerInfoPanel extends JPanel{
    private JLabel ageLabel;
    private JLabel timeLabel;
    private JLabel moneyLabel;
    private GameTimer gameTimer;

    //Very important so ageLabel doesn't break
    private long lastAgedSecond = -1;

    //used moneyValue to get the instance field of moneyCount from CookieClickerPanel
    private CookieClickerPanel moneyValue;


    //gets the instance fields from the Player class and calls it as ageReference(since we're using this to only calculate the age in this class)
    private Player ageReference;

    public PlayerInfoPanel(GameTimer timer, Player ageReference, CookieClickerPanel moneyValue){
        this.gameTimer = timer;
        this.ageReference = ageReference;
        this.moneyValue = moneyValue;

        //used boxLayout as I had difficulty stacking the panels using Border Layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(0));
        this.setBackground(Color.BLACK);

        //creates the label to display age, please feel free to change style as mine is just a placeholder and it's bland
        ageLabel = new JLabel("Age: 18", SwingConstants.CENTER);
        ageLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(ageLabel);

        //creates the label to display time, please feel free to change style as mine is just a placeholder and it's bland
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(timeLabel);

        //creates the label to display time, please feel free to change style as mine is just a placeholder and it's bland
        moneyLabel = new JLabel("Money: $", SwingConstants.CENTER);
        moneyLabel.setFont(new Font("Monospaced", Font.BOLD, 50));
        moneyLabel.setForeground(Color.WHITE);
        moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(moneyLabel);

        //this calls the updateInfo function that keeps track of the time, age, and money
        Timer gameTime = new Timer(10, e -> updateInfo());
        gameTime.start();



    }

    private void updateInfo() {
        long totalSeconds = gameTimer.getCurrentTime();

        //calculate minutes and seconds
        long minutes = (totalSeconds / 60) % 60;
        long seconds = totalSeconds % 60;

        //stores and displays the timer to the label(yes the syntax for String.format is so weird)
        String timeString = String.format("%02d:%02d", minutes, seconds);
        timeLabel.setText(timeString);

        //after a certain number of seconds, increase the age by 1
        //there also was a problem with the age imcreasing by too much since technically, there is a 10 miliseocnd delay,
        //the total amount of seconds is a mod of 5 for 100 intervals.
        // I fixed this by using lastAgedSecond to make sure that .age isn't incremented if its already been incremented.
        // I also added totalSeconds > 0 as it keps on adding 1 every time it started, so it would display 19 at first.
        if (totalSeconds > 0 && (totalSeconds % 15 == 0) && totalSeconds != lastAgedSecond){
            ageReference.age += 1;
            ageLabel.setText("Age: " + (this.ageReference.age));

            lastAgedSecond = totalSeconds;
        }

        //functionality for displaying the value of money
        moneyLabel.setText("Money: $" + this.moneyValue.getMoneyCount());



        //testing purposes
        //System.out.println("AGE: " + this.ageReference.age);

    }
}
