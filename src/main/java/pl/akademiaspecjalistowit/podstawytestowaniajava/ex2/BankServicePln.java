package pl.akademiaspecjalistowit.podstawytestowaniajava.ex2;

import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Currency;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Money;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.MoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankServicePln implements BankService {
    private List<Money> accountBalance;
    private Money accountMoney;

    public BankServicePln() {
        this.accountBalance = new ArrayList<>();
        this.accountMoney = new Money(Currency.PLN, 0.0);
    }

    @Override
    public Money withdrawMoney(Money amount) {
        if (accountMoney.amount < amount.amount) {
            throw new MoneyException("Insufficient money on deposit");
        }
        if (!amount.currency.equals(Currency.PLN)) {
            throw new MoneyException("Deposit money with different account currency");
        }
//        accountMoney.amount = accountMoney.amount - amount.amount;
        accountMoney = new Money(Currency.PLN, accountMoney.amount - amount.amount);
        accountBalance.clear();
        accountBalance.add(accountMoney);
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
//        accountMoney.amount = accountMoney.amount + amount.amount;
        accountMoney = new Money(Currency.PLN, accountMoney.amount + amount.amount);
        accountBalance.clear();
        accountBalance.add(accountMoney);
    }

    @Override
    public List<Money> checkBalance() {
        return accountBalance;
    }
}
