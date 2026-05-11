package GameWindow;
import java.time.Duration;
import java.time.Instant;
public class GameTimer {
    //instance fields for the current time
    public Instant gameStartTime;
    public Instant gameCurrentTime;
    public GameTimer() {
        Instant gameStartTime = Instant.now();
        int i = 0;
        Instant end = null;
        try {
        while (i < 3) {
            Instant start = Instant.now();
            Thread.sleep(15000);
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

    long secondsElapsed = Duration.between(gameStartTime, end).toSeconds();
        System.out.println("secondsElapsed = "+secondsElapsed);
    }


    public Instant getStartTime(){
        return this.gameStartTime;
    }

    public Instant getCurrentTime(){
        return this.gameCurrentTime;
    }
}
