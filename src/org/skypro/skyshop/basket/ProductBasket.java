package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private Product[] products;
    public ProductBasket() {
        this.products = new Product[5];
    }

    public boolean isEmpty() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Продукт " + product.getName() + " добавлен в корзину");
                return;
            }
        }
        System.out.println("Невозможно добавить продукт!");
    }

    public int calculateTotalCost() {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
            return 0;
        }
        int totalCost = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                int cost = products[i].getCost();
                totalCost += cost;
            }
        }
        return totalCost;
    }

    public void printProductsInBasket() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + calculateTotalCost());
    }
    public boolean findProduct(String productName) {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && Objects.equals(products[i].getName(), productName)) {
                return true;
            }
        }
        return false;
    }
    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}