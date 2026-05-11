package GameWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class CookieClickerPanel extends JPanel implements ActionListener {
    private int moneyCount = 1;

    public static void main(String[] args){
        JFrame frame = new JFrame("Cookie Clicker Panel");
        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        JPanel cookieClickerPanel = new CookieClickerPanel();
        frame.add(cookieClickerPanel);

        frame.setVisible(true);


    }

    public CookieClickerPanel(){
        this.setLayout(new GridBagLayout());

        ImageIcon coinImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("coin.png")));
        Image scaled = coinImg.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JButton cookieBtn = new JButton(new ImageIcon(scaled));
        cookieBtn.setContentAreaFilled(false);
        cookieBtn.setFocusPainted(false);
        cookieBtn.setBorderPainted(false);

        cookieBtn.addActionListener(this);

        this.add(cookieBtn);

    }

    public int getMoneyCount(){
        return this.moneyCount;
    }

    public void setMoneyCount(int moneyCount){
        this.moneyCount = moneyCount;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
        System.out.println();
    }
}
