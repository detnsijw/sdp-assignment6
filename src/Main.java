import elements.CommercialLoanAccount;
import elements.SavingsAccount;
import structure.BankPortfolio;
import visitor.FinancialAuditVisitor;
import visitor.XmlExportVisitor;

public class Main {
    public static void main(String[] args) {
        BankPortfolio portfolio = new BankPortfolio();
        portfolio.addAccount(new SavingsAccount("SAV-1001", 15000.0, 0.04));
        portfolio.addAccount(new CommercialLoanAccount("LOAN-5002", 50000.0, 0.08, 1200.0));
        portfolio.addAccount(new SavingsAccount("SAV-1002", 8200.0, 0.035));

        System.out.println("EXECUTING FINANCIAL AUDIT VISITOR");
        FinancialAuditVisitor auditVisitor = new FinancialAuditVisitor();
        portfolio.acceptAll(auditVisitor);
        auditVisitor.printAuditSummary();

        System.out.println("EXECUTING XML EXPORT VISITOR");
        XmlExportVisitor xmlVisitor = new XmlExportVisitor();
        portfolio.acceptAll(xmlVisitor);
        System.out.println(xmlVisitor.getExportedXml());
    }
}