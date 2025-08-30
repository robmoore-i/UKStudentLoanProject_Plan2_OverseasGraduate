package uk.org.studentloan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var exchangeRate = Double.parseDouble(args[0]);
        var repaymentThresholdGbp = Integer.parseInt(args[1]);
        var startYearOffset = Integer.parseInt(args[2]);
        var startBalance = Double.parseDouble(args[3]);
        var startMonthlyRepayment = Double.parseDouble(args[4]);

        int i = 5;
        var interestRateUpdatesByYearOffset = new ArrayList<Double>();
        while (i < args.length && args[i].contains(".")) {
            interestRateUpdatesByYearOffset.addLast(Double.parseDouble(args[i]));
            i++;
        }
        var salaryUpdatesByYearOffset = new ArrayList<Integer>();
        while (i < args.length) {
            salaryUpdatesByYearOffset.addLast(Integer.parseInt(args[i]));
            i++;
        }

        new StudentLoan(
            exchangeRate,
            repaymentThresholdGbp,
            startYearOffset,
            startBalance,
            startMonthlyRepayment,
            interestRateUpdatesByYearOffset.stream().mapToDouble(n -> n).toArray(),
            salaryUpdatesByYearOffset.stream().mapToInt(n -> n).toArray()
        ).payOff();
    }

    /**
     * This poorly models the repayment of a Plan 2 student loan by an overseas graduate.
     * <p>
     * It does not implement the information laid out in the README of this project, but
     * does give a rough idea of what a repayment schedule might approximately look like
     * in a model world.
     * <p>
     * The assumptions and inputs should be tuned to simulate different economic scenarios.
     */
    private static class StudentLoan {

        // Assumptions
        private static final double annualSalaryIncreaseRate = 1.04;
        private static final double annualInterestRateDecrease = 0.003;
        private static final double repaymentFromIncomeOverThresholdRate = 0.09;

        // Inputs
        private final double exchangeRate;
        private final int repaymentThresholdGbp;
        private int monthCounter;
        private double balance;
        private double monthlyRepayment;
        private double interestRate;
        private final double[] interestRateUpdatesByYearOffset;
        private final int[] salaryUpdatesByYearOffset;

        public StudentLoan(
            double exchangeRate,
            int repaymentThresholdGbp,
            int startYearOffset,
            double startBalance,
            double startMonthlyRepayment,
            double[] interestRateUpdatesByYearOffset,
            int[] salaryUpdatesByYearOffset
        ) {
            this.exchangeRate = exchangeRate;
            this.repaymentThresholdGbp = repaymentThresholdGbp;
            this.monthCounter = startYearOffset * 12;
            this.balance = startBalance;
            this.monthlyRepayment = startMonthlyRepayment;
            this.interestRate = interestRateUpdatesByYearOffset[0];
            this.interestRateUpdatesByYearOffset = interestRateUpdatesByYearOffset;
            this.salaryUpdatesByYearOffset = salaryUpdatesByYearOffset;
        }

        private void payOff() {
            var monthsUntilWriteOff = 12 * 30;

            var repaid = 0.0;
            while (balance > 0 && monthCounter < monthsUntilWriteOff) {
                if (balance < monthlyRepayment) {
                    monthlyRepayment = Math.ceil(balance);
                }
                repaid += monthlyRepayment;
                System.out.println("\nPaid £" + monthlyRepayment);
                var interestAdded = balance * interestRate / 12;
                System.out.println("Added interest £" + interestAdded);
                balance = balance + interestAdded - monthlyRepayment;
                System.out.println("Updated balance £" + balance);
                monthCounter++;

                if (monthCounter % 12 == 0 && balance > 0) {
                    int yearOffset = monthCounter / 12;
                    System.out.println("Date: April 20" + (22 + yearOffset));
                    interestRate = interestRateUpdatesByYearOffset(yearOffset);
                    System.out.println("Interest rate updated to " + interestRate);

                    var newSalary = salaryUpdatesByYearOffset(yearOffset);
                    System.out.println("Salary updated to " + newSalary);
                    monthlyRepayment = (newSalary * exchangeRate - repaymentThresholdGbp) * repaymentFromIncomeOverThresholdRate / 12;
                    System.out.println("Monthly repayment updated to " + monthlyRepayment);
                }
            }
            if (balance > 0) {
                System.out.println("Wrote off £" + balance);
            } else {
                System.out.println("Repaid loan after " + monthCounter + " months (~" + monthCounter / 12 + ") years");
                System.out.println("Total amount paid: £" + repaid);
            }
        }

        private double interestRateUpdatesByYearOffset(int yearOffset) {
            if (yearOffset < interestRateUpdatesByYearOffset.length) {
                return interestRateUpdatesByYearOffset[yearOffset];
            }
            var lastRate = interestRateUpdatesByYearOffset[interestRateUpdatesByYearOffset.length - 1];
            return lastRate - yearOffset * annualInterestRateDecrease;
        }

        private double salaryUpdatesByYearOffset(int yearOffset) {
            if (yearOffset < salaryUpdatesByYearOffset.length) {
                return salaryUpdatesByYearOffset[yearOffset];
            }
            var lastSalary = salaryUpdatesByYearOffset[salaryUpdatesByYearOffset.length - 1];
            return lastSalary * Math.pow(annualSalaryIncreaseRate, yearOffset);
        }
    }
}
