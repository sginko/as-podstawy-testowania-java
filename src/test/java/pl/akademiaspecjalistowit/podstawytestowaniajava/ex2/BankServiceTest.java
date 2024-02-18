package pl.akademiaspecjalistowit.podstawytestowaniajava.ex2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Currency;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Money;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.MoneyException;

class BankServiceTest {

    private BankService bankServiceSuT;

    @BeforeEach
    void setUp() {
        bankServiceSuT = new BankServicePln();
    }

    @Test
    public void should_deposit_money_successfully() {
        //given
        Money money = new Money(Currency.PLN, 14.5);

        //when
        bankServiceSuT.depositMoney(money);

        //then
        assertThat(bankServiceSuT.checkBalance()).isNotEmpty();
        assertThat(bankServiceSuT.checkBalance().get(0)).isEqualTo(money);
    }

    @Test
    public void should_withdraw_money_successfully() {
        //given
        Money money = new Money(Currency.PLN, 14.5);
        Money withdrawMoney = new Money(Currency.PLN, 14.0);
        Money checkMoney = new Money(Currency.PLN, 0.5);

        //when
        bankServiceSuT.depositMoney(money);
        bankServiceSuT.withdrawMoney(withdrawMoney);

        //then
        assertThat(bankServiceSuT.checkBalance().get(0)).isEqualTo(checkMoney);
    }

    @Test
    public void should_not_allow_to_withdraw_money_on_debit() {
        //given
        Money money = new Money(Currency.PLN, 14.5);
        Money withdrawMoney = new Money(Currency.PLN, 20.0);

        //when
        bankServiceSuT.depositMoney(money);

        //then
        assertThrows(MoneyException.class, () -> bankServiceSuT.withdrawMoney(withdrawMoney));
    }

    @Test
    public void balance_should_not_change_when_withdraw_failed() {
        //given
        Money money = new Money(Currency.PLN, 14.5);
        Money withdrawMoney = new Money(Currency.PLN, 20.0);

        //when
        bankServiceSuT.depositMoney(money);
        bankServiceSuT.withdrawMoney(withdrawMoney);

        //then
        assertThat(bankServiceSuT.checkBalance().get(0)).isEqualTo(money);
    }

    @Test
    public void should_not_allow_to_deposit_over_5000_at_once() {
        //given
        Money money = new Money(Currency.PLN, 5001.00);

        //when
        bankServiceSuT.depositMoney(money);

        //then
        assertThrows(MoneyException.class, () -> bankServiceSuT.depositMoney(money));
    }

    @Test
    public void should_not_allow_to_withdraw_money_with_different_account_currency() {
        //given
        Money money = new Money(Currency.PLN, 14.5);
        Money withdrawMoney = new Money(Currency.USD, 14.0);

        //when
        bankServiceSuT.depositMoney(money);
        bankServiceSuT.withdrawMoney(withdrawMoney);

        //then
        assertThrows(MoneyException.class, () -> bankServiceSuT.withdrawMoney(withdrawMoney));
    }

    @Test
    public void should_not_allow_to_deposit_money_with_different_account_currency() {
        //given
        Money money = new Money(Currency.PLN, 14.5);
        Money withdrawMoney = new Money(Currency.USD, 14.0);

        //when
        bankServiceSuT.depositMoney(money);
        bankServiceSuT.withdrawMoney(withdrawMoney);

        //then
        assertThrows(MoneyException.class, () -> bankServiceSuT.depositMoney(money));
    }
}