package hw2;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {
    List<Product> productList;

    // 1. Товары хранятся в бине ProductRepository, в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
    @PostConstruct
    public void init() {
        productList = List.of(
                new Product(1, "Notebook Lenovo", 1000),
                new Product(2, "Notebook Dell", 900),
                new Product(3, "Notebook Acer", 1100),
                new Product(4, "Notebook HP", 800),
                new Product(5, "Notebook Asus", 600)
        );
    }

    // 2. ProductRepository позволяет получить весь список или один товар по id
    public Product getProductById(int id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
