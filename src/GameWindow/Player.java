/* CSCI 185 M01
All
5/14/2026
*/
package GameWindow;

import javax.swing.*;
import java.awt.*;

public class Player extends JFrame{
    //public static int age = 18;
    public static Player player;
    public static void main(String[] args){

        player = new Player();
        player.setTitle("Game of Life");
        player.setLayout(new BorderLayout());
        player.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        player.setSize(1500, 1500);
        player.setLocationRelativeTo(null);

        CookieClickerPanel cookieClickerPanel = new CookieClickerPanel();
        player.add(cookieClickerPanel, BorderLayout.CENTER);

        player.add(new Upgrades(), BorderLayout.EAST);



        player.setVisible(true);

    }

    public static void destroyWindow(){
        player.dispose();
    }



}