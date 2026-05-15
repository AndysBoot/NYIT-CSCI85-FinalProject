/* CSCI 185 M01
Andy Sosa, Tayebi Pranta
5/14/2026
*/
package GameWindow;
import EndingPanel.ExitGame;
import InvestmentsWindow.IRA;
import InvestmentsWindow.investmentAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class Upgrades extends JPanel{
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
    private Timer timer;

    // implementing Retirement panel with these instance fields
    private IRA retirement;
    private JTextField retirementAmount;



    public Upgrades() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        moneyLabel = createLabel("Money: $" + CookieClickerPanel.getMoneyCount());

        this.add(moneyLabel);

        ageLabel = createLabel("Age: " + age);
        this.add(ageLabel);

        btn1 = createButton("Gold rush ", "IMAGES/GoldRush.png");
        btn2 = createButton("Cursed", "IMAGES/cursed.png");
        btn3 = createButton("Entrapment", "IMAGES/entrapment.png");
        btn4 = createButton("Heavenly Object ", "IMAGES/HeavenlyObj.png");
        btn5 = createButton("Pot of Greed", "IMAGES/GreedPot.png");

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

        retirement = new IRA(0);
        JLabel enterInvestment = new JLabel("Invest in your IRA:");
        enterInvestment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        this.add(enterInvestment);

        retirementAmount = new JTextField();
        retirementAmount.setMaximumSize(new Dimension(150, 30));
        this.add(retirementAmount);

        //IRA retirement = new IRA(0);
        JButton investBtn = new JButton("Invest");
        investBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        investBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Double.parseDouble(retirementAmount.getText()) > CookieClickerPanel.getMoneyCount()) {
                        throw new overdraftException("Contributing too much");
                    }
                    if (Double.parseDouble(retirementAmount.getText()) < 0){
                        //added so the user can't give themselves money
                        throw new NegativeNumberException("Negative number");
                    }
                    // optimize
                    int tmpMoney = CookieClickerPanel.getMoneyCount();
                    tmpMoney -= (int) Double.parseDouble(retirementAmount.getText());
                    CookieClickerPanel.setMoneyCount(tmpMoney);
                    Upgrades.refreshMoney();
                    // end opp
                    retirement.contribute(Double.parseDouble(retirementAmount.getText()));
                    System.out.println(retirement.getBalance());
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    //to prevent the sys from crashing when anything but a number is entered
                }

            }
        });

        this.add(investBtn);
        createTimer();

    }



    //Creating buttons using a method
    public JButton createButton(String text, String filePath) {
        //ImageICon
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(filePath)));

        Image scaled = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);


        JButton btn = new JButton(text, new ImageIcon(scaled));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
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

    public static void refreshMoney() {
        moneyLabel.setText("Money: " + CookieClickerPanel.getMoneyCount());
    }



    // Call this method to create and start the timer
    public void createTimer() {

        // Create JLabel
        timerLabel = new JLabel("Time: 0");
        timerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        this.add(timerLabel);

        //Timer updates every one sec
        //From the java swing library
        this.timer = new Timer(1000, e -> {
            seconds++;
            //converting seconds to min : sec
            minute = seconds / 60;
            //String.format("%02d:%02d", minutes, seconds);
            timerLabel.setText(String.format("Time: %02d:%02d", minute, seconds % 60));

            //once the player reaches 80, exit the game and stop the timer
            if(age >= 80){
                this.timer.stop();
                new ExitGame();
                Player.destroyWindow();

            }


            //increments the age every 12 seconds
            if (this.seconds % 12 == 0) {

                this.age++;
                System.out.println(this.age);
                ageLabel.setText("Age: " + this.age);
                investmentAccount.yearlyCall();
                refreshMoney();

                //gives a "grace" period until the random events generate
                if (age >= 21) {
                    CookieClickerPanel.generateNewEvent();
                }

            }


        });

        timer.start();





}}