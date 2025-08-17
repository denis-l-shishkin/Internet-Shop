package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;
    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public boolean isEmpty() {
        return productsMap.isEmpty();
    }

    public void addProduct(Product product) {
        List<Product> products;
        if (!productsMap.containsKey(product.getName())) {
            products = new LinkedList<>();
            productsMap.put(product.getName(), products);
        } else {
            products = productsMap.get(product.getName());
        }
        products.add(product);
    }

    public int calculateTotalCost() {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
            return 0;
        }
        int totalCost = 0;
        for (List<Product> products: productsMap.values()) {
            for (Product product : products) {
                int cost = product.getPrice();
                totalCost += cost;
            }
        }
        return totalCost;
    }
    public int countIsSpecial() {
        int count = 0;
        for (List<Product> products: productsMap.values()) {
            for (Product product : products) {
                if (product.isSpecial() ) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printProductsInBasket() {
        for (List<Product> products: productsMap.values()) {
            for (Product product : products) {
                System.out.println(product);
                }
            }
        System.out.println("Итого: " + calculateTotalCost());
        System.out.println("Специальных товаров: " + countIsSpecial());
    }
    public boolean findProduct(String productName) {
        if (isEmpty()) {
            System.out.println("Корзина пуста!");
            return false;
        }
        for (List<Product> products: productsMap.values()) {
            for (Product product : products) {
                if (Objects.equals(product.getName(), productName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void cleanBasket() {
        productsMap.clear();
    }

    public List<Product> removeProduct(String productName) {
        List<Product> removeProducts = new ArrayList<>();
        for (List<Product> products: productsMap.values()) {
            for (Product product : products) {
                if (Objects.equals(product.getName(), productName)) {
                    products.remove(product);
                    removeProducts.add(product);
                }
            }
        }
        return removeProducts;
    }
}