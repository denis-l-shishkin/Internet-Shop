package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        System.out.println("Наполнение корзины 1");
        Product product1 = new Product("Масло", 100);
        Product product2 = new Product("Хлеб", 40);
        Product product3 = new Product("Молоко", 80);
        Product product4 = new Product("Сыр", 180);
        Product product5 = new Product("Торт", 400);
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        ProductBasket basket2 = new ProductBasket();
        System.out.println("Наполнение корзины 2");
        basket2.addProduct(product1);
        basket2.addProduct(product2);
        basket2.addProduct(product3);
        basket2.addProduct(product4);

        System.out.println("Попытка добавить товар в полную корзину 1");
        Product product6 = new Product("Вино", 500);
        basket1.addProduct(product6);

        System.out.println("\nСодержимое корзины 1:");
        basket1.printProductsInBasket();

        System.out.println("\nСодержимое корзины 2:");
        basket2.printProductsInBasket();

        System.out.println("Стоимость корзины 1: " + basket1.calculateTotalCost());

        System.out.println("Поиск товара \"Хлеб\" в корзине 1, результат поиска \n" + basket1.findProduct("Хлеб"));

        System.out.println("Поиск товара \"Вино\" в корзине 1, результат поиска \n" + basket1.findProduct("Вино"));

        System.out.println("Очистка корзины 2");
        basket2.cleanBasket();

        System.out.println("\nСодержимое корзины 2 после очистки:");
        basket2.printProductsInBasket();

        System.out.println("Стоимость корзины 2 после очистки: ");
        System.out.println(basket2.calculateTotalCost());

        System.out.println("Поиск товара \"Хлеб\" в корзине 2, результат поиска:");
        System.out.println(basket2.findProduct("Хлеб"));
    }
}
