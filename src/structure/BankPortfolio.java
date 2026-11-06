package structure;

import elements.BankAccount;
import visitor.AccountVisitor;

import java.util.ArrayList;
import java.util.List;

public class BankPortfolio {
    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public void acceptAll(AccountVisitor visitor) {
        for (BankAccount account : accounts) {
            account.accept(visitor);
        }
    }
}
