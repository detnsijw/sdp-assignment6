package elements;

import visitor.AccountVisitor;

public class CommercialLoanAccount implements BankAccount{
    private final String accountNumber;
    private final double principalDebt;
    private final double interestRate;
    private final double penaltyFee;

    public CommercialLoanAccount(String accountNumber, double principalDebt,
                                 double interestRate, double penaltyFee) {
        this.accountNumber = accountNumber;
        this.principalDebt = principalDebt;
        this.interestRate = interestRate;
        this.penaltyFee = penaltyFee;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getPrincipalDebt() {
        return principalDebt;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getPenaltyFee() {
        return penaltyFee;
    }

    @Override
    public void accept(AccountVisitor visitor) {
        visitor.visit(this);
    }
}
