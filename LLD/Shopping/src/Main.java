//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {

        ProductManager productManager = ProductManager.getInstance();

        //Create Product
        Product pA = new Product("p1", "apple", new ProductCategory("FRUITS", "red"), 5, 20, "nice product");
        productManager.addProduct(pA);

        Account account = new Account.AccountBuilder
                ("raunak", "password", "raunak kumar jaiswal")
                .setAddress("hajipur").setEmail("raunakjaiswa.hajipur@gmail.com").build();

        Customer customerA = new Customer(account);

        // customer will search the product
        Product selectedProduct = productManager.searchProduct("apple", new SearchByFirstName());
        System.out.println(selectedProduct);

        customerA.addItemToCart(selectedProduct);
        customerA.getCart().checkout(customerA);


    }
}