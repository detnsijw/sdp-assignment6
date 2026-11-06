package visitor;

import elements.CommercialLoanAccount;
import elements.SavingsAccount;

public class XmlExportVisitor implements AccountVisitor {
    private final StringBuilder xmlBuffer = new StringBuilder();

    public XmlExportVisitor() {
        xmlBuffer.append("<portfolio>\n");
    }

    @Override
    public void visit(SavingsAccount savingsAccount) {
        xmlBuffer.append("  <savingsAccount>\n")
                .append("    <accountNumber>").append(savingsAccount.getAccountNumber()).append("</accountNumber>\n")
                .append("    <balance>").append(savingsAccount.getBalance()).append("</balance>\n")
                .append("    <interestRate>").append(savingsAccount.getInterestRate()).append("</interestRate>\n")
                .append("  </savingsAccount>\n");
    }

    @Override
    public void visit(CommercialLoanAccount loanAccount) {
        xmlBuffer.append("  <commercialLoanAccount>\n")
                .append("    <accountNumber>").append(loanAccount.getAccountNumber()).append("</accountNumber>\n")
                .append("    <principalDebt>").append(loanAccount.getPrincipalDebt()).append("</principalDebt>\n")
                .append("    <interestRate>").append(loanAccount.getInterestRate()).append("</interestRate>\n")
                .append("    <penaltyFee>").append(loanAccount.getPenaltyFee()).append("</penaltyFee>\n")
                .append("  </commercialLoanAccount>\n");
    }

    public String getExportedXml() {
        return xmlBuffer.toString() + "</portfolio>";
    }
}
