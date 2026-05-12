/*
package GameWindow;
import java.time.Duration;
import java.time.Instant;

public class GameTimer {
    //instance fields for the current time
    public Instant gameStartTime;

    //Starts recording the time
    public GameTimer() {
        this.gameStartTime = Instant.now();

    }

    // i tried doing something with EpochMilli but didn't work, might save and use again later
    public long getStartTime(){
        return this.gameStartTime.toEpochMilli();
    }


    //displays how long the program has been running for
    public long getCurrentTime(){
        Instant currTime = Instant.now();
        long secondsElapsed = Duration.between(gameStartTime, currTime).toSeconds();
        System.out.println("secondsElapsed = "+ secondsElapsed);
        return secondsElapsed;
    }


}
*/