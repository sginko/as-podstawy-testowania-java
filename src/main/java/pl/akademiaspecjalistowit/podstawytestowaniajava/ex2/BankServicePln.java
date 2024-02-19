package pl.akademiaspecjalistowit.podstawytestowaniajava.ex2;

import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Currency;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Money;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.MoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankServicePln implements BankService {
    private List<Money> accountBalance;

    public BankServicePln() {
        this.accountBalance = new ArrayList<>();
    }

    @Override
    public Money withdrawMoney(Money amount) {
        if (accountBalance.isEmpty()) {
            throw new MoneyException("");
        }
        Money money = accountBalance.get(0);
        if (amount.amount > money.amount) {
            throw new MoneyException("Insufficient money on deposit");
        }
        if (!amount.currency.equals(Currency.PLN)) {
            throw new MoneyException("Deposit money with different account currency");
        }
        accountBalance.clear();
        accountBalance.add(new Money(Currency.PLN, money.amount - amount.amount));
        return amount;
    }

    @Override
    public void depositMoney(Money amount) {
        if (amount.amount > 5000) {
            throw new MoneyException("Cannot deposit over 5000 at once");
        }
        if (!amount.currency.equals(Currency.PLN)) {
            throw new MoneyException("Deposit money with different account currency");
        }
        if (accountBalance.isEmpty()) {
            accountBalance.add(new Money(Currency.PLN, 0.0));
        }
        Money money = accountBalance.get(0);
        accountBalance.clear();
        accountBalance.add(new Money(Currency.PLN, money.amount + amount.amount));
    }

    @Override
    public List<Money> checkBalance() {
        return accountBalance;
    }
}
