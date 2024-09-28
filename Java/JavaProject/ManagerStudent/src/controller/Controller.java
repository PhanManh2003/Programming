/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.ManagerStudent;
import business.StudentInputter;
import entity.Course;
import entity.Student;
import java.util.ArrayList;
import utils.Validator;

/**
 *
 * @author win
 */
public class Controller {

    private ManagerStudent manager;
    private StudentInputter inputter;

    //getter setter constructer
    public Controller() {
        manager = new ManagerStudent();
    }

    public ManagerStudent getManager() {
        return manager;
    }

    public void setManager(ManagerStudent manager) {
        this.manager = manager;
    }

    public void generateStudent() throws Exception {
        manager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.JAVA));
        manager.add(new Student("s1", "Nguyen Quan", "Fall2024", Course.JAVA));
        manager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.C_CPP));
        manager.add(new Student("s1", "Nguyen Quan", "Fall2023", Course.DOTNET));
        manager.add(new Student("s2", "Tran Linh", "Sum2024", Course.JAVA));
        manager.add(new Student("s2", "Tran Linh", "Sum2024", Course.DOTNET));
        manager.add(new Student("s3", "Le Thu Thao", "Sum2024", Course.JAVA));
        manager.add(new Student("s4", "Le Phuong Minh", "Sum2024", Course.DOTNET));
        manager.add(new Student("s5", "Minh Vu", "Spring2023", Course.JAVA));
        manager.add(new Student("s6", "Tuan Minh", "Spring2023", Course.C_CPP));
    }

    public void create() throws Exception {
        while (true) {
            inputter = new StudentInputter();
            inputter.inputID();
            Student student = inputter.getStudent();
            // xử lí id và tên luôn là 1 cặp ko đổi 
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
            // add
            if (!manager.add(student)) {
                throw new Exception("Can not create Student!");
            }
            if (manager.getList().size() > 10) {
                String choice = Validator.getString("Do you continue ?(Y or N): ",
                        "Just Y or N!", "[YNyn]");
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    public void findAndSort() throws Exception {
        String name = Validator.getString("Enter name student: ", "Invalid!",
                "[A-Za-z\\s]+");
        ArrayList<Student> list = manager.getListStudentByName(name);
        if (list.isEmpty()) {
            throw new Exception("student name not found!");
        }
        // display
        ManagerStudent result = new ManagerStudent();
        result.setList(list);
        result.sortStudentsByName();
        System.out.println(result.toString());
    }

    public void updateOrDelete() throws Exception {
        // find and display
        String id = Validator.getString("Enter id: ", "Invalid!", "[Ss]\\d+");
        ArrayList<Student> list = manager.getListStudentById(id);
        if (list.isEmpty()) {
            throw new Exception("id not found!");
        }
        ManagerStudent result = new ManagerStudent();
        result.setList(list);
        System.out.println(result.toString());

        // choose student 
        int choice = Validator.getInt("Choose a student record with number: ",
                "Just be 1-> " + list.size(),
                "Invalid!", 1, list.size());
        Student student = list.get(choice - 1);
        System.out.println(student);
        String answer = Validator.getString("Do you want Update(U) or Delete(D): ",
                "Just U or D", "[UDud]");
        // update or delete ?
        if (answer.equalsIgnoreCase("U")) {
            inputter = new StudentInputter();
            inputter.inputID();
            inputter.inputStudentName();
            inputter.inputSemester();
            inputter.inputCourseName();
            Student newStudent = inputter.getStudent();
            manager.update(student, newStudent);
            System.out.println("Update successsfully.");
        } else {
            manager.delete(student);
            System.out.println("Delete successfully.");
        }
    }

    public void report() throws Exception {
        String result = manager.report();
        if (result == null) {
            throw new Exception("List is empty!");
        }
        System.out.println(result);
    }

}
