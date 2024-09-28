package business;

import entity.Course;
import entity.Student;
import utils.Validator;

public class StudentInputter {

    private Student student;

    public StudentInputter() {
        student = new Student();
    }

    public void inputID() {
        student.setId(Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+"));
    }

    public void inputStudentName() {
        student.setStudentName(Validator.getString("Enter name student: ", "Invalid!", "[A-Za-z\\s]+"));
    }

    public void inputSemester() {
        student.setSemester(Validator.getString("Enter Semester: ", "Invalid!", "[A-Za-z\\d]+"));
    }

    public void inputCourseName() {
        int choice = Validator.getInt("Only three courses:\n"
                + "1-Java\n"
                + "2-.Net\n"
                + "3-C/C++\n"
                + "Enter your choice: ",
                "Please enter number 1->3", "Invalid", 1, 3);
        student.setCourseName(Course.getCourse(choice));
    }

    public Student getStudent() {
        return student;
    }
}
