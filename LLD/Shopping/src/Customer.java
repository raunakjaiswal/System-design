class Customer {
    private Account account;
    private Cart cart = new Cart();
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer(Account account) {
        this.account = account;
    }

    public boolean addItemToCart(Product product) {
        return cart.addProduct(new Item(product));
    }

    public boolean addItemToCart(Item item) {
        return cart.addProduct(item);
    }

    public boolean removeItemFromCart(Item item) {
        return cart.removeProduct(item);
    }

    public Cart getCart() {
        return cart;
    }
}
