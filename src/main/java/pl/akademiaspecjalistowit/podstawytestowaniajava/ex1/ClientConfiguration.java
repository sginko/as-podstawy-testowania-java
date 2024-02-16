package pl.akademiaspecjalistowit.podstawytestowaniajava.ex1;

import java.util.List;

public class ClientConfiguration {

    private List<PaymentType> supportedPaymentTypes;

    public void addPaymentType(PaymentType paymentType) {
        supportedPaymentTypes.add(paymentType);
    }

    public List<PaymentType> getSupportedPaymentTypes() {
        return List.copyOf(supportedPaymentTypes);
    }
}
