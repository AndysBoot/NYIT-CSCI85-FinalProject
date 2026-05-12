package GameWindow;
import InvestmentsWindow.IRA;
import InvestmentsWindow.investmentAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



public class Upgrades extends JPanel {
    public static int age = 18;

    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JLabel timerLabel;
    private int seconds = 0;
    private int minute = 0;
    private static JLabel moneyLabel;
    private JLabel ageLabel;
    private JLabel investmentLabel;
    private IRA retirement = new IRA(0);
    private JButton contributeBtn;
    private JTextField amtTxt;


    public Upgrades(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        moneyLabel = createLabel("Money: " + CookieClickerPanel.getMoneyCount());
        btn1 = createButton("Gold rush ", "IMAGES/GoldRush.png");
        btn2 = createButton("Cursed", "IMAGES/cursed.png" );
        btn3 = createButton("Entrapment", "IMAGES/entrapment.png" );
        btn4 = createButton("Heavenly Object ", "IMAGES/HeavenlyObj.png" );
        btn5 = createButton("Pot of Greed", "IMAGES/GreedPot.png" );

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
        ageLabel = createLabel("Age: " + this.age);
        this.add(ageLabel);
        investmentLabel = createLabel("Retirement: " + retirement.getBalance());
        this.add(investmentLabel);

        // Add investment stuff
        amtTxt = new JTextField();
        contributeBtn = new JButton("Contribute");
        contributeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CookieClickerPanel.getMoneyCount() < Integer.parseInt(amtTxt.getText())
                        ||
                        (Integer.parseInt(amtTxt.getText()) < 0 && Math.abs( Integer.parseInt(amtTxt.getText())) > retirement.getBalance() ) )
                    throw new overdraftException("Not enough funds");
                else {
                    CookieClickerPanel.addMoney((int) (-1.0 * Double.parseDouble(amtTxt.getText())));
                    retirement.contribute(Double.parseDouble(amtTxt.getText()));
                }
                investmentLabel.setText("Retirement: " + retirement.getBalance());
            }
        });
        this.add(amtTxt);
        this.add(contributeBtn);
        this.add(Box.createVerticalStrut(15));


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
            // periodic stuff
            refreshMoney();
            //increments the age every 3 seconds
            if(this.seconds % 3 == 0){
                this.age++;
                System.out.println(this.age);
                ageLabel.setText("Age: " + this.age);
                investmentAccount.yearlyCall();
                investmentLabel.setText("Retirement: " + retirement.getBalance());
            }
        });

        timer.start();
    }


    }
