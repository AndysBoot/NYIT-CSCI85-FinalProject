/* CSCI 185 M01
Luis Martinez
5/14/2026
*/

package EndingPanel;

public class notOverException extends RuntimeException {
    public notOverException(String message) {
        super(message);
        System.gc();
    }
}
