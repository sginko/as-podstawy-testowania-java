package pl.akademiaspecjalistowit.podstawytestowaniajava.ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    @Test
    void is_client_supported_payment_type() {

        //given
        String name = "TestName";
        PaymentType paymentType = PaymentType.BLIK;
        Client client = new Client(name);

        //when
        client.addSupportedPaymentType(paymentType);

        //then
        assertThat(client.getPaymentConfiguration().getSupportedPaymentTypes()).contains(paymentType);
    }

    @Test
    void is_client_has_configuration() {

        //given
        String name = "TestName";
        ClientConfiguration clientConfiguration;

        //when
        Client client = new Client(name);

        //then
        assertThat(client.getPaymentConfiguration()).isNotNull();
    }

    @Test
    void is_client_has_name() {

        //given
        String name = "TestName";

        //when
        Client client = new Client(name);

        //then
        assertThat(client.getClientName()).isEqualTo(name);
        assertThat(client.getClientName()).isNotNull();
    }
}
