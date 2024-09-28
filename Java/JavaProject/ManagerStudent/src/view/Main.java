package view;

import business.ManagerStudent;
import business.StudentInputter;
import entity.Student;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Validator;

public class Main {

    public static void main(String[] args) {
        ManagerStudent manager = new ManagerStudent();
        StudentInputter inputter = new StudentInputter();
        String opinion;
        while (true) {
            int choice = Validator.getInt("WELCOME TO STUDENT MANAGEMENT\n"
                    + "1.  Create\n"
                    + "2.  Find and Sort\n"
                    + "3.  Update/Delete\n"
                    + "4.  Report\n"
                    + "5.  Exit\n"
                    + "Enter your choice: ", "Just be 1->5", "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    if (manager.isGenerated() == false) {
                        opinion = Validator.getString("Do you want to 10"
                                + " students by default? -> Answer: ",
                                "Just Y/y/N/n", "[YyNn]");
                        if (opinion.equalsIgnoreCase("y")) {
                            try {
                                manager.generateStudent();
                                manager.setGenerated(true);
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } else {
                        while (true) {
                            inputter.inputID();
                            Student student = inputter.getStudent();
                            //1. xử lí id và tên luôn là 1 cặp ko đổi 
                            if (manager.getListStudentById(student.getId()).isEmpty()) {
                                inputter.inputStudentName();
                            } else {
                                String name = manager.getListStudentById(student.getId())
                                        .get(0).getStudentName();
                                student.setStudentName(name);
                                System.out.println("Name: " + name);
                            }
                            inputter.inputSemester();
                            inputter.inputCourseName();
                            System.out.println("Add successfully.");

                            //2. add
                            try {
                                manager.add(student);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            if (manager.getList().size() > 10) {
                                opinion = Validator.getString("Do you want "
                                        + "to continue ?(Y or N): ",
                                        "Just Y or N!", "[YNyn]");
                                if (opinion.equalsIgnoreCase("N")) {
                                    break;
                                }
                            }
                        }
                    }

                    break;
                case 2:
                    String name = Validator.getString("Enter name student: ", "Invalid!",
                            "[A-Za-z\\s]+");
                    ArrayList<Student> list = manager.getListStudentByName(name);
                    if (list.isEmpty()) {
                        System.err.println("student name not found!");
                    } else {
                        // display
                        ManagerStudent result = new ManagerStudent();
                        result.setList(list);
                        result.sortStudentsByName();
                        System.out.println(result.toString());
                    }
                    break;
                case 3:
                    // find and display
                    String id = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
                    list = manager.getListStudentById(id);
                    if (list.isEmpty()) {
                        System.err.println("Id not found");
                    } else {
                        ManagerStudent result = new ManagerStudent();
                        result.setList(list);
                        System.out.println(result.toString());

                        // choose student 
                        choice = Validator.getInt("Choose a student record with number: ",
                                "Just be 1-> " + list.size(),
                                "Invalid!", 1, list.size());
                        Student student = list.get(choice - 1);
                        System.out.println(student);
                        String answer = Validator.getString("Do you want Update(U),"
                                + " Delete(D), Stop(S): ",
                                "Just U/D/S", "[UDudSs]");

                        // update or delete ?
                        if (answer.equalsIgnoreCase("U")) {
                            inputter = new StudentInputter();
                            inputter.inputID();
                            inputter.inputStudentName();
                            inputter.inputSemester();
                            inputter.inputCourseName();
                            Student newStudent = inputter.getStudent();
                            try {
                                manager.update(student, newStudent);
                                System.out.println("Update successsfully.");
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        } else if (answer.equalsIgnoreCase("D")) {
                            try {
                                manager.delete(student);
                                System.out.println("Delete successfully.");
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                    break;
                case 4:
                    String report = manager.report();
                    if (report == null) {
                        System.err.println("List is empty");
                    } else {
                        System.out.println(report);
                    }

                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

}
