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
        player.setSize(500, 500);
        player.setLocationRelativeTo(null);

        CookieClickerPanel cookieClickerPanel = new CookieClickerPanel();
        player.add(cookieClickerPanel, BorderLayout.CENTER);
        player.add(new CookieClickerPanel(), BorderLayout.CENTER);

        player.add(new Upgrades(), BorderLayout.EAST);




        player.setVisible(true);

    }

}