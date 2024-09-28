/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagement;

import java.util.ArrayList;

/**
 *
 * @author manhpthe172481
 */
public class StudentList extends ArrayList<Student> {

    public StudentList() {// default constructor
        super();
    }

    // Search a student based on input student's code
    public Student search(String code) {
        code = code.trim().toUpperCase();
        for (Student student : this) {
            if (student.getCode().equals(code)) {
                return student;
            }
        }
        return null; // not found
    }

    // Checking whether a code is duplicated or not
    private boolean isCodeDuplicated(String code) {
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent() {
        // Input 3 attribute of student and check
        String newCode, newName;
        int newMark;
        boolean codeDuplicated = false;
        do {
            newCode = Inputter.inputPattern("St. code s000: ", "[S][\\d]{3}");
            codeDuplicated = isCodeDuplicated(newCode);
            if (codeDuplicated) {
                System.out.println("Code is duplicated");
            }
        } while (codeDuplicated);

        newName = Inputter.inputNonBlankStr("Name of the student:");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);

        // Create new Student
        Student st = new Student(newCode, newName, newMark);
        // Add new Student to the list
        this.add(st);
        // Alert success
        System.out.println("Student" + newCode + " has been added");

    }

    public void searchStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No search can be performed!");
        } else {
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);
            if (st == null) {
                System.out.println("Student " + sCode + " doesn't existed!");
            } else {
                System.out.println("Found: " + st);
            }
        }
    }

    // Update a student based on student code
    public void updateStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String uCode = Inputter.inputStr("Input code of updated student: ");
            Student st = this.search(uCode);
            if (st == null) {
                System.out.println("Student " + uCode + " doesn't existed!");
            } else {
                // update student's name
                String oldName = st.getName();
                String msg = "Old name: " + oldName + ", new name:";
                String newName = Inputter.inputNonBlankStr(msg);
                st.setName(newName);
                // update student's score
                int oldMark = st.getMark();
                msg = "Old mark: " + oldMark + ", new mark:";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                // alert success
                System.out.println("Student " + uCode + " has been updated.");
            }
        }
    }

    // Remove a student based on student's code
    public void removeStudent() {
        if (this.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            String rCode = Inputter.inputStr("Input code of removed student: ");
            Student st = this.search(rCode);
            if (st == null) {
                System.out.println("Student " + rCode + " doesn't existed!");
            } else {
                this.remove(st);
                System.out.println("Student " + rCode + " has been removed.");
            }
        }
    }
    
    // List all student
    public void printAll(){
        if (this.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            for (Student st : this) {
                System.out.println(st);
            }
            System.out.println("Total: "+this.size()+" student(s).");
        }
    }
}
