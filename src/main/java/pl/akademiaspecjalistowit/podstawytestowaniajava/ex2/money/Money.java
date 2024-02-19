package pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money;

import java.util.Objects;

public class Money {

    public final Currency currency;
    public Double amount;

    public Money(Currency currency, Double amount) {
        if(amount < 0){
            throw new MoneyException("Money cannot hold negative amount");
        }
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return currency == money.currency && Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
