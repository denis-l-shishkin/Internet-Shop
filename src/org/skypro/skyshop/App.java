package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.seach.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        System.out.println("Наполнение корзины 1");
        SimpleProduct product1 = new SimpleProduct("Масло", 100);
        FixPriceProduct product2 = new FixPriceProduct("Хлеб");
        DiscountedProduct product3 = new DiscountedProduct("Молоко", 80, 15);
        DiscountedProduct product4 = new DiscountedProduct("Сыр", 180, 20);
        SimpleProduct product5 = new SimpleProduct("Торт", 400);
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
        SimpleProduct product6 = new SimpleProduct("Вино", 500);
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

        SearchEngine engine = new SearchEngine();
        engine.add(product1);
        engine.add(product2);
        engine.add(product3);
        engine.add(product4);
        engine.add(product5);

        Article article1 = new Article("Java это круто!", "Написанную программу на Java можно запустить в любой ОС, поддерживающей JVM.");
        Article article2 = new Article("О пользе вина.", "Очень умеренное употребление алкоголя может оказывать защитное действие на сердце. В первую очередь это касается красного вина.");
        Article article3 = new Article("Искусственный интеллект Smart Engines.", "ИИ-помощника для проверки паспортов внедрили во Внуково.");
        Article article4 = new Article("Искусственный интеллект ChatGPT4.", "Нейросеть онлайн с искусственным интеллектом для текста и интеллектом для решения задач.");
        Article article5 = new Article("Искусственный интеллект ElevenLabs.", "Преобразование текста в реалистичную речь с помощью нейросети.");
        Article article6 = new Article("Искусственный интеллект ElavenLabs.", "Преобразование текста в реалистичную речь с помощью нейросети.");

        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article5);
        engine.add(article6);
        engine.add(article4);


        String query = "Хлеб";
        System.out.println("Поисковый запрос: " + query + "\n Найдено: " + engine.search(query));
        query = "Java";
        System.out.println("Поисковый запрос: " + query + "\n Найдено: " + engine.search(query));
        query = "интеллект";
        System.out.println("Поисковый запрос: " + query + "\n Найдено: " + engine.search(query));
        query = "вино";
        System.out.println("Поисковый запрос: " + query + "\n Найдено: " + engine.search(query));
        query = "вина";
        System.out.println("Поисковый запрос: " + query + "\n Найдено: " + engine.search(query));

        try {
            SimpleProduct product7 = new SimpleProduct("", 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            SimpleProduct product7 = new SimpleProduct("Огурцы", 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct product7 = new DiscountedProduct("Огурцы", 0, 15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct product7 = new DiscountedProduct("Огурцы", 80, 150);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            query = "интеллект";
            System.out.println("Поисковый запрос: " + query + "\n Найден наиболее подходящий результат: " + engine.searchTheBest(query));
            query = "солнце";
            System.out.println("Поисковый запрос: " + query + "\n Найден наиболее подходящий результат: " + engine.searchTheBest(query));
        } catch (BestResultNotFoundException e) {
            System.out.println(e);
        }

        basket1.printProductsInBasket();

        printRemoveProducts(basket1.removeProduct("Торт"));

        System.out.printf("Содержимое корзины после удаления продукта. \n");

        basket1.printProductsInBasket();

        printRemoveProducts(basket1.removeProduct("Манго"));

        basket1.printProductsInBasket();

    }
    public static void printRemoveProducts (List<Product> removeProducts) {
        List<Product> removeProducts1 = removeProducts;
        if (removeProducts1.isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println("Список удаленных продуктов: \n" + removeProducts1);
        }
    }
}
