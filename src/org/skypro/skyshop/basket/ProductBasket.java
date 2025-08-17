package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    private List<Product> products;
    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int calculateTotalCost() {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
            return 0;
        }
        int totalCost = 0;
        for (Product product : products) {
            int cost = product.getPrice();
            totalCost += cost;

        }
        return totalCost;
    }
    public int countIsSpecial() {
        int count = 0;
        for (Product product : products) {
            if (product.isSpecial() ) {
                count++;
            }
        }
        return count;
    }

    public void printProductsInBasket() {
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Итого: " + calculateTotalCost());
        System.out.println("Специальных товаров: " + countIsSpecial());
    }
    public boolean findProduct(String productName) {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
        }
        for (Product product : products) {
            if (Objects.equals(product.getName(), productName)) {
                return true;
            }
        }
        return false;
    }
    public void cleanBasket() {
        products.clear();
    }

    public List<Product> removeProduct(String productName) {
        List<Product> removeProducts = new ArrayList<>();
        for (Product product : products) {
            if (Objects.equals(product.getName(), productName)) {
                products.remove(product);
                removeProducts.add(product);
            }
        }
        return removeProducts;
    }
}