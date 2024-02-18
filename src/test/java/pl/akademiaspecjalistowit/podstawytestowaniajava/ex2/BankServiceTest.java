package pl.akademiaspecjalistowit.podstawytestowaniajava.ex2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Currency;
import pl.akademiaspecjalistowit.podstawytestowaniajava.ex2.money.Money;

class BankServiceTest {

    private BankService bankServiceSuT;


    @BeforeEach
//    void setUp() {
//        bankServiceSuT = new BankServicePln();
//    }

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

    }

    @Test
    public void should_not_allow_to_withdraw_money_on_debit() {

    }

    @Test
    public void balance_should_not_change_when_withdraw_failed() {

    }

    @Test
    public void should_not_allow_to_deposit_over_5000_at_once() {

    }

    @Test
    public void should_not_allow_to_withdraw_money_with_different_account_currency() {

    }

    @Test
    public void should_not_allow_to_deposit_money_with_different_account_currency() {

    }
}