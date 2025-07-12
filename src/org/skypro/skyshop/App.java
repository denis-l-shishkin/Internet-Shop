package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        System.out.println("Наполнение корзины 1");
        basket1.addProduct("Масло", 100);
        basket1.addProduct("Хлеб", 40);
        basket1.addProduct("Молоко", 80);
        basket1.addProduct("Сыр", 180);
        basket1.addProduct("Торт", 400);
        ProductBasket basket2 = new ProductBasket();
        System.out.println("Наполнение корзины 2");
        basket2.addProduct("Масло", 100);
        basket2.addProduct("Хлеб", 40);
        basket2.addProduct("Молоко", 80);
        basket2.addProduct("Сыр", 180);

        System.out.println("Попытка добавить товар в полную корзину 1");
        basket1.addProduct("Конфеты", 150);

        System.out.println("\nСодердимое корзины 1:");
        basket1.printProductsInBasket();

        System.out.println("\nСодердимое корзины 2:");
        basket2.printProductsInBasket();

        System.out.println("Стоимость корзины 1: " + basket1.calculateTotalCost());

        System.out.println("Поиск товара \"Хлеб\" в корзине 1, результат поиска \n" + basket1.findProduct("Хлеб"));

        System.out.println("Поиск товара \"Вино\" в корзине 1, результат поиска \n" + basket1.findProduct("Вино"));

        System.out.println("Очистка корзины");
        basket2.cleanBasket();

        System.out.println("\nСодердимое корзины 2 после очистки:");
        basket2.printProductsInBasket();

        System.out.println("Стоимость корзины 2 после очистки: ");
        System.out.println(basket2.calculateTotalCost());

        System.out.println("Поиск товара \"Хлеб\" в корзине 2, результат поиска:");
        basket2.findProduct("Хлеб");
    }
}
