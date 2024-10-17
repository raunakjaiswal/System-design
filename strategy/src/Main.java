//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PaypalPayemnt implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing PaypalPayemnt payment of $" + amount);
    }
}

class CryptoCurrencyPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing CryptoCurrencyPayment payment of $" + amount);
    }
}

class PaymentProcessor{
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(){
        this.paymentStrategy = null;
    }
    public void setPaymentStrategy(PaymentStrategy strategy){
        if(paymentStrategy!=null){
            paymentStrategy = null;
        }
        paymentStrategy = strategy;
    }
    public void processPayemnt(double amount){
        if(paymentStrategy!=null){
            paymentStrategy.processPayment(amount);
        }else{
            System.err.println("Payement strategy not set.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
          PaymentProcessor paymentProcessor = new PaymentProcessor();

          PaymentStrategy strategy = new CreditCardPayment();
          paymentProcessor.setPaymentStrategy(strategy);

          paymentProcessor.processPayemnt(100.5);

          strategy = new PaypalPayemnt();
          paymentProcessor.setPaymentStrategy(strategy);

          paymentProcessor.processPayemnt(250.5);
    }
}