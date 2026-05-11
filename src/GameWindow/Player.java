package GameWindow;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame{
    protected int age;
    protected int money;
    protected JButton moneyButton;



    public static void main(String[] args){
        JFrame frame = new JFrame("Game of Life Frame");
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        JPanel cookieClickerPanel = new CookieClickerPanel();
        frame.add(cookieClickerPanel);




        frame.setVisible(true);


    }

}
