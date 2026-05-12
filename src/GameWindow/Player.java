package GameWindow;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame{
    public int age = 18;
    protected int money;
    protected JButton moneyButton;


    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        player.setTitle("Game of Life");
        player.setLayout(new BorderLayout());
        player.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        player.setSize(1500, 1500);
        player.setLocationRelativeTo(null);


        GameTimer gameTimer = new GameTimer();

        CookieClickerPanel cookieClickerPanel = new CookieClickerPanel();
        player.add(cookieClickerPanel, BorderLayout.CENTER);

        PlayerInfoPanel infoPanel = new PlayerInfoPanel(gameTimer, player, cookieClickerPanel);
        player.add(infoPanel, BorderLayout.NORTH);





        player.setVisible(true);


        //this is just for testing
        /*
        System.out.println("Start time: " + testing123.getStartTime());
        System.out.println("Current time: " + testing123.getCurrentTime());
        System.out.println("fghjk");

        Thread.sleep(3000);

        System.out.println("Start time: " + testing123.getStartTime());
        System.out.println("Current time: " + testing123.getCurrentTime());

         */
    }

}
