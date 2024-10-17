import ThirdPartyPayment.ThirdPartyPaymentA;
import ThirdPartyPayment.ThirdPartyPaymentB;

public class UniversalPayementAdapter implements PaymentProcessor {

    Object paymentSystem;

    public UniversalPayementAdapter(Object paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    @Override
    public void processPayment(double amount) {
        if(paymentSystem instanceof ThirdPartyPaymentA){
            ((ThirdPartyPaymentA) paymentSystem).pay(amount);
        }
        else if(paymentSystem instanceof ThirdPartyPaymentB){
            ((ThirdPartyPaymentB)paymentSystem).makepayment(amount);
        }
    }
}
