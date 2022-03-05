/**
 * HW-06 Challenge -- Lending Calculator
 *
 * This homework includes classes Loan and LendingCalculator.
 * These classes will help a user determine their repayment options for potential loans.
 *
 * @author Advit Bhullar, L-24
 *
 * @version October 02, 2021
 *
 */
public class Loan {
    private double amount;
    private double rate;
    private int duration;
    private double monthlyPayment;

    public Loan(int duration, double rate, double amount) {
        this.duration = duration;
        this.rate = rate;
        this.amount = amount;
        monthlyPayment = this.calculateMonthlyPayment();
    }

    public int getDuration() {
        return duration;
    }

    public double getRate() {
        return rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculateMonthlyPayment() {
        // return monthlyPayment = amount * ((rate / 12) * Math.pow((1 + rate / 12), duration))
        // / (Math.pow((1 + rate / 12), duration) - 1);
        double monthlyPaymentPart1 = amount * ((rate / 12) * Math.pow((1 + rate / 12), duration));
        double monthlyPaymentPart2 = (Math.pow((1 + rate / 12), duration) - 1);
        monthlyPayment = monthlyPaymentPart1 / monthlyPaymentPart2;

        return monthlyPayment ;

    }

    public double calculateTotalInterest(boolean output) {
        double principal;
        double remaining = amount;
        double totalInterest = 0;
        if (output == true) {
            for (int i = 1; i <= duration; i++) {
                double interest = (rate / 12) * remaining;
                principal = monthlyPayment - interest;
                remaining = remaining - principal;
                System.out.printf("Payment: %d - Principal: %.2f - Interest: %.2f - Remaining: %.2f\n",
                        i, principal, interest, remaining);
                totalInterest += interest;
            }
            return totalInterest;
        } else {
            for (int i = 1; i <= duration; i++) {
                double interest = (rate / 12) * remaining;
                principal = monthlyPayment - interest;
                remaining = remaining - principal;
                totalInterest += interest;
            }
            return totalInterest;

        }

    }

    @Override
    public String toString() {
        return String.format("Amount: " + "%.2f" +
                " - Rate: " + "%.2f" +
                " - Duration: " + duration +
                " - Payment: " + "%.2f", amount , rate , monthlyPayment);
    }
}

