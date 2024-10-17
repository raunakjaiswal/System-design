class Item {
    private String productId;
    private int quantity;
    private double price;

    public Item(Product product) {
        this.productId = product.getProductId();
        this.price = product.getPrice();
        this.quantity = 1;
    }

    public Item(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
