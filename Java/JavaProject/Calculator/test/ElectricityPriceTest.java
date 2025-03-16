
import org.junit.Test;
import static org.junit.Assert.*;

public class ElectricityPriceTest {

    @Test
    public void testNoKwh() {
        assertEquals(0, ElectricityPrice.calculateTotalPrice(0), 0);
    }

    @Test
    public void testMidTier1() {
        assertEquals(200000, ElectricityPrice.calculateTotalPrice(200), 0);
    }

    @Test
    public void test500kwh() {
        assertEquals(500000, ElectricityPrice.calculateTotalPrice(500), 0);
    }

    @Test
    public void test501kwh() {
        assertEquals(751500, ElectricityPrice.calculateTotalPrice(501), 0);
    }

    @Test
    public void testMidTier2() {
        assertEquals(1200000, ElectricityPrice.calculateTotalPrice(800), 0);
    }

    @Test
    public void test1000kwh() {
        assertEquals(1500000, ElectricityPrice.calculateTotalPrice(1000), 0);
    }

    @Test
    public void test1001kwh() {
        assertEquals(2002000, ElectricityPrice.calculateTotalPrice(1001), 0);
    }

    @Test
    public void testMidTier3() {
        assertEquals(2690000, ElectricityPrice.calculateTotalPrice(1345), 0);
    }

    @Test
    public void test1500kwh() {
        assertEquals(3000000, ElectricityPrice.calculateTotalPrice(1500), 0);
    }

    @Test
    public void test1501kwh() {
        assertEquals(4503000, ElectricityPrice.calculateTotalPrice(1501), 0);
    }

    @Test
    public void testMidTier4() {
        assertEquals(6600000, ElectricityPrice.calculateTotalPrice(2200), 0);
    }
}
