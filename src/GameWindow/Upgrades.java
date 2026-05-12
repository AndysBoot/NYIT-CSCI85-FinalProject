package GameWindow;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Upgrades extends JPanel {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JLabel timerLabel;
    private int seconds = 0;
    private int minute = 0;
    private JLabel moneyLabel;
    public Upgrades(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        moneyLabel = new JLabel("Money: " + CookieClickerPanel.getMoneyCount());
        moneyLabel.setPreferredSize(new Dimension(150, 75));

        btn1 = createButton("Gold rush ", "GoldRush.png");
        btn2 = createButton("Cursed", "cursed.png" );
        btn3 = createButton("Entrapment", "entrapment.png" );
        btn4 = createButton("Heavenly Object ", "HeavenlyObj.png" );
        btn5 = createButton("Pot of Greed", "GreedPot.png" );

        this.add(btn1);
        this.add(Box.createVerticalStrut(15));
        this.add(btn2);
        this.add(Box.createVerticalStrut(15));
        this.add(btn3);
        this.add(Box.createVerticalStrut(15));
        this.add(btn4);
        this.add(Box.createVerticalStrut(15));
        this.add(btn5);
        createTimer();
        this.add(timerLabel);
        this.add(Box.createVerticalStrut(15));
        this.add(moneyLabel);



    }

    //Creating buttons using a method
    public JButton createButton(String text, String filePath){
        //ImageICon
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(filePath)));

        Image scaled = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);


        JButton btn = new JButton(text, new ImageIcon(scaled));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Times New Roman", Font.BOLD, 16 ));
        btn.setBackground(Color.black);
        btn.setPreferredSize(new Dimension(150, 75));

        return btn;
        }



    // Call this method to create and start the timer
    public void createTimer() {

        // Create JLabel
        timerLabel = new JLabel("Time: 0");
        timerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //Timer updates every one sec
        //From the java swing library
        Timer timer = new Timer(1000, e -> {
            seconds++;
            //converting seconds to min : sec
            minute = seconds / 60;
            //String.format("%02d:%02d", minutes, seconds);
            timerLabel.setText(String.format("Time: %02d:%02d", minute, seconds % 60));
        });

        timer.start();
    }


    }
