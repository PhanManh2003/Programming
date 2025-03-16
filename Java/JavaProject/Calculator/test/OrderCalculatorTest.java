
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderCalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNoItemsInOrder() {
        OrderCalculator calculator = new OrderCalculator();
        calculator.calculateTotalPrice(new double[]{}, "VIP", false, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testItemPriceZero() {
        OrderCalculator calculator = new OrderCalculator();
        calculator.calculateTotalPrice(new double[]{22, 0}, "VIP", false, null);
    }

    @Test
    public void testVipCustomerWithNoDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "VIP", true, null);
        assertEquals(240, total, 0.01);
    }

    @Test
    public void testVipCustomerWithTenPercentDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "VIP", true, "SALE10");
        assertEquals(210.0, total, 0.01);
    }

    @Test
    public void testVipCustomerWithFivePercentDiscountCode() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "VIP", true, "WELCOME5");
        assertEquals(225.0, total, 0.01);
    }

    @Test
    public void testRegularCustomerWithNoDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "Regular", false, null);
        assertEquals(285.0, total, 0.01);
    }

    @Test
    public void testRegularCustomerWithTenPercentDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "Regular", false, "SALE10");
        assertEquals(255.0, total, 0.01);
    }

    @Test
    public void testRegularCustomerWithFivePercentDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100, 200}, "Regular", false, "WELCOME5");
        assertEquals(270.0, total, 0.01);
    }

    @Test
    public void testNoRegularNoVipCustomerWithNoDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{0.01, 0.1}, "a", false, null);
        assertEquals(0.11, total, 0.01);
    }
    
     @Test
    public void testNoRegularNoVipCustomerWithTenPercentDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100,200}, "a", false, "SALE10");
        assertEquals(270.0, total, 0.01);
    }
    
     @Test
    public void testNoRegularNoVipCustomerWithFivePercentDiscount() {
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotalPrice(new double[]{100,200}, "a", false, "WELCOME5");
        assertEquals(285.0, total, 0.01);
    }

}
