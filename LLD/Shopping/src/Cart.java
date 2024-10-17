import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

class Cart {
    private List<Item> items = new ArrayList<>();

    public boolean addProduct(Item item) {
        items.add(item);
        return true;
    }

    public boolean removeProduct(Item item) {
        items.remove(item);
        return true;
    }


    public boolean updateProductQuantity(Item itemrequest, int quantity) {
        Optional<Item> itemOptional = items.stream().filter(item -> item.getProductId().equals(itemrequest.getProductId())).findFirst();
        itemOptional.ifPresent(item -> item.setQuantity(quantity));
        return itemOptional.isPresent();
    }

    public void checkout(Customer customer) {
        Order order = new Order("ORDER123", "Pending", new Date());
        customer.setOrder(order);

        double totalAmount = calculateTotalAmount();
        if (order.makePayemnt(totalAmount)) {
            order.setOrderStatus("confirmed");
            updateInventory();
        }
    }

    private double calculateTotalAmount() {
        return items.stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }

    private void updateInventory() {
        // For each item in the cart, reduce the available quantity of the product
        items.forEach(item -> {
            // Simulating inventory reduction
            System.out.println("Reducing inventory for product: " + item.getProductId());
        });
    }

}
