
import org.junit.Test;
import static org.junit.Assert.*;

public class HappyRiceTest {

    @Test
    public void test9point9kg() {
        assertEquals(247500, HappyRice.calculateTotalPrice(9.9), 0);
    }

    @Test
    public void test10kg() {
        assertEquals(250000, HappyRice.calculateTotalPrice(10), 0);
    }

    @Test
    public void test10point1kg() {
        assertEquals(239875.0, HappyRice.calculateTotalPrice(10.1), 0);
    }

    @Test
    public void test49point9kg() {
        assertEquals(1185125.0, HappyRice.calculateTotalPrice(49.9), 0);
    }

    @Test
    public void test50kg() {
        assertEquals(1187500.0, HappyRice.calculateTotalPrice(50), 0);
    }

    @Test
    public void test50point1kg() {
        assertEquals(1127250.0, HappyRice.calculateTotalPrice(50.1), 0);
    }

    @Test
    public void test70kg() {
        assertEquals(1575000.0, HappyRice.calculateTotalPrice(70), 0);
    }

}
