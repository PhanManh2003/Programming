
import org.junit.Test;
import static org.junit.Assert.*;

public class TinhThueThuNhapTest {

    @Test
    public void testNoTax() {
        assertEquals(0, TinhThueThuNhap.TinhThueThuNhapCaNhan(0, 5000000), 0);
    }

    @Test
    public void testLowIncomeNoDependents() {
        assertEquals(250000, TinhThueThuNhap.TinhThueThuNhapCaNhan(0, 14000000), 0);
    }

    @Test
    public void testMidIncomeWithDependents() {
        assertEquals(150000, TinhThueThuNhap.TinhThueThuNhapCaNhan(1, 16000000), 0);
    }

    @Test
    public void testHighIncomeNoDependent() {
        assertEquals(2550000, TinhThueThuNhap.TinhThueThuNhapCaNhan(0, 26000000), 0.001);
    }
    
    @Test
    public void testHighIncomeWithDependent() {
        assertEquals(900000, TinhThueThuNhap.TinhThueThuNhapCaNhan(2, 26000000), 0.001);
    }
}
