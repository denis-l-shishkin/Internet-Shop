package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.function.ToIntFunction;

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
        return productsMap.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public long countIsSpecial() {
        return productsMap.values().stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
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
        boolean result = productsMap.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> product.getName().equals(productName));
        return result;
    }
    public void cleanBasket() {
        productsMap.clear();
    }

    public List<Product> removeProduct(String productName) {
        List<Product> removeProducts = new ArrayList<>();
        if (productsMap.containsKey(productName)) {
            removeProducts = productsMap.remove(productName);
        }
        return removeProducts;
    }
}