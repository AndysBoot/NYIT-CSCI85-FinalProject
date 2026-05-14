package GameWindow;

public class GameTimer {
    private final long startTime;
    private final long c = 1000000000;

    public GameTimer() {
        startTime = System.nanoTime();
    }

    public long getCurrentTime() {
        return (System.nanoTime() - startTime) / c;
    }
}
