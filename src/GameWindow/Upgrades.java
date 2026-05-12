package GameWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class Upgrades extends JPanel implements ActionListener {
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JLabel timerLabel;
    private int seconds = 0;
    private int minute = 0;
    private static JLabel moneyLabel;


    public Upgrades(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(210, 180, 140));
        moneyLabel = createLabel("Money: " + CookieClickerPanel.getMoneyCount());
        btn1 = createButton("Gold rush ", "IMAGES/GoldRush.png");
        btn2 = createButton("Cursed", "IMAGES/cursed.png" );
        btn3 = createButton("Entrapment", "IMAGES/entrapment.png" );
        btn4 = createButton("Heavenly Object ", "IMAGES/HeavenlyObj.png" );
        btn5 = createButton("Pot of Greed", "IMAGES/GreedPot.png" );

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);

        this.add(btn1);
        this.add(Box.createVerticalStrut(15));
        this.add(btn2);
        this.add(Box.createVerticalStrut(15));
        this.add(btn3);
        this.add(Box.createVerticalStrut(15));
        this.add(btn4);
        this.add(Box.createVerticalStrut(15));
        this.add(btn5);
        this.add(Box.createVerticalStrut(15));
        createTimer();
        this.add(timerLabel);
        this.add(Box.createVerticalStrut(100));
        this.add(moneyLabel);


    }

    //Creating buttons using a method
    public JButton createButton(String text, String filePath){
        //ImageICon
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(filePath)));

        Image scaled = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);


        JButton btn = new JButton(text, new ImageIcon(scaled));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Merriweather", Font.BOLD, 16 ));
        btn.setForeground(Color.BLACK);
        btn.setBackground(Color.BLACK);   // background color
        btn.setOpaque(true);
        btn.setPreferredSize(new Dimension(200, 75));

        return btn;
        }


        public JLabel createLabel(String text) {

            JLabel label = new JLabel(text);
            label.setFont(new Font("Times New Roman", Font.BOLD, 18));
            label.setBackground(Color.black);

            label.setPreferredSize(new Dimension(150, 75));

            return label;

        }

    public static void refreshMoney(){
        moneyLabel.setText("Money: " + CookieClickerPanel.getMoneyCount());
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn1 && CookieClickerPanel.getMoneyCount() >= 15) {
            System.out.println("Purchased");
            CookieClickerPanel.addMoney(-15);
            int i = (int)(Math.random() * (50 - 1) + 1);
            CookieClickerPanel.addMoney(i);

        }

        else if (e.getSource() == btn2 && CookieClickerPanel.getMoneyCount() >= 50) {
            System.out.println("Cursed clicked");
            CookieClickerPanel.addMoney(-50);
            CookieClickerPanel.i++;


        }

        else if (e.getSource() == btn3 && CookieClickerPanel.getMoneyCount() >= 100) {
            System.out.println("Entrapment clicked");
            CookieClickerPanel.addMoney(-100);
        }

        else if (e.getSource() == btn4 && CookieClickerPanel.getMoneyCount() >= 200){
            System.out.println("Heavenly Object clciked");
            CookieClickerPanel.addMoney(-200);

        }

        else if (e.getSource() == btn5 && CookieClickerPanel.getMoneyCount() >= 500){
            System.out.println("Pot of greed was clicked");
            CookieClickerPanel.addMoney(-500);

        }
    }
}
