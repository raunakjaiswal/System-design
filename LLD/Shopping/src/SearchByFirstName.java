import java.util.List;
import java.util.Optional;

class SearchByFirstName implements ProductSearchStrategy {

    @Override
    public <T> Product Search(T name, List<Product> products) {
        if (!(name instanceof String)) {
            throw new IllegalArgumentException("search parameter must be String");
        }
        Optional<Product> product = products.stream().filter(item -> item.getName().startsWith((String) name)).findFirst();
        return product.orElse(null);
    }
}
