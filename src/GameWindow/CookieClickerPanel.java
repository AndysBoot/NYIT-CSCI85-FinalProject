package GameWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



public class CookieClickerPanel extends JPanel implements ActionListener {
    private JButton cookieBtn;
    private static JTextArea randomEventsArea;
    private static SelectEvent eventSelector = new SelectEvent();

    static int clickValue = 1;
    //Static variables because it applies to the whole class not just one instance of cookieClickerpANEL
    private static int moneyCount = 0;
    //Default Constructor
    public CookieClickerPanel(){
        this.setLayout(new BorderLayout());
        //A layout that centers the button by default
        //this.setBackground(new Color(45, 90, 150));
        this.setBackground(new Color( 45, 90, 150));
        //Adding an image and setting its size to be 200 x 200
        ImageIcon coinImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("IMAGES/coin.png")));
        Image scaled = coinImg.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        //Creates a button with a image that has no border displayed due to the methods
        // I changed JButton cookieBtn to cookieBtn as it wasn't properly using/updating the instance field cookieBtn (andy)
        cookieBtn = new JButton(new ImageIcon(scaled));
        cookieBtn.setContentAreaFilled(false);
        cookieBtn.setFocusPainted(false);
        cookieBtn.setBorderPainted(false);

        //Listening for a mouseClick
        cookieBtn.addActionListener(this);
        //Add cookie button to the JPanel
        this.add(cookieBtn, BorderLayout.CENTER);


        //Adding randomEvents Panel to CookieClicke Panel

        randomEventsArea= new JTextArea("This is where you will see your random events occuring");
        //Formatting the text so it doesn't cut the words out(without this, the line doesn't wrap around)
        randomEventsArea.setLineWrap(true);
        randomEventsArea.setWrapStyleWord(true);
        //Makes the text pane uneditable by the user
        randomEventsArea.setEditable(false);
        randomEventsArea.setFocusable(false);
        randomEventsArea.setOpaque(false);
        //styling appearance
        randomEventsArea.setFont(new Font("Times New Roman", Font.BOLD, 18 ));
        randomEventsArea.setForeground(Color.WHITE);
        //adding to the core CookieClickerPanel GUI
        this.add(randomEventsArea, BorderLayout.SOUTH);


    }

    //Get method for moneyCount which can help display the total amount of money
    public static int getMoneyCount(){
        return moneyCount;
    }

    //set method to use in other classes that allows you to add more than 1 dollar
    public void setMoneyCount(int moneyCount){
        CookieClickerPanel.moneyCount = moneyCount;
    }

    //Method for other classes to add a custom amount of money or take away
    public static void addMoney(int amount) {
        CookieClickerPanel.moneyCount += amount;
    }


    //Method that listens for a mouse click and increments the total money count by 1
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("Clicked");

        CookieClickerPanel.moneyCount = moneyCount + clickValue;
        Upgrades.refreshMoney();
        System.out.println(getMoneyCount());

    }
    // Source - https://stackoverflow.com/a/19125833
// Posted by Maxim Shoustin, modified by community. See post 'Timeline' for change history
// Retrieved 2026-05-12, License - CC BY-SA 3.0

    //call this to generate the event, and update all values from the Player
    public static void generateNewEvent(){
        //generates the event and stores it as event
        RandomEvents event = eventSelector.selectEvent();

        //sets the text as the message of event
        randomEventsArea.setText(event.getRandomEventMessage());

        //increments player balance from event
        moneyCount = (int)((moneyCount + event.moneyChange) * event.multiplier);

        //increments cookie click value from event
        clickValue += event.clickChange;

        //refreshes balance for player(visualization)
        Upgrades.refreshMoney();
    }







}
