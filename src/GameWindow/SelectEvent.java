package GameWindow;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SelectEvent extends JPanel {
    //initializing the hashmap
    Map<Integer, RandomEvents> randomEventHashmap = new HashMap<>();

    public SelectEvent (){
        randomEventsList();
    }

    public void randomEventsList(){
        /*since we cant create dictionaries in java, we have to use a hashmap instead, but its basically a dict though
        the logic is we will have a hashmap with various ordered numeric keys.
        Also, please feel free to change some, I haven't tested out the logic for some of them so balancing might be an issue.
        I wasn't creative enough to add more so if you got more ideas please add.

        Also note, but to increase the chances of an event getting picked, just add a duplicate event. that's why some common evets have double entries.
         */

        //events that affect your balance(add or sub)
        //positive
        randomEventHashmap.put(1, new RandomEvents("You found a $100 on the floor", 100, 1.0, 0));
        randomEventHashmap.put(2, new RandomEvents("You found a $100 on the floor", 100, 1.0, 0));
        randomEventHashmap.put(3, new RandomEvents("You got a tax refund, enjoy your $1000", 1000, 1.0, 0));
        randomEventHashmap.put(4, new RandomEvents("You got a tax refund, enjoy your $1000", 1000, 1.0, 0));
        randomEventHashmap.put(5, new RandomEvents("YOU WON THE LOTTERY!!!!!!!", 1000000, 1.0, 0));
        randomEventHashmap.put(6, new RandomEvents("Birthday money from grandma, enjoy your $50", 50, 1.0, 0));
        randomEventHashmap.put(7, new RandomEvents("Birthday money from grandma, enjoy your $50", 50, 1.0, 0));
        randomEventHashmap.put(8, new RandomEvents("Birthday money from grandma, enjoy your $50", 50, 1.0, 0));
        randomEventHashmap.put(9, new RandomEvents("Your long lost relative dies... Enjoy your inheritance!", 25000, 1.0, 0));

        //negative
        randomEventHashmap.put(10, new RandomEvents("You broke your legs and now you need surgery, pay $10,000", -10000, 1.0, 0));
        randomEventHashmap.put(11, new RandomEvents("You got a speeding ticket, pay $100", -100, 1.0, 0));
        randomEventHashmap.put(12, new RandomEvents("Your pressed a link and got hacked, pay $1,000 for the ransomware", -1000, 1.0, 0));


        //events that affect your balance(percentage based)
        //positive
        randomEventHashmap.put(13, new RandomEvents("The stock market is booming!", 0, 1.2, 0));
        randomEventHashmap.put(14, new RandomEvents("The stock market is booming!", 0, 1.2, 0));
        randomEventHashmap.put(15, new RandomEvents("You gambled all of your money and won at a casino", 0, 1.5, 0));
        randomEventHashmap.put(16, new RandomEvents("You gambled all of your money and won at a casino", 0, 1.5, 0));
        randomEventHashmap.put(17, new RandomEvents("Uncle sam was feeling extra generous, enjoy your tax return", 0, 1.1, 0));

        //negative
        randomEventHashmap.put(18, new RandomEvents("You lost your money in crypto...", 0, 0.8, 0));
        randomEventHashmap.put(19, new RandomEvents("Divorced, your ex took hald of everything(including the kids", 0, 0.5, 0));
        randomEventHashmap.put(20, new RandomEvents("Uncle sam was feeling extra greedy this year, pay 20%", 0, 0.8, 0));

        //events that affect your clicks
        //positive
        randomEventHashmap.put(21, new RandomEvents("You just got promoted at your job, enjoy your $10,000 bonus and +10 clicks", 10000, 1, 10));
        randomEventHashmap.put(22, new RandomEvents("You just got promoted at your job, enjoy your $10,000 bonus and +10 clicks", 10000, 1, 10));
        randomEventHashmap.put(23, new RandomEvents("You got AI to increase your productivity, +5 clicks", 0, 1, 5));
        randomEventHashmap.put(24, new RandomEvents("You got AI to increase your productivity, +5 clicks", 0, 1, 5));
        //negative
        randomEventHashmap.put(25, new RandomEvents("You're getting burned out, - 1 clicks", 0, 1, -1));
        randomEventHashmap.put(26, new RandomEvents("You're getting burned out, - 1 clicks", 0, 1, -1));
        randomEventHashmap.put(27, new RandomEvents("Your cat spilled your coffee on your laptop, - 2 clicks", 0, 1, -2));



    }

    //picks a random number from 1 to max, and returns a randomEvent
    public RandomEvents selectEvent() {
        int min = 1;
        int max = randomEventHashmap.size(); // max is set to the total amount of elements in randomEventsList

        int randomEventNumber = (int) (Math.random() * (max - min + 1) + min);
        return randomEventHashmap.get(randomEventNumber);

        //formula to implement math.random pulled from stack overflow:
        //https://stackoverflow.com/questions/7922978/random-numbers-with-math-random-in-java

    }



}