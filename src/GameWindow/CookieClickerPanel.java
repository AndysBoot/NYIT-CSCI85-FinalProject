package GameWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



public class CookieClickerPanel extends JPanel implements ActionListener {
    private JButton cookieBtn;

    //Static variables because it applies to the whole class not just one instance of cookieClickerpANEL
    private static int moneyCount = 0;

    //Default Constructor
    public CookieClickerPanel(){
        //A layout that centers the button by default

        //Adding an image and setting its size to be 200 x 200
        ImageIcon coinImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("coin.png")));
        Image scaled = coinImg.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        //Creates a button with a image that has no border displayed due to the methods
        JButton cookieBtn = new JButton(new ImageIcon(scaled));
        cookieBtn.setContentAreaFilled(false);
        cookieBtn.setFocusPainted(false);
        cookieBtn.setBorderPainted(false);

        //Listening for a mouseClick
        cookieBtn.addActionListener(this);
        //Add cookie button to the JPanel
        this.add(cookieBtn);

    }

    //Get method for moneyCount which can help display the total amount of money
    public static int getMoneyCount(){
        return moneyCount;
    }

    //set method to use in other classes that allows you to add more than 1 dollar
    public void setMoneyCount(int moneyCount){
        CookieClickerPanel.moneyCount = moneyCount;
    }

    //Method for other classes to add a custom amount of money or take away
    public void addMoney(int amount) {
        CookieClickerPanel.moneyCount += amount;
    }

    //Method that listens for a mouse click and increments the total money count by 1
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Clicked");
        moneyCount = moneyCount + 1;
        Upgrades.refreshMoney();
        System.out.println(getMoneyCount());

    }





}
