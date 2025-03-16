package edu.fa.solid.ocp;

public class DiscountManager {

    public DiscountManager() {
    }
    public void processDiscount(Discount discount){
        System.out.println(discount.getDiscountDetails());
    }
}
