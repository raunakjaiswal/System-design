import ThirdPartyPayment.ThirdPartyPaymentA;
import ThirdPartyPayment.ThirdPartyPaymentB;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ThirdPartyPaymentA thirdPartyPaymentA = new ThirdPartyPaymentA();
        PaymentProcessor paymentProcessor = new UniversalPayementAdapter(thirdPartyPaymentA);

        paymentProcessor.processPayment(120.2);

        ThirdPartyPaymentB thirdPartyPaymentB = new ThirdPartyPaymentB();
        PaymentProcessor paymentProcessorB = new UniversalPayementAdapter(thirdPartyPaymentB);

        paymentProcessorB.processPayment(1252);
    }
}