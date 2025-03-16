package edu.fa.solid.ocp;

public class CookbookDiscount implements Discount {

    public CookbookDiscount() {
    }

    @Override
    public String getDiscountDetails() {
        return "Cookbook discount details";
    }

}
