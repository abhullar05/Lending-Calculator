import java.util.Scanner;
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

public class LendingCalculator {


    private static String welcomeMessage = "Welcome to the Lending Calculator!";
    private static String menu = "Menu";
    private static String initialMenu = "0. Quit\n1. Add a loan";
    private static String ongoingMenu = "0. Quit\n1. Modify Loan\n2. Calculate Total Interest";
    private static String exitMessage = "Thank you!";
    private static String durationMessage = "Enter the duration:";
    private static String rateMessage = "Enter the rate:";
    private static String amountMessage = "Enter the amount:";
    private static String amortizationPrompt = "Would you like to print the amortization schedule?";
    private static String amortizationMenu = "1. Yes\n2. No";
    private static String totalInterestMessage = "Total Interest: ";
    private static String errorMessage = "Error! Invalid input.";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selectedOption;
        int selectedOption2 = 0;
        int selectedOption3;

        System.out.println(welcomeMessage);
        System.out.println(menu);
        System.out.println(initialMenu);
        selectedOption = scan.nextInt();
        scan.nextLine();
        if (selectedOption == 1) {
            System.out.println(durationMessage);
            int duration = scan.nextInt();
            scan.nextLine();
            System.out.println(rateMessage);
            double rate = scan.nextDouble();
            scan.nextLine();
            System.out.println(amountMessage);
            double amount = scan.nextDouble();
            scan.nextLine();
            Loan l = new Loan(duration, rate, amount);
            l.calculateMonthlyPayment();
            System.out.println(l.toString());
            // System.out.printf("Amount: %.2f - Rate: %.2f - Duration: %d - Payment: %.2f\n",
            // amount, rate, duration, l.calculateMonthlyPayment());

            do {

                System.out.println(menu);
                System.out.println(ongoingMenu);
                selectedOption2 = scan.nextInt();
                scan.nextLine();
                if (selectedOption2 == 1) {
                    System.out.println(durationMessage);
                    l.setDuration(scan.nextInt());
                    scan.nextLine();
                    System.out.println(rateMessage);
                    l.setRate(scan.nextDouble());
                    scan.nextLine();
                    System.out.println(amountMessage);
                    l.setAmount(scan.nextDouble());
                    scan.nextLine();
                    l.calculateMonthlyPayment();
                    System.out.println(l.toString());

                    //System.out.printf("Amount: %.2f - Rate: %.2f - Duration: %d - Payment: %f\n",
                    // amount, rate, duration, l.calculateMonthlyPayment());
                } else if (selectedOption2 == 2) {
                    System.out.println(amortizationPrompt);
                    System.out.println(amortizationMenu);
                    selectedOption3 = scan.nextInt();
                    scan.nextLine();
                    if (selectedOption3 == 1) {
                        l.calculateTotalInterest(true);
                        System.out.printf("Total Interest: %.2f\n" , l.calculateTotalInterest(false));
                    } else if (selectedOption3 == 2) {
                        l.calculateTotalInterest(false);
                        System.out.printf("Total Interest: %.2f\n" , l.calculateTotalInterest(false));
                    }

                } else if (selectedOption2 == 0)
                    System.out.println(exitMessage);
                else
                    System.out.println(errorMessage);
            } while(Double.valueOf(selectedOption2) == 1 || Double.valueOf(selectedOption2) == 2);



        } else if (selectedOption == 0)
            System.out.println(exitMessage);
        else
            System.out.println(errorMessage);


    }
}

