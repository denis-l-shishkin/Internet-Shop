package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private Product[] products;
    public ProductBasket() {
        this.products = new Product[5];
    }

    public void addProduct(String productName, int productCost) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null!");
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = new Product(productName, productCost);
                System.out.println("Продукт " + productName + " добавлен в корзину");
                return;
            }
        }
        System.out.println("Невозможно добавить продукт!");
    }

    public int calculateTotalCost() {
        if(products == null || products.length == 0) {
            //throw new IllegalArgumentException("В корзине пусто!");
            System.out.println("В корзине пусто!");
            return 0;//добавил вывод и возврат 0 для продолжения работы программы
        }
        int totalCost = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                int cost = products[i].getProductCost();
                totalCost += cost;
            }
        }
        return totalCost;
    }

    public void printProductsInBasket() {
        if(products == null || products.length == 0) {
            System.out.println("В корзине пусто!");
        } else {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                }
            }
            System.out.println("Итого: " + calculateTotalCost());
        }
    }
    public boolean findProduct(String productName) {
        if(products == null || products.length == 0) {
            //throw new IllegalArgumentException("В корзине пусто!");
            System.out.println("В корзине пусто!");
            return false;//добавил вывод и возврат false для продолжения работы программы
        }
        for (int i = 0; i < products.length; i++) {
            if (Objects.equals(products[i].getProductName(), productName)) {
                return true;
            }
        }
        return false;
    }
    public void cleanBasket() {
        products = null;
    }
}