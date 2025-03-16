
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeSalaryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearOfService() {
        EmployeeSalary salaryCalculator = new EmployeeSalary();
        salaryCalculator.calculateSalary(-1, 50000, 4);
    }

    @Test
    public void testYearOfServiceGreaterThanTen() {
        EmployeeSalary salaryCalculator = new EmployeeSalary();
        double result = salaryCalculator.calculateSalary(11, 50000, 4);
        assertEquals(55000, result, 0);
    }

}
