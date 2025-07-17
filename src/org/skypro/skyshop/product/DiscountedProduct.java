package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountInPercent;

    public DiscountedProduct(String name, int basePrise, int discountInPercent) {
        super(name);
        this.basePrice = basePrise;
        this.discountInPercent = discountInPercent;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discountInPercent/100);
    }
    @Override
    public String toString() {
        return
                name + " : " + basePrice + "(" + discountInPercent + "%)";
    }
    @Override
    public boolean isSpecial() {
        if (getClass() == DiscountedProduct.class) {
            return true;
        } else {
            return false;
        }
    }
}
