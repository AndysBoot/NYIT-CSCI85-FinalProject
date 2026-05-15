/* CSCI 185 M01
Andy Sosa, (whoever did the base code please put your name here),
5/14/2026
*/

package EndingPanel;

import GameWindow.*;
import GameWindow.CookieClickerPanel;
import GameWindow.Player;
import GameWindow.Upgrades;
import InvestmentsWindow.investmentAccount;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ExitGame extends JFrame {
    private final int exitAge = 18;
    private JLabel gameinfo;
    private JLabel winInfo;
    private double totalMoney;
    private FileWriter writer;
    private File save;

    /*

    One possible thing to do is to create a reader function that goes through userGameInfo.txt, and prints the highest score
    to the player via exitFrame.

     */


    public ExitGame() throws notOverException  {
        this.setLayout(new BorderLayout());

        //we might not need this anymore since we only call this class once your age is = 80
        if(Upgrades.age < exitAge) {
            throw new notOverException("Age is " + exitAge);
        }

        // add up all the money made
        totalMoney = CookieClickerPanel.getMoneyCount();
        totalMoney += investmentAccount.totalInvestment();

        gameinfo = new JLabel("You made: " + (totalMoney));
        gameinfo.setFont(new Font("Times New Roman", Font.BOLD, 40));

        if(totalMoney > 1000000) {
            winInfo = new JLabel("You won!");
            this.winInfo.setFont(new Font("Times New Roman", Font.BOLD, 40));
        } else {
            winInfo = new JLabel("You lost :(");
            this.winInfo.setFont(new Font("Times New Roman", Font.BOLD, 40));
        }
        this.add(gameinfo);
        this.add(winInfo);

        saveGame();

        //creates the new frame to display player info
        JFrame exitFrame = new JFrame();
        exitFrame.setSize(500, 500);

        JPanel exitPanel = new JPanel();

        exitPanel.add(gameinfo);
        exitPanel.add(winInfo);
        exitFrame.add(exitPanel);
        exitFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        exitFrame.setVisible(true);

        System.out.println("TESTING TOTAL MONEY" + this.totalMoney);

    }

    public void saveGame() {
        try {
            //basic file i/o, just writing money
            //write other information as well if possible please
            writer = new FileWriter("userGameInfo.txt", true);
            writer.write("Money: " + totalMoney);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
