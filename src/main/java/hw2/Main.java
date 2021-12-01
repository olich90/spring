package hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var cart1 = context.getBean(Cart.class);
        var cart2 = context.getBean(Cart.class);

        var productRepository = context.getBean(ProductRepository.class);

        // Список всех товаров из ProductRepository
        System.out.println(productRepository.getProductList());

        // 3. Написать консольное приложение, позволяющее управлять корзиной
        cart1.addProductById(1);
        cart1.addProductById(2);
        System.out.println(cart1);
        cart1.deleteProductById(1);
        System.out.println(cart1);

        cart2.addProductById(3);
        cart2.addProductById(4);
        cart2.addProductById(5);
        System.out.println(cart2);
        cart2.deleteProductById(5);
        System.out.println(cart2);

        context.close();
    }
}
