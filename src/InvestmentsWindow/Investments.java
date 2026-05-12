/* CSCI 185 M01
Luis Martinez
5/12/2026
 */

package InvestmentsWindow;

// investments can later be refactored to any other type of investment account
public class Investments extends investmentAccount {
    public Investments(double balance) {
        this.balance = balance;
        growthRate = 0.07;
    }
    @Override
    public void withdrawlPenalty(double amount) {
        // basic stuff, expand on later
        balance -= amount;
        balance = balance * 0.9;
    }

}
