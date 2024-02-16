package pl.akademiaspecjalistowit.podstawytestowaniajava.ex1;

public class Client {

    private ClientConfiguration clientConfiguration;
    private final String clientName;

    public Client(String clientName)  {
        this.clientName = clientName;
        this.clientConfiguration = new ClientConfiguration();
    }

    public void addSupportedPaymentType(PaymentType paymentType){
        clientConfiguration.addPaymentType(paymentType);
    }

    public ClientConfiguration getPaymentConfiguration() {
        return clientConfiguration;
    }

    public String getClientName() {
        return clientName;
    }
}
