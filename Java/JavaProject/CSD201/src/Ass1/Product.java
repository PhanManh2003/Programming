package Ass1;

public class Product {

    String pcode;
    String pro_name;
    int quantity;
    int saled;
    double price;

    // Constructor
    public Product() {
    }

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" + quantity + ", saled=" + saled + ", price=" + price + '}';
    }

}
