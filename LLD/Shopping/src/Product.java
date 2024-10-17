class Product {
    private String productId;
    private String name;
    private ProductCategory category;
    private int availblequantity;
    private Account seller;
    private double price;
    private String description;

    public Product(String productId, String name, ProductCategory category, int availblequantity, double price, String description) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.availblequantity = availblequantity;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getAvailblequantity() {
        return availblequantity;
    }

    public Account getSeller() {
        return seller;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
