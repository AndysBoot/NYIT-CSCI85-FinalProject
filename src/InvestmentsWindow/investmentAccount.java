/* CSCI 185 M01
Luis Martinez
5/12/2026

 */

package InvestmentsWindow;

import java.util.ArrayList;

public abstract class investmentAccount {
    static ArrayList<investmentAccount> list = new ArrayList<>(); // this list has every single investment account called
    double balance;
    double growthRate;
    abstract void withdrawalPenalty(double amount);

    public void contribute(double amount) {
        if(amount > 0)
            balance += amount;
        else {
            withdrawalPenalty(amount * -1.0);
        }
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

    public static double totalInvestment() {
        double ret = 0;
        for(investmentAccount inv : list) {
            ret += inv.getBalance();
        }
        return ret;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public double getBalance() {
        return balance;
    }
}
