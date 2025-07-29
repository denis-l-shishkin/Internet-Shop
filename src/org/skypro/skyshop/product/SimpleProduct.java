package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int simplePrice;

    public SimpleProduct(String name, int price){
        super(name);
        if (price >= 1) {
            this.simplePrice = price;
        } else {
            throw new IllegalArgumentException("Стоимость простого товара должна быть больше 0!");
        }

    }
    @Override
    public int getPrice() {
        return simplePrice;
    }
    @Override
    public String toString() {
        return
                name + " : " + simplePrice;
    }
    @Override
    public boolean isSpecial() {
        if (getClass() == SimpleProduct.class) {
            return false;
        } else {
            return true;
        }
    }
}
