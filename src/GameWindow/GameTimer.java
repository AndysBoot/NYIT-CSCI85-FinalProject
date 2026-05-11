package GameWindow;
import java.time.Duration;
import java.time.Instant;

public class GameTimer {
    //instance fields for the current time
    public Instant gameStartTime;
    public Instant gameCurrentTime;

    public GameTimer() {
        this.gameStartTime = Instant.now();
        /*
        int i = 0;
        Instant end = null;
        try {
        while (i < 3) {
            Instant start = Instant.now();
            Thread.sleep(1000);
            end = Instant.now();
            System.out.println("Amount of seconds passed" + Duration.between(start, end).toSeconds());
            i++;
        }
    }
        catch(InterruptedException e){
        e.printStackTrace();
    }
        catch(Exception e){
        //this is here in case there's an error we don't know about
        e.printStackTrace();
    }

         */

    }


    public long getStartTime(){
        return this.gameStartTime.toEpochMilli();
    }

    public long getCurrentTime(){
        Instant currTime = Instant.now();
        long secondsElapsed = Duration.between(gameStartTime, currTime).toSeconds();
        System.out.println("secondsElapsed = "+ secondsElapsed);
        return secondsElapsed;
    }
}
