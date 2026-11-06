package visitor;

import elements.CommercialLoanAccount;
import elements.SavingsAccount;

public class FinancialAuditVisitor implements AccountVisitor{
    private double totalAssets;
    private double totalLiabilities;

    @Override
    public void visit(SavingsAccount savingsAccount) {
        double projectedInterest = savingsAccount.getBalance() * savingsAccount.getInterestRate();
        double netValue = savingsAccount.getBalance() + projectedInterest;
        totalAssets += netValue;

        System.out.printf("[Audit] Savings Account %s | Balance: $%.2f | Projected Interest: $%.2f%n",
                savingsAccount.getAccountNumber(), savingsAccount.getBalance(), projectedInterest);
    }

    @Override
    public void visit(CommercialLoanAccount loanAccount) {
        double interest = loanAccount.getPrincipalDebt() * loanAccount.getInterestRate();
        double totalOwed = loanAccount.getPrincipalDebt() + interest + loanAccount.getPenaltyFee();
        totalLiabilities += totalOwed;

        System.out.printf("[Audit] Loan Account %s | Debt: $%.2f | Total Owed (Inc. Penalty): $%.2f%n",
                loanAccount.getAccountNumber(), loanAccount.getPrincipalDebt(), totalOwed);
    }

    public void printAuditSummary() {
        System.out.printf("AUDIT SUMMARY -> Total Assets: $%.2f | Total Liabilities: $%.2f | Net Position: $%.2f%n",
                totalAssets, totalLiabilities, (totalAssets - totalLiabilities));
    }
}
