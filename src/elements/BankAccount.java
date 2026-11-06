package elements;

import visitor.AccountVisitor;

public interface BankAccount {
    void accept(AccountVisitor visitor);
}
