/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

import java.util.ArrayList;
import validate.Validator;

/**
 *
 * @author manhpthe172481
 */
public class Student implements Comparable<Student> {

    private String ID;
    private String name;
    private int age;
    private double score;

    public Student(String ID, String name, int age, double score) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void getInformation(ArrayList<Student> listStudent) {
        boolean isDuplicate;
        do {
            isDuplicate = false;
            ID = Validator.getString("Enter ID: ",
                    "Please enter HExxxxxx (x is 0-9)!", "HE\\d{6}");
            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getID().equals(ID)) {
                    System.out.println("ID existed! Try again.");
                    isDuplicate = true;
                    break;
                }
            }
        } while (isDuplicate);
        name = Validator.getString("Enter name: ",
                "Name cannot be empty!", "^(?!\\s*$).+");
        age = Validator.getInt("Enter age: ", "Age must be >0",
                "Please enter integer number", 1, 100);
        score = Validator.getDouble("Enter score: ",
                "Please enter score 0-10!",
                "Enter a real number!", 0, 10);
    }

    @Override
    public int compareTo(Student anotherStudent) {
        if (score > anotherStudent.score) {
            return 1;
        } else if (score < anotherStudent.score) {
            return -1;
        } else {
            return 0;
        }
    }

}
