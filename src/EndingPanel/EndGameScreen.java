/* CSCI 185 M01
Arnel Jaen;Pharuns
5/14/2026
*/

package EndingPanel;

import GameWindow.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class EndGameScreen extends JFrame{
    private final JLabel gameover;
    private final JLabel moneyLabel;
    private final JLabel resultLabel;


    public EndGameScreen() {
        super("Ending Screen");
        gameover = new JLabel("GAME OVER");
        gameover.setFont(new Font("StarJedi.ttf", Font.PLAIN, 43));
        gameover.setForeground(Color.RED);
        gameover.setHorizontalAlignment(JTextField.CENTER);

        double totalMoney = readMoneyFile();

        moneyLabel = new JLabel("You made: " + totalMoney);
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 15));

        resultLabel = new JLabel(totalMoney > 1000000? "You won!" : "You lost :D");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));

        //btn.addActionListener(e -> Start());

        JPanel mainPanel = new JPanel(new BorderLayout());
        // JPanel infoPanel = new JPanel();
        //infoPanel.add(moneyLabel);
        //infoPanel.add(resultLabel);

        mainPanel.add(gameover, BorderLayout.CENTER);
        mainPanel.add(moneyLabel, BorderLayout.WEST);
        mainPanel.add(resultLabel, BorderLayout.EAST);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
    }

    private double readMoneyFile(){
        try{
            Scanner scan = new Scanner(new File("userGameInfo.txt"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                if(line.startsWith("Money:")){
                    return Double.parseDouble(line.replace("Money: ", "").trim());
                }

            }
            scan.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args){
        new EndGameScreen();

    }


}