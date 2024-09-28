package Ass2;

public class Customer {
//  ccode (string): the code of the customer (this should be unique for the customer).
//  cus_name (string): the name of the customer.
//  phone (string): The phone number of the customer (must contain digits only).

    String ccode;
    String cus_name;
    String phone;

    public Customer() {
    }

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", cus_name=" + cus_name + ", phone=" + phone + '}';
    }

}
