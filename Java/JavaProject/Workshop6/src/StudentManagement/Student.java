/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagement;

/**
 *
 * @author manhpthe172481
 */
public class Student {

    private String code, name;
    int mark;

    public Student() {
    }

    public Student(String code, String name, int mark) {
        this.code = code;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + mark;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }

    public void setName(String name) {
        name = name.trim().toUpperCase();
        if (name.length() > 0) {
            this.name = name;// check validity
        }
    }

    public void setMark(int mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark; // check validity
        }
    }

}
