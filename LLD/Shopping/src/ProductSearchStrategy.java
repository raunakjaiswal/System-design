import java.util.List;

interface ProductSearchStrategy {
    <T> Product Search(T searchBy, List<Product> products);
}
