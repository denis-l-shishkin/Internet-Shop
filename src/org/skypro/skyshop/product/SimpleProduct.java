package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int simplePrice;

    public SimpleProduct(String name, int price){
        super(name);
        this.simplePrice = price;
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
