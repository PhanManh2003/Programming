
public class OrderCalculator {

    public static double calculateTotalPrice(double[] itemPrices, String customerType,
            boolean isVip, String discountCode) {
        if (itemPrices == null || itemPrices.length == 0) {
            throw new IllegalArgumentException("No items in the order");

        }
        double totalPrice = 0.0;
        for (double price : itemPrices) {
            if (price <= 0) {
                throw new IllegalArgumentException("Item price must be greater than zero");
            }
            totalPrice += price;
        }

        double discount = 0.0;
        if (isVip) {
            discount = 0.20;  // 20% discount for  vip customer
        } else if (customerType.equalsIgnoreCase("Regular")) {
            discount = 0.05;  // 5 % discount for regular customer
        }

        if (discountCode != null && !discountCode.isEmpty()) {
            if (discountCode.equals("SALE10")) {
                discount += 0.10; // additional 10% discount
            } else if (discountCode.equals("WELCOME5")) {
                discount += 0.05;
            }
        }
        double finalPrice = totalPrice * (1 - discount);
        return finalPrice < 0 ? 0 : finalPrice; // ensuring price does not go below 0
    }
    
    
    public static void main(String[] args) {    
        double []itemPrices = {100,200};
        String customerType = "";
        boolean isVip = false;
        String discountCode = "WELCOME5";
        double result = calculateTotalPrice(itemPrices, customerType, isVip, discountCode);
        System.out.println("final Price: "+ result);
    }
}
