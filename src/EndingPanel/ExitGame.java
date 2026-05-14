package EndingPanel;

import GameWindow.CookieClickerPanel;
import GameWindow.Player;
import InvestmentsWindow.investmentAccount;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ExitGame extends JPanel {
    private final int exitAge = 80;
    private JLabel gameinfo;
    private JLabel winInfo;
    private double totalMoney;
    private FileWriter writer;
    private File save;
    public ExitGame() throws notOverException  {
        this.setLayout(new BorderLayout());

        if(Player.age < exitAge) {
            throw new notOverException("Age is " + exitAge);
        }
        // add up all the money made
        totalMoney = CookieClickerPanel.getMoneyCount();
        totalMoney += investmentAccount.totalInvestment();

        gameinfo = new JLabel("You made: " + (totalMoney));
        if(totalMoney < 1000000) {
            winInfo = new JLabel("You won!");
        } else {
            winInfo = new JLabel("You lost :(");
        }
        this.add(gameinfo);
        this.add(winInfo);
        saveGame();

    }

    public void saveGame() {
        try {
            save = new File("Game of Life: " + LocalDate.now());
            save.createNewFile();
            writer = new FileWriter(save);
            writer.write("Money: " + totalMoney);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
