package fa.training.entities;

public class Student extends Person {

    private String studentID;
    private double theory;
    private double practice;

    public Student() {
    }

    public Student(String name, String gender, String phone,
            String email, String birthDate,
            String studentID, double theory, double practice) {
        super(name, gender, phone, email, birthDate);
        this.studentID = studentID;
        this.theory = theory;
        this.practice = practice;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    @Override
    public void purchaseParkingPass() {
    }

    public double calculateFinalMark() {
        return (this.practice + this.theory) / 2;
    }
}
