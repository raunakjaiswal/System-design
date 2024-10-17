public class LocalPayment implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Local payment gateway: " + amount);
    }
}
