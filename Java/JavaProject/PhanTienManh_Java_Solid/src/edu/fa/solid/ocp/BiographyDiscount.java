
package edu.fa.solid.ocp;

public class BiographyDiscount implements Discount{

    public BiographyDiscount() {
    }

    @Override
    public String getDiscountDetails() {
        return "Biography discount details"; 
    }
    
}
