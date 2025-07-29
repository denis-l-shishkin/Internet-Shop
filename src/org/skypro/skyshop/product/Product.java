package org.skypro.skyshop.product;

import org.skypro.skyshop.seach.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return
                name;
    }
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getNameObject() {
        return name;
    }


}
