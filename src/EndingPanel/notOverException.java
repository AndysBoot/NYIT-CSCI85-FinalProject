package EndingPanel;

public class notOverException extends RuntimeException {
    public notOverException(String message) {
        super(message);
        System.gc();
    }
}
