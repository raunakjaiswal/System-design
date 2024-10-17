interface PaymentProcessor {
    void processPayemnt(double amount);
}

class LocalPaymentGatewey implements PaymentProcessor {
    @Override
    public void processPayemnt(double amount) {
        System.out.println("local payment gateway: " + amount);
    }
}

class ThirdPartyPayement {
    public void makePayment(double amount) {
        System.out.println("Third party payemnt gateway: " + amount);
    }
}

class PaymentAdapter implements PaymentProcessor {

    private ThirdPartyPayement razorpayThirdParty;

    public PaymentAdapter(ThirdPartyPayement razorpayThirdParty) {
        this.razorpayThirdParty = razorpayThirdParty;
    }

    @Override
    public void processPayemnt(double amount) {
        this.razorpayThirdParty.makePayment(amount);
    }
}


public class Main {
    public static void main(String[] args) {

        ThirdPartyPayement razorpay = new ThirdPartyPayement();
        PaymentProcessor paymentProcessor = new PaymentAdapter(razorpay);

        paymentProcessor.processPayemnt(100.2);
    }
}