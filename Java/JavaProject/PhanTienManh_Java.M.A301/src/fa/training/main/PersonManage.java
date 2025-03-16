package fa.training.main;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.utils.Validator;
import java.util.ArrayList;

public class PersonManage {

    // main gọi menu()
    // menu(): inputData(),  updateStudent(), displayHighSalaryTeachers(); 
    private static ArrayList<Person> people = new ArrayList<>();

    ;

    public static void main(String[] args) {
        menu();
    }

    // menu
    private static void menu() {
        while (true) {
            System.out.println("\n--- Person Management System ---");
            System.out.println("1. Input data");
            System.out.println("2. Update student by studentID");
            System.out.println("3. Display teachers with salary > $1000");
            System.out.println("4. Report students who passed the course");
            System.out.println("0. Exit");
            int choice = Validator.getInt("Enter your choice: ",
                    "Invalid option!",
                    "Please enter a valid integer!",
                    0, 4);

            switch (choice) {
                case 1 ->
                    inputData();
                case 2 ->
                    updateStudent();
                case 3 ->
                    displayHighSalaryTeachers();
                case 4 ->
                    reportPassedStudents();
                case 0 -> {
                    System.out.println("Exiting program...");
                    return;
                }
            }
        }
    }

    // business functions
    private static void generateDefault() {
        // Create default data
        people.add(new Student("Alice", "F", "0123456789",
                "alice@mail.com", "01/01/2000", "S001", 8, 9));
        people.add(new Teacher("Bob", "M", "0987654321",
                "bob@mail.com", "15/05/1980", 500, 200));
        people.add(new Student("Charlie", "M", "0234567890",
                "charlie@mail.com", "12/12/2001", "S002", 8.6, 7));
        people.add(new Teacher("David", "M", "0345678901",
                "david@mail.com", "20/07/1975", 2000, 300));
        people.add(new Student("Eve", "F", "0456789012",
                "eve@mail.com", "14/03/1999", "S003", 4, 5));
        people.add(new Teacher("Frank", "M", "0567890123",
                "frank@mail.com", "10/11/1982", 1800, 250));
        people.add(new Student("Grace", "F", "0678901234",
                "grace@mail.com", "05/08/2000", "S004", 4, 5));
        people.add(new Teacher("Hank", "M", "0789012345",
                "hank@mail.com", "02/02/1985", 2200, 350));
        people.add(new Student("Ivy", "F", "0890123456",
                "ivy@mail.com", "11/11/2002", "S005", 4, 5));
        people.add(new Teacher("Jack", "M", "0901234567",
                "jack@mail.com", "25/01/1979", 1700, 200));
    }

    private static void inputData() {

        //  generateDefault(); test thử
        System.out.println("1. Create Student");
        System.out.println("2. Create Teacher");
        System.out.println("0. Back to Menu");
        int choice = Validator.getInt("Enter your choice: ",
                "Invalid option!",
                "Please enter a valid integer!", 0, 2);

        switch (choice) {
            case 1 -> {
                // Create a student
                boolean isDuplicate = true;
                while (isDuplicate) {
                    Student student = createStudent();
                    // Check for duplicate student ID
                    isDuplicate = false;
                    for (Person person : people) {
                        if (person instanceof Student) {
                            Student existingStudent = (Student) person;
                            if (existingStudent.getStudentID().
                                    equalsIgnoreCase(student.getStudentID())) {
                                System.out.println("Student ID already exists! Please enter a different ID.");
                                isDuplicate = true;
                                break;
                            }
                        }
                    }
                    if (!isDuplicate) {
                        people.add(student); // Add student if no duplicates
                        System.out.println("Student added successfully!");
                    }
                }
            }
            case 2 -> {
                // Create a teacher
                Teacher teacher = createTeacher();
                people.add(teacher); // Add teacher
                System.out.println("Teacher added successfully!");
            }
            case 0 -> {
                // Back to the menu
                return;
            }
        }

    }

    private static void updateStudent() {
        String studentID = Validator.getString("Enter student ID to update: ",
                "Invalid student ID!", ".+");

        for (Person person : people) {
            if (person instanceof Student && ((Student) person).getStudentID().
                    equalsIgnoreCase(studentID)) {
                Student student = (Student) person;
                System.out.println("Updating student: " + student.getName());
                student.setTheory(Validator.getDouble(
                        "Enter new theory: ",
                        "0-10 !", "Invalid mark!", 0, 10));
                student.setPractice(Validator.getDouble(
                        "Enter new practice: ",
                        "0-10 !", "Invalid mark!", 0, 10));
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void displayHighSalaryTeachers() {
        boolean hasHighSalaryTeacher = false;
        StringBuilder str = new StringBuilder();
        str.append(String.format("|%5s|%20s|%10s|%15s|%40s|%20s|%20s|%20s|\n",
                "No", "Name", "Gender", "Phone",
                "Email", "Basic Salary", "Subsidy", "Total Salary"));

        int count = 1;
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                double totalSalary = teacher.calculateSalary();
                if (totalSalary > 1000) {  // Only show teachers with total salary > 1000
                    hasHighSalaryTeacher = true;
                    str.append(String.format("|%5d|%20s|%10s|%15s|%40s|%20.2f|%20.2f|%20.2f|\n",
                            count++, teacher.getName(), teacher.getGender(), teacher.getPhone(),
                            teacher.getEmail(), teacher.getBasicSalary(),
                            teacher.getSubsidy(), totalSalary));
                }
            }
        }
        if (hasHighSalaryTeacher) {
            System.out.println(str.toString());
        } else {
            System.out.println("There's no high salary teacher");
        }
    }

    private static void reportPassedStudents() {
        boolean hasPass = false;
        StringBuilder str = new StringBuilder();
        str.append(String.format("|%5s|%20s|%10s|%15s|%20s|%15s|%15s|%15s|%15s|\n",
                "No", "Name", "Gender", "Phone", "Email",
                "Student ID", "Theory", "Practice", "Final Mark"));

        int count = 1;
        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                double finalMark = student.calculateFinalMark();
                if (finalMark >= 6) {  // Only show students who passed (final mark >= 6)
                    hasPass = true;
                    str.append(String.format("|%5d|%20s|%10s|%15s|%20s|%15s|%15.2f|%15.2f|%15.2f|\n",
                            count++, student.getName(), student.getGender(), student.getPhone(),
                            student.getEmail(), student.getStudentID(),
                            student.getTheory(), student.getPractice(), finalMark));
                }
            }
        }
        if (hasPass) {
            System.out.println(str.toString());
        } else {
            System.out.println("There's no passed student.");
        }
    }

    // hàm bổ trợ
    private static Student createStudent() {
        String name = Validator.getString("Enter name: ",
                "Invalid name!", ".+");
        String gender = Validator.getString("Enter gender (M/F): ",
                "Invalid gender! Please enter M or F.", "^[MF]$");
        String phone = Validator.getString("Enter phone: ",
                "must have 10 digits!", "\\d{10}");
        String email = Validator.getString("Enter email: ",
                "Invalid email!",
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        String birthDate = Validator.getString(
                "Enter birth date (dd/MM/yyyy): ",
                "Invalid date!", "\\d{2}/\\d{2}/\\d{4}");
        String studentID = Validator.getString("Enter student ID: ",
                "Invalid ID!", ".+");
        double theory = Validator.getDouble("Enter theory mark: ",
                "Out of range!",
                "Invalid mark!",
                0, 10);
        double practice = Validator.getDouble("Enter practice mark: ",
                "Out of range!",
                "Invalid mark!",
                0, 10);
        return new Student(name, gender, phone, email, birthDate,
                studentID, theory, practice);
    }

    private static Teacher createTeacher() {
        String name = Validator.getString("Enter name: ",
                "Invalid name!", ".+");
        String gender = Validator.getString("Enter gender (M/F): ",
                "Invalid gender! Please enter M or F.", "^[MF]$");
        String phone = Validator.getString("Enter phone: ",
                "must have 10 digits!", "\\d{10}");
        String email = Validator.getString("Enter email: ",
                "Invalid email!",
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        String birthDate = Validator.getString(
                "Enter birth date (dd/MM/yyyy): ",
                "Invalid date!", "\\d{2}/\\d{2}/\\d{4}");
        double basicSalary = Validator.getDouble("Enter basic salary: ",
                "Out of range!",
                "Invalid salary!",
                0, Double.MAX_VALUE);
        double subsidy = Validator.getDouble("Enter subsidy: ",
                "Out of range!",
                "Invalid subsidy!",
                0, Double.MAX_VALUE);
        return new Teacher(name, gender, phone, email,
                birthDate, basicSalary, subsidy);
    }

}
