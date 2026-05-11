package GameWindow;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame{
    protected int age;
    protected int money;
    protected JButton moneyButton;


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Game of Life Frame");
        frame.setLayout(new BorderLayout());
        GameTimer testing123 = new GameTimer();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        JPanel cookieClickerPanel = new CookieClickerPanel();
        frame.add(cookieClickerPanel);

        TimePanel timePanel = new TimePanel(testing123);
        frame.add(timePanel, BorderLayout.NORTH);




        frame.setVisible(true);


        //this is just for testing
        System.out.println("Start time: " + testing123.getStartTime());
        System.out.println("Current time: " + testing123.getCurrentTime());
        System.out.println("fghjk");

        Thread.sleep(3000);

        System.out.println("Start time: " + testing123.getStartTime());
        System.out.println("Current time: " + testing123.getCurrentTime());
    }

}
