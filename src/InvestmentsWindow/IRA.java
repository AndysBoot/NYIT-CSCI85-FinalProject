/* CSCI 185 M01
Luis Martinez
5/12/2026
 */

package InvestmentsWindow;

import GameWindow.Upgrades;

// investments can later be refactored to any other type of investment account
public class IRA extends investmentAccount {
    public IRA(double balance) {
        this.balance = balance;
        growthRate = 0.07;
        list.add(this);
    }

    @Override
    public void withdrawlPenalty(double amount) {
        // basic stuff, expand on later
        balance -= amount;
        if(Upgrades.age < 60) {
            balance = balance * 0.9;
        }
    }

    public void contribute(double amount) {
        if(amount > 7500.0)
            return;
        balance += amount;
        if(balance < 0) {
            balance = 0;
        }
    }


}
