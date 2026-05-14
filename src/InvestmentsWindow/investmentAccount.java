/* CSCI 185 M01
Luis Martinez
5/12/2026

 */

package InvestmentsWindow;

import java.util.ArrayList;

public abstract class investmentAccount {
    static ArrayList<investmentAccount> list = new ArrayList<investmentAccount>(); // this list has every single investment account called
    double balance;
    double growthRate;
    abstract void withdrawlPenalty(double amount);

    public void contribute(double amount) {
        balance += amount;
    }

    public void annualGrowth() {
        this.balance += this.balance * this.growthRate;
    }

    public static void yearlyCall() {
        for(investmentAccount inv : list) {
            inv.annualGrowth();
        }
        System.gc(); // this method could be bad for memory
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public double getBalance() {
        return balance;
    }
}