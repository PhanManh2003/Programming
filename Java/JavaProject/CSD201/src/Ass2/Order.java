package Ass2;



public class Order {
//   pcode (string): the code of the product to be ordered.
//   ccode (string): the code of the customer.
//   quantity (integer): the number of  ordered products.
    String pcode;
    String ccode;
    int quantity;

    public Order() {
    }

    public Order(String pcode, String ccode, int quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" + "pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + '}';
    }
    
    
}
