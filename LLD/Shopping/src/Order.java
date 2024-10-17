import java.util.Date;

class Order {
    String orderNumber;
    String orderStatus;

    public Order(String orderNumber, String orderStatus, Date orderDate) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    Date orderDate;

    boolean makePayemnt(double amount) {
        System.out.println("Processing payment of $" + amount);
        return true; // Simulate successful payment
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
