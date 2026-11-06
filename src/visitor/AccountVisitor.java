package visitor;

import elements.CommercialLoanAccount;
import elements.SavingsAccount;

public interface AccountVisitor {
    void visit(SavingsAccount savingsAccount);
    void visit(CommercialLoanAccount commercialLoanAccount);
}
