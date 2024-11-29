//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

interface PaymentGateway {
    void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " through Razorpay.");
    }
}

class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

abstract class Billing {
    protected PaymentGateway paymentGateway;

    public Billing(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    abstract void generateBill(double amount);
}

class SubscriptionBilling extends Billing {
    public SubscriptionBilling(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    void generateBill(double amount) {
        System.out.println("Generating subscription bill.");
        paymentGateway.processPayment(amount);
    }
}

class OneTimeBilling extends Billing {
    public OneTimeBilling(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    void generateBill(double amount) {
        System.out.println("Generating one-time bill.");
        paymentGateway.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        // Subscription billing with Razorpay
        Billing subscriptionBilling = new SubscriptionBilling(new RazorpayGateway());
        subscriptionBilling.generateBill(29.99);

        // One-time billing with Stripe
        Billing oneTimeBilling = new OneTimeBilling(new StripeGateway());
        oneTimeBilling.generateBill(100.00);
    }
}