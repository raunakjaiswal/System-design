import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// search product using strategy
// singleton
class ProductManager {

    private static ProductManager instance;
    List<Product> products = new ArrayList<>();
    private static Lock mtx = new ReentrantLock();

    public static synchronized ProductManager getInstance() {
        if (instance == null) {
            mtx.lock();
            try {
                if (instance == null)
                    instance = new ProductManager();
            } finally {
                mtx.unlock();
            }
        }
        return instance;
    }

    private ProductManager() {//default
    }


    public Product searchProduct(String token, ProductSearchStrategy strategy) {
        return strategy.Search(token, products);
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }


}
