//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PaymentGatewayManager {
    private static PaymentGatewayManager instance;

    private PaymentGatewayManager() {
        System.out.println("Payment Gateway Manager initialized.");
    }

    private static Lock mtx = new ReentrantLock();

    public static PaymentGatewayManager getInstance() {
        if (instance == null) { // first check without lock
            mtx.lock(); // Acquire a lock before creating the instance
            try {
                if (instance == null) {  // Double checking locking
                    instance = new PaymentGatewayManager();
                }
            } finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    public void processPayemnt(double amount) {
        System.out.println("Processing payment of $" + amount + " through the payment gateway.");
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentGatewayManager paymentGateway = PaymentGatewayManager.getInstance();

        paymentGateway.processPayemnt(100.0);

        // Attempt to create another instance (should return the existing instance)
        PaymentGatewayManager anotherPaymentGateway = PaymentGatewayManager.getInstance();

        // Check if both instances are the same.
        if (paymentGateway == anotherPaymentGateway) {
            System.out.println("Both instances are the same. Singleton pattern is working.");
        } else {
            System.out.println("Singleton pattern is not working correctly.");
        }
    }
}