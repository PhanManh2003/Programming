package fa.training.entities;

public class Teacher extends Person {

    private double basicSalary;
    private double subsidy;

    public Teacher() {
    }

    public Teacher(String name, String gender, String phone, String email,
            String birthDate, double basicSalary, double subsidy) {
        super(name, gender, phone, email, birthDate);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    @Override
    public void purchaseParkingPass() {
    }

    public double calculateSalary() {
        return this.basicSalary + this.subsidy;
    }

    
    
}
