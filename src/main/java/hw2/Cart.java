package hw2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") // 4. При каждом запросе корзины из контекста, должна создаваться новая корзина
// 2. Создаем бин Cart, в который можно добавлять и удалять товары по id
public class Cart {
    // Внедрение в корзину бина ProductRepository
    private final ProductRepository productRepository;
    private final List<Product> products;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = new ArrayList<>();
    }

    public void addProductById(Integer id) {
        products.add(productRepository.getProductById(id));
    }

    public void deleteProductById(Integer id) {
        products.remove(productRepository.getProductById(id));
    }

    @Override
    public String toString() {
        return "Cart {products=" +
                products +
                '}';
    }
}
