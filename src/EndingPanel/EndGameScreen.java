package EndingPanel;

import GameWindow.*;

import javax.swing.*;
import java.awt.*;

class EndGameScreen extends JFrame{
    private final JLabel gameover;
    private final JButton btn;
    private final JLabel moneyLabel;
    private final JLabel resultLabel;


    public EndGameScreen(String moneyText, String resultText) {
        super("Ending Screen");
        gameover = new JLabel("GAME OVER");
        gameover.setFont(new Font("StarJedi.ttf", Font.PLAIN, 43));
        gameover.setForeground(Color.RED);
        gameover.setHorizontalAlignment(JTextField.CENTER);

        moneyLabel = new JLabel(moneyText);
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 15));

        resultLabel = new JLabel(resultText);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));

        btn = new JButton("RESTART");
        btn.setSize(new Dimension(120, 35));
        btn.setFont(new Font("Times New Roman", Font.PLAIN, 14));


        //  btn.addActionListener(e -> Start());

        JPanel mainPanel = new JPanel(new BorderLayout());
       // JPanel infoPanel = new JPanel();
        //infoPanel.add(moneyLabel);
        //infoPanel.add(resultLabel);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btn);

        mainPanel.add(gameover, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH );
        mainPanel.add(moneyLabel, BorderLayout.WEST);
        mainPanel.add(resultLabel, BorderLayout.EAST);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args){
        new EndGameScreen("you made: $4", "You Lost :(");
    }


}
