/* CSCI 185 M01
Luis Martinez
5/12/2026
 */

package InvestmentsWindow;

abstract class investmentAccount {
    double balance;
    double growthRate;
    abstract void withdrawlPenalty(double amount);

    public void contribute(double amount) {
        balance += amount;
    }

    public void annualGrowth() {
        balance += balance * growthRate;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public double getBalance() {
        return balance;
    }
}
